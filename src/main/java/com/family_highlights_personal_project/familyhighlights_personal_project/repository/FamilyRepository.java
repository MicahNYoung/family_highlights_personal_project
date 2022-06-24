package com.family_highlights_personal_project.familyhighlights_personal_project.repository;

import com.family_highlights_personal_project.familyhighlights_personal_project.model.Family;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by Micah Young
 */
@Repository
public interface FamilyRepository extends JpaRepository<Family, Integer> {

    public Optional<Family> findById(String familyId);
}
