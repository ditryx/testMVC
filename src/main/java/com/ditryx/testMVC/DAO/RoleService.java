package com.ditryx.testMVC.DAO;

import com.ditryx.testMVC.entities.Role;

import java.util.List;

public interface RoleService {
    List<String> findAllRoles();
    Role getRoleByName(String name);
}
