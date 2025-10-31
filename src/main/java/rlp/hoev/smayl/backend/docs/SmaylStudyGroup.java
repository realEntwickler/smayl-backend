/*
 *
 *  * (c) 2025 Nils Kevin Koerting-Eberhardt (realEntwickler)
 *  *
 *  * File: SmaylStudyGroup.java
 *  * Created on: 31.10.25, 08:35
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

@Document(collection = "studyGroups")
public class SmaylStudyGroup {

    @Id
    private String _id;
    private String displayName;

    public SmaylStudyGroup(String displayName) {
        this.displayName = displayName;
    }

    public String getId() {
        return _id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
}
