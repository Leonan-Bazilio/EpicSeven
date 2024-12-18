package com.EpicSeven.entity;

import com.EpicSeven.enums.CharacterClass;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;


@Entity
@Table(name = "tb_artifact")
public class Artifact {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_artifact")
    private int id;
    
    @Column(name = "name_pt")
    private String namePt;
    
    @Column(name = "name_en")
    private String nameEn;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "restriction")
    private CharacterClass restriction;
    
    @Column(name = "rarity_stars")
    private byte rarityStars;
    
    @Column(name = "background_pt")
    private String backgroundPt;
    
    @Column(name = "background_en")
    private String backgroundEn;
    
    @Column(name = "image_url")
    private String imageUrl;
    
    @Column(name = "release_date", nullable = false)
    private LocalDate releaseDate;
    
    @OneToMany(mappedBy = "artifact", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<ArtifactAttributesLevel> attributesLevels;
    
    
    
    public String getBackgroundEn() {
        return backgroundEn;
    }
    
    public void setBackgroundEn(String backgroundEn) {
        this.backgroundEn = backgroundEn;
    }
    
    public String getBackgroundPt() {
        return backgroundPt;
    }
    
    public void setBackgroundPt(String backgroundPt) {
        this.backgroundPt = backgroundPt;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getImageUrl() {
        return imageUrl;
    }
    
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    
    public String getNameEn() {
        return nameEn;
    }
    
    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }
    
    public String getNamePt() {
        return namePt;
    }
    
    public void setNamePt(String namePt) {
        this.namePt = namePt;
    }
    
    public byte getRarityStars() {
        return rarityStars;
    }
    
    public void setRarityStars(byte rarityStars) {
        this.rarityStars = rarityStars;
    }
    
    public CharacterClass getRestriction() {
        return restriction;
    }
    public void setRestriction(CharacterClass restriction) {
        this.restriction = restriction;
    }
    
    public String getReleaseDate() {
        return releaseDate.toString();
    }
    
    public void setReleaseDate(String releaseDate) {
        this.releaseDate = LocalDate.parse(releaseDate);
    }
    
    public List<ArtifactAttributesLevel> getAttributesLevels() {
        return attributesLevels;
    }
    
    public void setAttributesLevels(List<ArtifactAttributesLevel> attributesLevels) {
        this.attributesLevels = attributesLevels;
    }
}