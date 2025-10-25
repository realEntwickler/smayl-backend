/*
 *
 *  * (c) 2025 Nils Kevin Koerting-Eberhardt (realEntwickler)
 *  *
 *  * File: UsersCommand.java
 *  * Created on: 25.10.25, 12:40
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

package rlp.hoev.smayl.backend.command.commands;

import org.springframework.stereotype.Component;
import rlp.hoev.smayl.backend.docs.SmaylUser;
import rlp.hoev.smayl.backend.services.UserService;

import java.util.Random;

@Component
public class UsersCommand implements ConsoleCommand{


    private final UserService userService;

    public UsersCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String getName() {
        return "users";
    }

    @Override
    public String getDescription() {
        return "Allows you to manage the smayl users.";
    }

    @Override
    public void onCommand(String[] arguments) {
        if (arguments.length == 0) {
            System.out.println("[SMAYL] Usage of \"users\":");
            System.out.println("> users list - Shows you a list of all users");
            System.out.println("> users add <Username> <Email> <Displayname> <enhancedPriviliges> - Creates a new user");
        } else if (arguments.length == 1) {
            if (arguments[0].equals("list")) {
                System.out.println("[SMAYL - Users] Following users are registered:");
                userService.findAll().forEach(smaylUser -> {
                    System.out.println("> " + smaylUser.getUsername() + " (" + smaylUser.getId() + "): " + smaylUser.getDisplayName() + " [EP: " + smaylUser.isEnhancedPriviliges() + "]");
                });
            }
        } else if (arguments.length == 2) {

        } else if (arguments.length == 3) {

        } else if (arguments.length == 4) {

        } else if (arguments.length == 5) {
            if (arguments[0].equals("add")) {
                String username = arguments[1];
                String email = arguments[2];
                String displayname = arguments[3];
                boolean enhancedPriviliges = Boolean.parseBoolean(arguments[4]);

                if (userService.isUsernameAvailable(username)) {
                    int password = new Random().nextInt(9999);
                    SmaylUser smaylUser = new SmaylUser(username, String.valueOf(password), email, displayname, enhancedPriviliges);
                    userService.saveUser(smaylUser);
                    System.out.println("[SMAYL - Users] The user \"" + smaylUser.getUsername() + "\" has been created with the id: " + smaylUser.getId() + ". The password is: " + password);
                } else {
                    System.out.println("[SMAYL - Users] Username is already in use.");
                }
            }
        }
    }
}
