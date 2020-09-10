package com.ditryx.testMVC.DAO;

import com.ditryx.testMVC.entities.Role;
import com.ditryx.testMVC.repos.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service("roleService")
public class RoleServiceImpl implements RoleService{

    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<String> findAllRoles() {
        List<Role> roles = roleRepository.findAll();
        List<String> result = new ArrayList<>();
        for (Role role: roles
             ) {
            result.add(role.getName());
        }
        return result;
    }

    @Override
    public Role getRoleByName(String name) {
        return roleRepository.getRoleByName(name);
    }
}
