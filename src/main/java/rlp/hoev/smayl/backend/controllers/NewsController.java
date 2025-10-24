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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rlp.hoev.smayl.backend.SmaylBackend;
import rlp.hoev.smayl.backend.interfaces.ISmaylNews;

import java.util.List;

@RestController
@RequestMapping("/news")
public class NewsController {

    public NewsController() {

    }

    @GetMapping("/get")
    public List<ISmaylNews> getNews() {
        return SmaylBackend.getInstance().getNewsHandler().getNewsList();
    }
}
