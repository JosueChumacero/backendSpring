/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.service;

import com.example.modelo.User;
import java.util.List;

/**
 *
 * @author ChUmA
 */
public interface UserServiceI {

    public User save(User user);

    public List<User> findAll();
    
}
