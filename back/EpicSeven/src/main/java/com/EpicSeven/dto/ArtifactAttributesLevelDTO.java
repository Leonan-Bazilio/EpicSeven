package com.EpicSeven.dto;

import com.EpicSeven.entity.ArtifactAttributesLevel;

public class ArtifactAttributesLevelDTO {
    private long id;
    private int level;
    private int attackBonus;
    private int healthBonus;
    private String descriptionPt;
    private String descriptionEn;
    private int artifactId;
    
    public ArtifactAttributesLevelDTO(ArtifactAttributesLevel attributesLevel) {
        this.setId(attributesLevel.getId());
        this.setLevel( attributesLevel.getLevel());
        this.setAttackBonus( attributesLevel.getAttackBonus());
        this.setHealthBonus( attributesLevel.getHealthBonus());
        this.setDescriptionEn(attributesLevel.getDescriptionPt());
        this.setDescriptionPt(attributesLevel.getDescriptionEn());
        this.setArtifactId( attributesLevel.getArtifact().getId());
    }
    
    public int getArtifactId() {
        return artifactId;
    }
    
    public void setArtifactId(int artifactId) {
        this.artifactId = artifactId;
    }
    
    public int getAttackBonus() {
        return attackBonus;
    }
    
    public void setAttackBonus(int attackBonus) {
        this.attackBonus = attackBonus;
    }
    
    public String getDescriptionEn() {
        return descriptionEn;
    }
    
    public void setDescriptionEn(String descriptionEn) {
        this.descriptionEn = descriptionEn;
    }
    
    public String getDescriptionPt() {
        return descriptionPt;
    }
    
    public void setDescriptionPt(String descriptionPt) {
        this.descriptionPt = descriptionPt;
    }
    
    public int getHealthBonus() {
        return healthBonus;
    }
    
    public void setHealthBonus(int healthBonus) {
        this.healthBonus = healthBonus;
    }
    
    public long getId() {
        return id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    
    public int getLevel() {
        return level;
    }
    
    public void setLevel(int level) {
        this.level = level;
    }
}
