/*
 *
 *  * (c) 2025 Nils Kevin Koerting-Eberhardt (realEntwickler)
 *  *
 *  * File: UserService.java
 *  * Created on: 25.10.25, 11:32
 *  *
 *  * This file is part of the project "smayl-backend".
 *  *
 *  * Licensed under the Creative Commons Attribution - NonCommercial -
 *  * NoDerivatives 4.0 International License (CC BY-NC-ND 4.0).
 *  *
 *  * For more information about this license, please visit:
 *  * https://creativecommons.org/licenses/by-nc-nd/4.0/
 *
 */

package rlp.hoev.smayl.backend.services;

import org.springframework.stereotype.Service;
import rlp.hoev.smayl.backend.docs.SmaylUser;
import rlp.hoev.smayl.backend.repositories.UserRepository;

import java.util.List;

@Service
public class UserService {


    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void deleteUser(SmaylUser smaylUser) {
        userRepository.delete(smaylUser);
    }

    public boolean isUsernameAvailable(String username) {
        return userRepository.findByUsername(username) == null;
    }

    public void saveUser(SmaylUser smaylUser) {
        userRepository.save(smaylUser);
    }

    public SmaylUser getUserById(String id) {
        return userRepository.findById(id).orElse(null);
    }

    public SmaylUser getUserByEmail(String email) {
        return userRepository.findByEmailAddress(email);
    }

    public SmaylUser getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public List<SmaylUser> findAll() {
        return userRepository.findAll();
    }
}