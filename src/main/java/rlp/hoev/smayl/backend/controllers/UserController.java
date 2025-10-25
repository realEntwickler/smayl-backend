/*
 *
 *  * (c) 2025 Nils Kevin Koerting-Eberhardt (realEntwickler)
 *  *
 *  * File: UserController.java
 *  * Created on: 23.10.25, 20:49
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

package rlp.hoev.smayl.backend.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import rlp.hoev.smayl.backend.docs.SmaylUser;
import rlp.hoev.smayl.backend.exceptions.ParameterException;
import rlp.hoev.smayl.backend.exceptions.UserNotFoundException;
import rlp.hoev.smayl.backend.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/find")
    public SmaylUser findUser(
            @RequestParam(required = false) String username,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String id) {
        SmaylUser user;
        if (username != null) {
            user = userService.getUserByUsername(username);
        } else if (email != null) {
            user = userService.getUserByEmail(email);
        } else if (id != null) {
            user = userService.getUserById(id);
        } else {
            throw new ParameterException("Username or Email or Id is null");
        }
        if (user == null)
            throw new UserNotFoundException("User not found");
        return user;
    }
}
