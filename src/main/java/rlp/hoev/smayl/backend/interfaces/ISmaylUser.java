/*
 *
 *  * (c) 2025 Nils Kevin Koerting-Eberhardt (realEntwickler)
 *  *
 *  * File: ISmaylUser.java
 *  * Created on: 23.10.25, 20:12
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

package rlp.hoev.smayl.backend.interfaces;

import java.util.UUID;

public class ISmaylUser {

    private final long creationTimestamp;
    private final UUID uniqueId;
    private String username;
    private String password; //TODO: Later being crypted
    private String emailAddress;
    private String displayName;
    private boolean enhancedPriviliges;

    public ISmaylUser(String username, String password, String emailAddress, String displayName, boolean enhancedPriviliges) {
        this.creationTimestamp = System.currentTimeMillis();
        this.uniqueId = UUID.randomUUID();
        this.username = username;
        this.password = password;
        this.emailAddress = emailAddress;
        this.displayName = displayName;
        this.enhancedPriviliges = enhancedPriviliges;
    }

    public UUID getUniqueId() {
        return uniqueId;
    }

    public boolean hasEnhancedPriviliges() {
        return enhancedPriviliges;
    }

    public void setEnhancedPriviliges(boolean enhancedPriviliges) {
        this.enhancedPriviliges = enhancedPriviliges;
    }

    public long getCreationTimestamp() {
        return creationTimestamp;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
}
