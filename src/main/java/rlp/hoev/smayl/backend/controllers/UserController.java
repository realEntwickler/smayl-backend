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

import org.springframework.web.bind.annotation.*;
import rlp.hoev.smayl.backend.SmaylBackend;
import rlp.hoev.smayl.backend.exceptions.ParameterException;
import rlp.hoev.smayl.backend.exceptions.UserNotFoundException;
import rlp.hoev.smayl.backend.interfaces.ISmaylUser;

import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    public UserController() {

    }

    @GetMapping("/find")
    public ISmaylUser findUser(
            @RequestParam(required = false) String username,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String uniqueId) {
        ISmaylUser user;
        if (username != null) {
            user = SmaylBackend.getInstance().getUserHandler().getUserByUsername(username);
        } else if (email != null) {
            user = SmaylBackend.getInstance().getUserHandler().getUserByEmail(email);
        } else if (uniqueId != null) {
            user = SmaylBackend.getInstance().getUserHandler().getUserByUniqueId(UUID.fromString(uniqueId));
        } else {
            throw new ParameterException("Username or Email or Unique Id is null");
        }
        if (user == null)
            throw new UserNotFoundException("User not found");
        return user;
    }
}
