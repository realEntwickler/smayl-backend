/*
 *
 *  * (c) 2025 Nils Kevin Koerting-Eberhardt (realEntwickler)
 *  *
 *  * File: SmaylStudyGroup.java
 *  * Created on: 31.10.25, 10:29
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

@Document(collection = "studygroups")
public class SmaylStudyGroup {

    @Id
    private String _id;
    private final String name;

    public SmaylStudyGroup(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return _id;
    }
}