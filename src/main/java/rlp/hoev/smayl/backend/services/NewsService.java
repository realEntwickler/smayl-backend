/*
 *
 *  * (c) 2025 Nils Kevin Koerting-Eberhardt (realEntwickler)
 *  *
 *  * File: NewsService.java
 *  * Created on: 25.10.25, 10:24
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
import rlp.hoev.smayl.backend.docs.SmaylNews;
import rlp.hoev.smayl.backend.repositories.NewsRepository;

import java.util.List;

@Service
public class NewsService {

    private final NewsRepository newsRepository;

    public NewsService(NewsRepository newsRepository) {
//        insertNews(new ISmaylNews("Neuer Semesterstart an der HÖV Rheinland-Pfalz", "Am Campus Mayen startet das neue Wintersemester mit zahlreichen Einführungsveranstaltungen und spannenden Projekten für Erstsemester.", authorUniqueId, System.currentTimeMillis()));
//        insertNews(new ISmaylNews("Digitalisierung in der öffentlichen Verwaltung", "Das Land Rheinland-Pfalz treibt die Modernisierung der Verwaltung mit neuen E-Government-Projekten weiter voran.", authorUniqueId, System.currentTimeMillis()));
//        insertNews(new ISmaylNews("Neue Mensa-Angebote für Studierende", "Ab November gibt es täglich wechselnde vegetarische und vegane Gerichte. Feedback kann über die Campus-App gegeben werden.", authorUniqueId, System.currentTimeMillis()));
        this.newsRepository = newsRepository;
    }

    public void deleteNews(SmaylNews news) {
        newsRepository.delete(news);
    }

    public SmaylNews getNewsById(String id) {
        return newsRepository.findById(id).orElse(null);
    }

    public List<SmaylNews> getAllNews() {
        return newsRepository.findAll();
    }

    public void saveNews(SmaylNews news) {
        newsRepository.save(news);
    }
}
