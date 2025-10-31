/*
 *
 *  * (c) 2025 Nils Kevin Koerting-Eberhardt (realEntwickler)
 *  *
 *  * File: ProfileRepository.java
 *  * Created on: 31.10.25, 08:38
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

package rlp.hoev.smayl.backend.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import rlp.hoev.smayl.backend.docs.SmaylProfile;
import rlp.hoev.smayl.backend.docs.SmaylStudyGroup;
import rlp.hoev.smayl.backend.enums.SmaylProfileType;

import java.util.List;

@Repository
public interface ProfileRepository extends MongoRepository<SmaylProfile, String> {

    List<SmaylProfile> findSmaylProfilesByProfileType(SmaylProfileType profileType);

    List<SmaylProfile> findSmaylProfilesByStudyGroup(SmaylStudyGroup studyGroup);
}
