package com.ditryx.testMVC.view;

import com.ditryx.testMVC.entities.Role;
import com.ditryx.testMVC.entities.User;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


public class UserView {
    private long id;
    private String firstName;
    private String lastName;
    private String role;

    public UserView(User user) {
        this.id = user.getId();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.role = user.getRole().getName();
    }

    @JsonCreator
    public UserView(@JsonProperty("firstName") String firstName, @JsonProperty("lastName") String lastName,
                    @JsonProperty("role") String role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
