package com.family_highlights_personal_project.familyhighlights_personal_project.repository;

import com.family_highlights_personal_project.familyhighlights_personal_project.model.FamilyMember;
import com.family_highlights_personal_project.familyhighlights_personal_project.model.Highlight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Created by Micah Young
 */
@Repository
public interface FamilyMemberRepository extends JpaRepository<FamilyMember,Integer> {
//    @Query("FROM familyMember WHERE family = ?1")
//    List<FamilyMember> findFamilyMemberByFamilyId(String familyId);
//
//    @Query("FROM highlight WHERE famMemId = ?1")
//    List<Highlight> findHighlightByFamilyMemberId(int famMemId);
    Optional<FamilyMember> findByUsername(String username);
}
