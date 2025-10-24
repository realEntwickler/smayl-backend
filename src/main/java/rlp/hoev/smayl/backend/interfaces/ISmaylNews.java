/*
 *
 *  * (c) 2025 Nils Kevin Koerting-Eberhardt (realEntwickler)
 *  *
 *  * File: ISmaylNews.java
 *  * Created on: 24.10.25, 09:29
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

package rlp.hoev.smayl.backend.interfaces;

import java.util.UUID;

public class ISmaylNews {

    private final String title, description;
    private final UUID authorUniqueId;
    private final long creationTimestamp;
    private final UUID uniqueId;

    public ISmaylNews(String title, String description, UUID authorUniqueId, long creationTimestamp) {
        this.title = title;
        this.description = description;
        this.authorUniqueId = authorUniqueId;
        this.creationTimestamp = creationTimestamp;
        this.uniqueId = UUID.randomUUID();
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public UUID getAuthorUniqueId() {
        return authorUniqueId;
    }

    public long getCreationTimestamp() {
        return creationTimestamp;
    }

    public UUID getUniqueId() {
        return uniqueId;
    }
}
