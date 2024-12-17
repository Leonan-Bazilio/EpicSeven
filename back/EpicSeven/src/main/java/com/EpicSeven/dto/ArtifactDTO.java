package com.EpicSeven.dto;

import com.EpicSeven.entity.Artifact;
import com.EpicSeven.entity.ArtifactAttributesLevel;

public class ArtifactDTO {
    
    
    private int idArtifact;
    private String name;
    private String restriction;
    private byte rarityStars;
    private String background;
    private String imageUrl;
    
    
    
    private int level;
    private int attackBonus;
    private int healthBonus;
    private String description;
    
    
    public ArtifactDTO(Artifact artifact, ArtifactAttributesLevel attributesLevel, String language) {
        this.setIdArtifact(artifact.getId());
        this.setRarityStars(artifact.getRarityStars());
        this.setImageUrl( artifact.getImageUrl());
        this.setLevel( attributesLevel.getLevel());
        this.setAttackBonus( attributesLevel.getAttackBonus());
        this.setHealthBonus( attributesLevel.getHealthBonus());
        

        if (language.equals("pt")) {
            this.setName( artifact.getNamePt());
            this.setRestriction( artifact.getRestriction().getValuePortuguese());
            this.description = attributesLevel.getDescriptionPt();
            this.setBackground(artifact.getBackgroundPt());
        } else {
            this.setName( artifact.getNameEn());
            this.setRestriction( artifact.getRestriction().getValueEnglish());
            this.description = attributesLevel.getDescriptionEn();
            this.setBackground( artifact.getBackgroundEn());
        }
        
    }
    public int getHealthBonus() {
        return healthBonus;
    }
    
    public void setHealthBonus(int healthBonus) {
        this.healthBonus = healthBonus;
    }
    
    public int getAttackBonus() {
        return attackBonus;
    }
    
    public void setAttackBonus(int attackBonus) {
        this.attackBonus = attackBonus;
    }
    
    public String getBackground() {
        return background;
    }
    
    public void setBackground(String background) {
        this.background = background;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public int getIdArtifact() {
        return idArtifact;
    }
    
    public void setIdArtifact(int idArtifact) {
        this.idArtifact = idArtifact;
    }
    
    public String getImageUrl() {
        return imageUrl;
    }
    
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    
    public int getLevel() {
        return level;
    }
    
    public void setLevel(int level) {
        this.level = level;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public byte getRarityStars() {
        return rarityStars;
    }
    
    public void setRarityStars(byte rarityStars) {
        this.rarityStars = rarityStars;
    }
    
    public String getRestriction() {
        return restriction;
    }
    
    public void setRestriction(String restriction) {
        this.restriction = restriction;
    }
    
    
}

