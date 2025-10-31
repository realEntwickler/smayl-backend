/*
 *
 *  * (c) 2025 Nils Kevin Koerting-Eberhardt (realEntwickler)
 *  *
 *  * File: StudyGroupsCommand.java
 *  * Created on: 31.10.25, 10:12
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
import rlp.hoev.smayl.backend.services.StudyGroupService;

@Component
public class StudyGroupsCommand implements ConsoleCommand {


    private final StudyGroupService studyGroupService;

    public StudyGroupsCommand(StudyGroupService studyGroupService) {
        this.studyGroupService = studyGroupService;
    }

    @Override
    public String getName() {
        return "studygroups";
    }

    @Override
    public String getDescription() {
        return "Manages the registered studygroups";
    }

    @Override
    public void onCommand(String[] arguments) {
        if (arguments.length == 0) {
            System.out.println("[SMAYL] Usage of \"studygroups\":");
            System.out.println("> studygroups list - Displays all registered studygroups");
            System.out.println("> studygroups delete <ID> - Deletes a studygroup");
            System.out.println("> studygroups add <StudyGroup> - Adds a studygroup");
        } else if (arguments.length == 1) {
            if (arguments[0].equalsIgnoreCase("list")) {
                System.out.println("[SMAYL] The following study groups are listed:");
                studyGroupService.getStudyGroups().forEach(s -> System.out.println("- " + s));
            } else {
                System.out.println("[SMAYL] Wrong usage.");
            }
        } else if (arguments.length == 2) {
            if (arguments[0].equalsIgnoreCase("add")) {
                String studyGroupName = arguments[1];
                if (!studyGroupService.getStudyGroups().contains(studyGroupName)) {
                    studyGroupService.createStudyGroup(studyGroupName);
                    System.out.println("[SMAYL] The study group \"" + studyGroupName + "\" has been added.");
                } else {
                    System.out.println("[SMAYL] This study group does already exist.");
                }
            } else if (arguments[0].equalsIgnoreCase("delete")) {
                String studyGroupName = arguments[1];
                if (studyGroupService.getStudyGroups().contains(studyGroupName)) {
                    studyGroupService.deleteStudyGroup(studyGroupName);
                } else {
                    System.out.println("[SMAYL] This study group does not exist.");
                }
            }
        }
    }
}
