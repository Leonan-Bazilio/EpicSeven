package com.EpicSeven.service;

import com.EpicSeven.entity.Artifact;
import com.EpicSeven.dto.ArtifactDTO;
import com.EpicSeven.entity.ArtifactAttributesLevel;
import com.EpicSeven.repository.ArtifactRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ArtifactService {
    
    @Autowired
    private ArtifactRepository artifactRepository;
    
    @Autowired
    private ArtifactAttributesLevelService attributesLevelService;
    
    public List<ArtifactDTO> getAllArtifacts(String lang){
        List<ArtifactDTO> artifactDTOList = new ArrayList<>();
        List<Artifact> artifacts = artifactRepository.findAll();
        for(Artifact artifact : artifacts){
            attributesLevelService.getAttributesLevelByArtifactIdAndLevel(artifact.getId(), 30)
                    .ifPresent(attributesLevel ->
                            artifactDTOList.add(new ArtifactDTO(artifact, attributesLevel, lang)));
        }
        return artifactDTOList;
    }
    public List<Artifact> getAllArtifactsFull(){
        
        return artifactRepository.findAll();
    }
    
    public ArtifactDTO getArtifactById(int artifactId, int level, String lang) {
        
        Artifact artifact = artifactRepository.findById(artifactId)
                .orElseThrow(() -> new EntityNotFoundException("Artifact not found with ID " + artifactId));
        ArtifactAttributesLevel attributes = attributesLevelService.getAttributesLevelByArtifactIdAndLevel(artifactId, level)
                .orElseThrow(() -> new EntityNotFoundException("Attributes not found for artifact ID " + artifactId + " at level " + level));
        
        return new ArtifactDTO(artifact, attributes, lang);
    }
    
    @Transactional
    public ArtifactDTO createArtifact(Artifact artifact, ArtifactAttributesLevel attributesLevel, String lang) {
        artifactRepository.save(artifact);
        attributesLevelService.createArtifactAttributesLevel(artifact.getId(), attributesLevel);
        return new ArtifactDTO(artifact, attributesLevel, lang);
    }
    
    @Transactional
    public ArtifactDTO updateArtifact(int artifactId, Artifact updatedArtifact, ArtifactAttributesLevel newAttributesLevel, String lang) {
        Artifact artifact = artifactRepository.findById(artifactId)
                .orElseThrow(() -> new EntityNotFoundException("Artifact not found with ID " + artifactId));
        
        if (updatedArtifact.getNamePt() != null) artifact.setNamePt(updatedArtifact.getNamePt());
        if (updatedArtifact.getNameEn() != null) artifact.setNameEn(updatedArtifact.getNameEn());
        if (updatedArtifact.getRestriction() != null) artifact.setRestriction(updatedArtifact.getRestriction());
        if (updatedArtifact.getRarityStars() > 0) artifact.setRarityStars(updatedArtifact.getRarityStars());
        if (updatedArtifact.getBackgroundPt() != null) artifact.setBackgroundPt(updatedArtifact.getBackgroundPt());
        if (updatedArtifact.getBackgroundEn() != null) artifact.setBackgroundEn(updatedArtifact.getBackgroundEn());
        if (updatedArtifact.getImageUrl() != null) artifact.setImageUrl(updatedArtifact.getImageUrl());
        
        ArtifactAttributesLevel updatedAttributes = attributesLevelService
                .updateArtifactAttributesLevel(artifactId, newAttributesLevel);
        
        artifactRepository.save(artifact);
        return new ArtifactDTO(artifact, updatedAttributes, lang);
    }
    
    
    @Transactional
    public void deleteArtifact(Integer artifactId) {
        try {
            attributesLevelService.deleteALlAttributeLevelByArtifactId(artifactId);
            Artifact artifact = artifactRepository.findById(artifactId)
                    .orElseThrow(() -> new EntityNotFoundException("Artifact not found with ID " + artifactId));
            artifactRepository.delete(artifact);
        } catch (Exception ex) {
            throw new RuntimeException("Failed to delete artifact with ID " + artifactId + ": " + ex.getMessage(), ex);
        }
    }
    
}
