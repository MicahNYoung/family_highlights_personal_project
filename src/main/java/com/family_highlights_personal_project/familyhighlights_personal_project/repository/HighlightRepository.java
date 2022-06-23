package com.family_highlights_personal_project.familyhighlights_personal_project.repository;

import com.family_highlights_personal_project.familyhighlights_personal_project.model.Highlight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Micah Young
 */
@Repository
public interface HighlightRepository extends JpaRepository<Highlight, Integer> {

//
//    @Query("FROM highlight WHERE famMemId = ?1")
//    List<Highlight> findHighlightByFamilyMemberId(int famMemId);
}
