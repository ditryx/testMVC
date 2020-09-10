package com.ditryx.testMVC.repos;

import com.ditryx.testMVC.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface UserRepository extends JpaRepository<User, Long> {

    //@Query(value = "SELECT users.* FROM users join role on users.user_role_id = role.id where role.name = ?1", nativeQuery = true)
    List<User> findUsersByRole_Name(String roleName);

    User findUserById(long id);


    void deleteUserById(long id);
}
