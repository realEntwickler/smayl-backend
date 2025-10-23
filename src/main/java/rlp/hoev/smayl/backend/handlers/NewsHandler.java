/*
 *
 *  * (c) 2025 Nils Kevin Koerting-Eberhardt (realEntwickler)
 *  *
 *  * File: NewsHandler.java
 *  * Created on: 23.10.25, 21:57
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

package rlp.hoev.smayl.backend.handlers;

import rlp.hoev.smayl.backend.SmaylBackend;
import rlp.hoev.smayl.backend.records.RSmaylNews;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class NewsHandler {

    private final List<RSmaylNews> newsList;

    public NewsHandler() {
        this.newsList = new ArrayList<>();

        addNews(new RSmaylNews("Test Titel", "Dies ist eine Test News.", SmaylBackend.getInstance().getUserHandler().getUserByUsername("n.koertingebe").getUniqueId(), System.currentTimeMillis(), UUID.randomUUID()));
        System.out.println("[SMAYL] Test News successfully added.");
    }

    public boolean addNews(RSmaylNews news) {
        return newsList.add(news);
    }

    public List<RSmaylNews> getNewsList() {
        return newsList;
    }
}
