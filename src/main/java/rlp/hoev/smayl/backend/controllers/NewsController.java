/*
 *
 *  * (c) 2025 Nils Kevin Koerting-Eberhardt (realEntwickler)
 *  *
 *  * File: NewsController.java
 *  * Created on: 23.10.25, 22:01
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rlp.hoev.smayl.backend.docs.SmaylNews;
import rlp.hoev.smayl.backend.exceptions.NewsNotFoundException;
import rlp.hoev.smayl.backend.exceptions.ParameterException;
import rlp.hoev.smayl.backend.repositories.NewsRepository;
import rlp.hoev.smayl.backend.services.NewsService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/news")
public class NewsController {

    private final NewsService newsService;

    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping("/get")
    public List<SmaylNews> getNews() {
        return newsService.getAllNews();
    }

    @GetMapping("/getids")
    public List<String> getIds() {
        return newsService.getAllNews().stream().map(SmaylNews::getId).toList();
    }

    @GetMapping("/{id}")
    public SmaylNews getNewsById(@PathVariable String id) {
        if (id == null) {
            throw new ParameterException("The given news id is null.");
        }
        SmaylNews news = newsService.getNewsById(id);

        if (news != null) return news;
        else throw new NewsNotFoundException("The news with id " + id + " was not found.");
    }
}
