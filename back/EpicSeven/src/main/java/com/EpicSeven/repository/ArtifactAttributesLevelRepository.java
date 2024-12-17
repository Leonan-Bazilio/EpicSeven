package com.EpicSeven.repository;

import com.EpicSeven.entity.ArtifactAttributesLevel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ArtifactAttributesLevelRepository extends JpaRepository<ArtifactAttributesLevel, Long> {
    Optional<ArtifactAttributesLevel> findByArtifactIdAndLevel(int artifactId, int level);
    List<ArtifactAttributesLevel> findByArtifactId(int artifact_id);
}
