package com.EpicSeven.dto;

import com.EpicSeven.entity.Artifact;
import com.EpicSeven.entity.ArtifactAttributesLevel;

public class ArtifactRequestDTO {
    private Artifact artifact;
    private ArtifactAttributesLevel artifactAttributesLevel;
    
    public Artifact getArtifact() {
        return artifact;
    }
    
    public void setArtifact(Artifact artifact) {
        this.artifact = artifact;
    }
    
    public ArtifactAttributesLevel getArtifactAttributesLevel() {
        return artifactAttributesLevel;
    }
    
    public void setArtifactAttributesLevel(ArtifactAttributesLevel artifactAttributesLevel) {
        this.artifactAttributesLevel = artifactAttributesLevel;
    }
}
