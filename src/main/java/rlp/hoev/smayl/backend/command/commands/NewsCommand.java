/*
 *
 *  * (c) 2025 Nils Kevin Koerting-Eberhardt (realEntwickler)
 *  *
 *  * File: NewsCommand.java
 *  * Created on: 25.10.25, 19:54
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

package rlp.hoev.smayl.backend.command.commands;

import org.springframework.stereotype.Component;
import rlp.hoev.smayl.backend.docs.SmaylUser;
import rlp.hoev.smayl.backend.services.NewsService;
import rlp.hoev.smayl.backend.services.UserService;

@Component
public class NewsCommand implements ConsoleCommand{


    private final NewsService newsService;
    private final UserService userService;

    public NewsCommand(NewsService newsService, UserService userService) {
        this.newsService = newsService;
        this.userService = userService;
    }

    @Override
    public String getName() {
        return "news";
    }

    @Override
    public String getDescription() {
        return "Allows to manage the news.";
    }

    @Override
    public void onCommand(String[] arguments) {
        if (arguments.length == 0) {
            System.out.println("[SMAYL] Usage of \"news\":");
            System.out.println("> news list - Displays all registered news");
        } else if (arguments.length == 1) {
            if (arguments[0].equals("list")) {
                System.out.println("[SMAYL] The following news are registered:");
                newsService.getAllNews().forEach(smaylNews -> {
                    SmaylUser author = userService.getUserById(smaylNews.getAuthorId());
                    System.out.println("> " +  smaylNews.getTitle() + " - " + author.getUsername());
                });
            }
        }
    }
}
