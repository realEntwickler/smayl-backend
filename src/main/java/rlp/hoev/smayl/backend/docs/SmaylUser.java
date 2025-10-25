/*
 *
 *  * (c) 2025 Nils Kevin Koerting-Eberhardt (realEntwickler)
 *  *
 *  * File: SmaylUser.java
 *  * Created on: 25.10.25, 11:31
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

package rlp.hoev.smayl.backend.docs;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class SmaylUser {

    @Id
    private String id;

    private String username, password, emailAddress, displayName;
    private final long timestamp;
    private boolean enhancedPriviliges;

    public SmaylUser(String username, String password, String emailAddress, String displayName, long timestamp, boolean enhancedPriviliges) {
        this.username = username;
        this.password = password;
        this.emailAddress = emailAddress;
        this.displayName = displayName;
        this.timestamp = timestamp;
        this.enhancedPriviliges = enhancedPriviliges;
    }

    public String getId() {
        return id;
    }

    public long getTimestamp() {
        return timestamp;
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

    public boolean isEnhancedPriviliges() {
        return enhancedPriviliges;
    }

    public void setEnhancedPriviliges(boolean enhancedPriviliges) {
        this.enhancedPriviliges = enhancedPriviliges;
    }
}
