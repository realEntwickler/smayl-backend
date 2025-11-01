/*
 *
 *  * (c) 2025 Nils Kevin Koerting-Eberhardt (realEntwickler)
 *  *
 *  * File: StudyGroupController.java
 *  * Created on: 31.10.25, 10:10
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

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import rlp.hoev.smayl.backend.docs.SmaylStudyGroup;
import rlp.hoev.smayl.backend.services.StudyGroupService;

import java.util.List;

@RestController("/studygroup")
public class StudyGroupController {


    private final StudyGroupService studyGroupService;

    public StudyGroupController(StudyGroupService studyGroupService) {
        this.studyGroupService = studyGroupService;
    }

    @GetMapping("/studygroups")
    public List<SmaylStudyGroup> getStudyGroups() {
        return studyGroupService.getStudyGroups();
    }
}
