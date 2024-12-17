package com.EpicSeven.controller;

import com.EpicSeven.dto.ArtifactRequestDTO;
import com.EpicSeven.entity.Artifact;
import com.EpicSeven.dto.ArtifactDTO;
import com.EpicSeven.entity.ArtifactAttributesLevel;
import com.EpicSeven.service.ArtifactService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/artifacts")
public class ArtifactController {
    
    @Autowired
    private ArtifactService artifactService;
    
    
    @GetMapping
    public ResponseEntity<List<ArtifactDTO>> getAllArtifacts(
            @RequestParam(defaultValue = "pt") String lang){
        List<ArtifactDTO> artifactDTOList = artifactService.getAllArtifacts(lang);
        return ResponseEntity.ok(artifactDTOList);
    }
    
    @GetMapping("/{artifactId}")
    public ResponseEntity<ArtifactDTO> getArtifactById(
            @PathVariable int artifactId,
            @RequestParam(defaultValue = "30") int level,
            @RequestParam(defaultValue = "pt") String lang) {
        
        ArtifactDTO artifact = artifactService.getArtifactById(artifactId,level,lang);
        return ResponseEntity.ok(artifact);
    }
    
    @PostMapping
    public ResponseEntity<ArtifactDTO> createArtifact(
            @RequestBody ArtifactRequestDTO artifactRequestDTO,
            @RequestParam(defaultValue = "pt") String lang){
        Artifact artifact = artifactRequestDTO.getArtifact();
        ArtifactAttributesLevel attributesLevel = artifactRequestDTO.getArtifactAttributesLevel();
        ArtifactDTO createdArtifact = artifactService.createArtifact(artifact,attributesLevel,lang);
        return ResponseEntity.status(201).body(createdArtifact);
    }
    
    @PatchMapping("/{artifactId}")
    public ResponseEntity<ArtifactDTO> updateArtifact(
            @PathVariable int artifactId,
            @RequestBody ArtifactRequestDTO artifactRequestDTO,
            @RequestParam(defaultValue = "pt") String lang){
        Artifact artifact = artifactRequestDTO.getArtifact();
        ArtifactAttributesLevel attributesLevel = artifactRequestDTO.getArtifactAttributesLevel();
        ArtifactDTO updatedArtifact = artifactService
                .updateArtifact(artifactId,artifact,attributesLevel,lang);
        return ResponseEntity.ok(updatedArtifact);
    }
    
    @DeleteMapping("/{artifactId}")
    public ResponseEntity<String> deleteArtifact(@PathVariable Integer artifactId) {
        try {
            artifactService.deleteArtifact(artifactId);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.status(404).body(ex.getMessage());
        } catch (Exception ex) {
            return ResponseEntity.status(500).body("An error occurred while deleting the artifact: " + ex.getMessage());
        }
    }
    
}
