package com.ditryx.testMVC.controllers;

import com.ditryx.testMVC.DAO.RoleService;
import com.ditryx.testMVC.DAO.UserService;
import com.ditryx.testMVC.entities.Role;
import com.ditryx.testMVC.entities.User;
import com.ditryx.testMVC.view.UserView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getUser(@PathVariable long id){
        User user = this.userService.findById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<User>> getUserList(){
        return new ResponseEntity<>(this.userService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/role/{roleName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<User>> getUserListByRole(@PathVariable String roleName){
        return new ResponseEntity<>(this.userService.findByRole(roleName), HttpStatus.OK);
    }

    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> addUser(@RequestBody UserView userView){
        HttpHeaders httpHeaders = new HttpHeaders();

        User newUser;

        if (userView.getFirstName() == null ||userView.getLastName() == null ||userView.getRole() ==null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            Role existedRole = this.roleService.getRoleByName(userView.getRole());
            if (existedRole != null) {
                newUser = new User(userView.getFirstName(), userView.getLastName(), existedRole);
            } else {
                Role newRole = new Role(userView.getRole());
                newUser = new User(userView.getFirstName(), userView.getLastName(), newRole);
            }
            this.userService.save(newUser);
        }

        return new ResponseEntity<>(newUser, httpHeaders, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable long id){
        this.userService.delete(id);
        return new ResponseEntity<>("Data deleted successfully", HttpStatus.OK);
    }

}
