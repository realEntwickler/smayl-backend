/*
 *
 *  * (c) 2025 Nils Kevin Koerting-Eberhardt (realEntwickler)
 *  *
 *  * File: SmaylProfile.java
 *  * Created on: 31.10.25, 08:22
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
import rlp.hoev.smayl.backend.enums.SmaylProfileType;

@Document(collection = "profiles")
public class SmaylProfile {

    @Id
    private final String _id;

    private final String firstName;
    private final String lastName;
    private final String emailAddress;
    private final String displayName;
    private String licensePlate;
    private String studyGroup;
    private SmaylProfileType profileType;
    private boolean administrative;
    private final long timestamp;

    public SmaylProfile(String id, String firstName, String lastName, String emailAddress, String displayName, String licensePlate, String studyGroup, SmaylProfileType profileType, boolean administrative, long timestamp) {
        this._id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.displayName = displayName;
        this.licensePlate = licensePlate;
        this.studyGroup = studyGroup;
        this.profileType = profileType;
        this.administrative = administrative;
        this.timestamp = timestamp;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public SmaylProfileType getProfileType() {
        return profileType;
    }

    public void setProfileType(SmaylProfileType profileType) {
        this.profileType = profileType;
    }

    public String getStudyGroup() {
        return studyGroup;
    }

    public void setStudyGroup(String studyGroup) {
        this.studyGroup = studyGroup;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getId() {
        return _id;
    }

    public boolean isAdministrative() {
        return administrative;
    }

    public void setAdministrative(boolean administrative) {
        this.administrative = administrative;
    }

    public long getTimestamp() {
        return timestamp;
    }
}