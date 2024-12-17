package com.EpicSeven.service;

import com.EpicSeven.entity.Artifact;
import com.EpicSeven.entity.ArtifactAttributesLevel;
import com.EpicSeven.repository.ArtifactAttributesLevelRepository;
import com.EpicSeven.repository.ArtifactRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ArtifactAttributesLevelService {
    
    @Autowired
    ArtifactAttributesLevelRepository attributesRepository;
    
    @Autowired
    ArtifactRepository artifactRepository;
    
    public List<ArtifactAttributesLevel> getAllAttributesLevelsByArtifactId(int artifactId) {
        return attributesRepository.findByArtifactId(artifactId);
    }


    public Optional<ArtifactAttributesLevel> getAttributesLevelByArtifactIdAndLevel(int artifactId, int level) {
        return attributesRepository.findByArtifactIdAndLevel(artifactId, level);
    }
    
    @Transactional
    public ArtifactAttributesLevel createArtifactAttributesLevel(int artifactId, ArtifactAttributesLevel attributesLevel) {
        Optional<ArtifactAttributesLevel> existingAttributes = getAttributesLevelByArtifactIdAndLevel(artifactId, attributesLevel.getLevel());
        
        if (existingAttributes.isPresent()) {
            throw new IllegalArgumentException("Artifact attributes at this level already exist.");
        }
        
        Artifact artifact = artifactRepository.findById(artifactId)
                .orElseThrow(() -> new EntityNotFoundException("Artifact not found for ID: " + artifactId));
        
        attributesLevel.setArtifact(artifact);
        return attributesRepository.save(attributesLevel);
    }
    
    
    @Transactional
    public ArtifactAttributesLevel updateArtifactAttributesLevel
            (int artifactId,ArtifactAttributesLevel newAttributesLevel) {

        ArtifactAttributesLevel attributesLevel = attributesRepository
                .findByArtifactIdAndLevel(artifactId, newAttributesLevel.getLevel())
                .orElseThrow(() -> new EntityNotFoundException
                        ("Artifact Attributes not found for ID "
                                + artifactId + " at level " + newAttributesLevel.getLevel()));


        if (newAttributesLevel.getAttackBonus() != 0) attributesLevel.setAttackBonus(newAttributesLevel.getAttackBonus());
        if (newAttributesLevel.getHealthBonus() != 0) attributesLevel.setHealthBonus(newAttributesLevel.getHealthBonus());
        if (newAttributesLevel.getDescriptionPt() != null) attributesLevel.setDescriptionPt(newAttributesLevel.getDescriptionPt());
        if (newAttributesLevel.getDescriptionEn() != null) attributesLevel.setDescriptionEn(newAttributesLevel.getDescriptionEn());

        return attributesRepository.save(attributesLevel);
    }
    
    @Transactional
    public void deleteAttributeLevel(int artifactId, int level) {
        ArtifactAttributesLevel attributesLevel = attributesRepository
                .findByArtifactIdAndLevel(artifactId, level)
                .orElseThrow(() -> new EntityNotFoundException("Artifact attributes not found for artifact ID " + artifactId + " at level " + level));
        attributesRepository.delete(attributesLevel);
    }
    @Transactional
    public void deleteALlAttributeLevelByArtifactId(Integer artifactId) {
        List<ArtifactAttributesLevel> attributes = attributesRepository.findByArtifactId(artifactId);
        if (!attributes.isEmpty()) {
            attributesRepository.deleteAll(attributes);
        }
    }
}
