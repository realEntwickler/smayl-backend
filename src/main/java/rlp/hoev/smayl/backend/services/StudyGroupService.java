/*
 *
 *  * (c) 2025 Nils Kevin Koerting-Eberhardt (realEntwickler)
 *  *
 *  * File: StudyGroupService.java
 *  * Created on: 31.10.25, 10:07
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
import rlp.hoev.smayl.backend.docs.SmaylStudyGroup;
import rlp.hoev.smayl.backend.repositories.StudyGroupRepository;

import java.util.List;

@Service
public class StudyGroupService {


    private final StudyGroupRepository studyGroupRepository;

    public StudyGroupService(StudyGroupRepository studyGroupRepository) {
        this.studyGroupRepository = studyGroupRepository;
    }

    public SmaylStudyGroup getStudyGroup(String studyGroupName) {
        return studyGroupRepository.findSmaylStudyGroupByName(studyGroupName);
    }

    public void createStudyGroup(SmaylStudyGroup studyGroup) {
        studyGroupRepository.save(studyGroup);
    }

    public void deleteStudyGroup(SmaylStudyGroup studyGroup) {
        studyGroupRepository.delete(studyGroup);
    }

    public List<SmaylStudyGroup> getStudyGroups() {
        return studyGroupRepository.findAll();
    }
}
