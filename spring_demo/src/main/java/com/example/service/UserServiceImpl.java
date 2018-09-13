/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.service;

import com.example.dao.UserRepository;
import com.example.modelo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ChUmA
 */
@Service
public class UserServiceImpl implements UserServiceI{
    
    @Autowired
    protected UserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }
}