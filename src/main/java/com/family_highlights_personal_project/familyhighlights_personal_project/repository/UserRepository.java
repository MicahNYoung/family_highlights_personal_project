package com.family_highlights_personal_project.familyhighlights_personal_project.repository;

import com.family_highlights_personal_project.familyhighlights_personal_project.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Micah Young
 */
@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    User findByUsername(String username);
}
