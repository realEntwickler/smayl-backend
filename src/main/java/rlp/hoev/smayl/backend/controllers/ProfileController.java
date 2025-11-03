/*
 *
 *  * (c) 2025 Nils Kevin Koerting-Eberhardt (realEntwickler)
 *  *
 *  * File: ProfileController.java
 *  * Created on: 31.10.25, 08:59
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

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rlp.hoev.smayl.backend.docs.SmaylProfile;
import rlp.hoev.smayl.backend.enums.SmaylProfileType;
import rlp.hoev.smayl.backend.services.ProfileService;

import java.util.List;

@RestController("/profile")
public class ProfileController {

    private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<SmaylProfile> getProfile(@PathVariable String id) {
        SmaylProfile profile = profileService.getProfile(id);

        if (profile == null) {
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(profile);
    }

    @GetMapping("/students")
    public List<SmaylProfile> getStudents() {
        return profileService.getProfilesByProfileType(SmaylProfileType.STUDENT);
    }

    @PostMapping("/create")
    public ResponseEntity<SmaylProfile> createProfile(@RequestBody SmaylProfile profile) {
        if (profileService.getProfile(profile.getId()) != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        } else {
            profileService.createProfile(profile);
            return Respon
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/getdisplayname", params = "id")
    public String getDisplayName(@PathVariable String id) {
        SmaylProfile profile = profileService.getProfile(id);
        if (profile == null) {
            return "NOT_FOUND";
        }
        return profile.getDisplayName();
    }
}
