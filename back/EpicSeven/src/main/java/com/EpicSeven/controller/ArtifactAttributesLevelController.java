package com.EpicSeven.controller;

import com.EpicSeven.dto.ArtifactAttributesLevelDTO;
import com.EpicSeven.entity.ArtifactAttributesLevel;
import com.EpicSeven.service.ArtifactAttributesLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ArtifactAttributes")
public class ArtifactAttributesLevelController {
    
    @Autowired
    ArtifactAttributesLevelService attributesLevelService;
    
    @GetMapping("/{artifactId}/levels")
    public ResponseEntity<List<ArtifactAttributesLevelDTO>> getAllAttributesLevelsByArtifactId(
            @PathVariable int artifactId){
        
        List<ArtifactAttributesLevel> attributesLevels = attributesLevelService
                .getAllAttributesLevelsByArtifactId(artifactId);
        
        List<ArtifactAttributesLevelDTO> attributesLevelsDTO = attributesLevels
                .stream().map(ArtifactAttributesLevelDTO::new).toList();
        return ResponseEntity.ok(attributesLevelsDTO);
    }
    
    @PostMapping("/{artifactId}/levels")
    public ResponseEntity<ArtifactAttributesLevelDTO> createArtifactAttributesLevel(
            @PathVariable int artifactId,
            @RequestBody ArtifactAttributesLevel attributesLevel){
        ArtifactAttributesLevel ArtifactAttributesLevel= attributesLevelService
                .createArtifactAttributesLevel(artifactId,attributesLevel);
        ArtifactAttributesLevelDTO  attributesLevelDTO = new ArtifactAttributesLevelDTO(ArtifactAttributesLevel);
        return  ResponseEntity.ok(attributesLevelDTO);
    }
    @PatchMapping("/{artifactId}/levels")
    public ResponseEntity<ArtifactAttributesLevelDTO> updateArtifactAttributesLevel(
            @PathVariable int artifactId,
            @RequestBody ArtifactAttributesLevel newAttributesLevel) {
        ArtifactAttributesLevel attributesLevel =attributesLevelService
                .updateArtifactAttributesLevel(artifactId, newAttributesLevel);
        
        ArtifactAttributesLevelDTO attributesLevelDTO = new ArtifactAttributesLevelDTO(attributesLevel);
        return ResponseEntity.ok(attributesLevelDTO);
    }
    
    @DeleteMapping("/{artifactId}/levels/{level}")
    public ResponseEntity<Void> deleteArtifactAttributesLevel(
            @PathVariable int artifactId,
            @PathVariable int level) {
        attributesLevelService.deleteAttributeLevel(artifactId,level);
        return ResponseEntity.noContent().build();
    }
    
}