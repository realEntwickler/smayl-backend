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
import rlp.hoev.smayl.backend.interfaces.ISmaylNews;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class NewsHandler {

    private final List<ISmaylNews> newsList;

    public NewsHandler() {
        this.newsList = new ArrayList<>();

        UUID authorUniqueId = SmaylBackend.getInstance().getUserHandler().getUserByUsername("n.koertingebe").getUniqueId();
        addNews(new ISmaylNews("Neuer Semesterstart an der HÖV Rheinland-Pfalz", "Am Campus Mayen startet das neue Wintersemester mit zahlreichen Einführungsveranstaltungen und spannenden Projekten für Erstsemester.", authorUniqueId, System.currentTimeMillis()));
        addNews(new ISmaylNews("Digitalisierung in der öffentlichen Verwaltung", "Das Land Rheinland-Pfalz treibt die Modernisierung der Verwaltung mit neuen E-Government-Projekten weiter voran.", authorUniqueId, System.currentTimeMillis()));
        addNews(new ISmaylNews("Neue Mensa-Angebote für Studierende", "Ab November gibt es täglich wechselnde vegetarische und vegane Gerichte. Feedback kann über die Campus-App gegeben werden.", authorUniqueId, System.currentTimeMillis()));

        System.out.println("[SMAYL] Test News successfully added.");
    }

    public boolean addNews(ISmaylNews news) {
        return newsList.add(news);
    }

    public List<ISmaylNews> getNewsList() {
        return newsList;
    }
}
