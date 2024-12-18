package com.EpicSeven.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "Artifact_Attributes_Level")
public class ArtifactAttributesLevel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_artifact_attributes_level")
    private long id;
    
    @Column(name = "level")
    private int level;
    
    @Column(name = "attack_bonus")
    private int attackBonus;
    
    @Column(name = "health_bonus")
    private int healthBonus;
    
    @Column(name = "base_description_pt")
    private String descriptionPt;
    
    @Column(name = "base_description_en")
    private String descriptionEn;
    
    @ManyToOne
    @JoinColumn(name = "fk_artifact_id", nullable = false)
    @JsonIgnore
    private Artifact artifact;
    
    public int getLevel() {
        return level;
    }
    
    public void setLevel(int level) {
        this.level = level;
    }
    
    public long getId() {
        return id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    
    public int getHealthBonus() {
        return healthBonus;
    }
    
    public void setHealthBonus(int healthBonus) {
        this.healthBonus = healthBonus;
    }
    
    public String getDescriptionPt() {
        return descriptionPt;
    }
    
    public void setDescriptionPt(String descriptionPt) {
        this.descriptionPt = descriptionPt;
    }
    
    public String getDescriptionEn() {
        return descriptionEn;
    }
    
    public void setDescriptionEn(String descriptionEn) {
        this.descriptionEn = descriptionEn;
    }
    
    public int getAttackBonus() {
        return attackBonus;
    }
    
    public void setAttackBonus(int attackBonus) {
        this.attackBonus = attackBonus;
    }
    
    public Artifact getArtifact() {
        return artifact;
    }
    
    public void setArtifact(Artifact artifact) {
        this.artifact = artifact;
    }
}
