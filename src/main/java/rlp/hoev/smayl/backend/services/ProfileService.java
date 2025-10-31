/*
 *
 *  * (c) 2025 Nils Kevin Koerting-Eberhardt (realEntwickler)
 *  *
 *  * File: ProfileService.java
 *  * Created on: 31.10.25, 08:37
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
import rlp.hoev.smayl.backend.docs.SmaylProfile;
import rlp.hoev.smayl.backend.docs.SmaylStudyGroup;
import rlp.hoev.smayl.backend.enums.SmaylProfileType;
import rlp.hoev.smayl.backend.repositories.ProfileRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileService {

    private final ProfileRepository profileRepository;

    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public void saveProfile (SmaylProfile profile) {
        profileRepository.save(profile);
    }

    public void deleteProfile (SmaylProfile profile) {
        profileRepository.delete(profile);
    }

    public SmaylProfile getProfile (String id) {
        Optional<SmaylProfile> profile = profileRepository.findById(id);
        return profile.orElse(null);
    }

    public List<SmaylProfile> getProfilesByProfileType(SmaylProfileType profileType) {
        return profileRepository.findSmaylProfilesByProfileType(profileType);
    }

    public List<SmaylProfile> getProfilesByStudyGroup(SmaylStudyGroup studyGroup) {
        return profileRepository.findSmaylProfilesByStudyGroup(studyGroup.getName());
    }

    public List<SmaylProfile> getProfiles() {
        return profileRepository.findAll();
    }
}
