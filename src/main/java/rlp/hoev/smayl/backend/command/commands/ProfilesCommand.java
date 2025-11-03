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
import rlp.hoev.smayl.backend.docs.SmaylProfile;
import rlp.hoev.smayl.backend.services.ProfileService;

@Component
public class ProfilesCommand implements ConsoleCommand{


    private final ProfileService profileService;

    public ProfilesCommand(ProfileService profileService) {
        this.profileService = profileService;
    }

    @Override
    public String getName() {
        return "profiles";
    }

    @Override
    public String getDescription() {
        return "Allows you to manage the smayl profiles.";
    }

    @Override
    public String[] getAliases() {
        return new String[]{"p"};
    }

    @Override
    public void onCommand(String[] arguments) {
        if (arguments.length == 0) {
            System.out.println("[SMAYL] Usage of \"profiles\":");
            System.out.println("> profiles list - Shows you a list of all profiles");
            System.out.println("> profiles remove <ID> - Removes a profile");
        } else if (arguments.length == 1) {
            if (arguments[0].equals("list")) {
                System.out.println("[SMAYL - Profiles] Following profiles are registered:");
                profileService.getProfiles().forEach(smaylProfile -> System.out.println("> " + smaylProfile.getDisplayName() + " (" + smaylProfile.getId() + "): " + smaylProfile.getEmailAddress() + " [ADMIN: " + smaylProfile.isAdministrative() + "]"));
            }
        } else if (arguments.length == 2) {
            if (arguments[0].equals("remove")) {
                SmaylProfile profile = profileService.getProfile(arguments[1]);
                if (profile != null) {
                    profileService.deleteProfile(profile);
                    System.out.println("[SMAYL - Profiles] The profile \"" + profile.getEmailAddress() + "\" has been successfully deleted.");
                } else {
                    System.out.println("[SMAYL - Profiles] The given profile wasn't found!");
                }
            }
        } else if (arguments.length == 3) {

        } else if (arguments.length == 4) {

        } else if (arguments.length == 5) {
        }
    }
}
