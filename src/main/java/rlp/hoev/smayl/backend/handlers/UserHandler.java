/*
 *
 *  * (c) 2025 Nils Kevin Koerting-Eberhardt (realEntwickler)
 *  *
 *  * File: UserHandler.java
 *  * Created on: 23.10.25, 20:15
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

package rlp.hoev.smayl.backend.handlers;

import rlp.hoev.smayl.backend.interfaces.ISmaylUser;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserHandler {

    private final List<ISmaylUser> registeredUsers;

    public UserHandler() {
        this.registeredUsers = new ArrayList<>();

        if (addUser(new ISmaylUser("Administrator", "admin", "n.a.", "Administrator", true))) {
            System.out.println("[SMAYL] User has been registered successfully.");
        }
    }

    /**
     *
     * @param user User who is getting added to registry.
     * @return Whether action was successful or not.
     */
    public boolean addUser(ISmaylUser user) {
        return this.registeredUsers.add(user);
    }

    /**
     *
     * @param user User who is getting removed out of registry.
     * @return Whether action was successful or not.
     */
    public boolean removeUser(ISmaylUser user) {
        return this.registeredUsers.remove(user);
    }

    /**
     * @param username The username of searched user
     * @return Instance of registered ISmaylUser when found
     * @exception NullPointerException When user wasn't found.
     */
    public ISmaylUser getUserByUsername (String username) {
        return registeredUsers.stream().filter(user -> user.getUsername().equalsIgnoreCase(username)).findFirst().orElse(null);
    }

    /**
     * @param email The email address of searched user
     * @return Instance of registered ISmaylUser when found.
     * @exception NullPointerException When user wasn't found.
     */
    public ISmaylUser getUserByEmail (String email) {
        return registeredUsers.stream().filter(user -> user.getEmailAddress().equalsIgnoreCase(email)).findFirst().orElse(null);
    }

    /**
     * @param uniqueId The UUID of searched user
     * @return Instance of registered ISmaylUser when found.
     * @exception NullPointerException When user wasn't found.
     */
    public ISmaylUser getUserByUniqueId (UUID uniqueId) {
        return registeredUsers.stream().filter(user -> user.getUniqueId().equals(uniqueId)).findFirst().orElse(null);
    }

    public List<ISmaylUser> getRegisteredUsers() {
        return registeredUsers;
    }
}
