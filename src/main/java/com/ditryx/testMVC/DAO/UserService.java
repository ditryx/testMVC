package com.ditryx.testMVC.DAO;

import com.ditryx.testMVC.entities.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    List<User> findByRole(String role);
    User findById (long id);
    void save(User user);
    void delete(long id);
}
