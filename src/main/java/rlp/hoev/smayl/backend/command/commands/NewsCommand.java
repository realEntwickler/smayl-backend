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
import rlp.hoev.smayl.backend.docs.SmaylNews;
import rlp.hoev.smayl.backend.docs.SmaylProfile;
import rlp.hoev.smayl.backend.services.NewsService;
import rlp.hoev.smayl.backend.services.ProfileService;

@Component
public class NewsCommand implements ConsoleCommand{


    private final NewsService newsService;
    private final ProfileService profileService;

    public NewsCommand(NewsService newsService, ProfileService profileService) {
        this.newsService = newsService;
        this.profileService = profileService;
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
            System.out.println("> news delete <ID> - Deletes a news");
            System.out.println("> news add <AuthorID> - Adds a testing news");
        } else if (arguments.length == 1) {
            if (arguments[0].equals("list")) {
                System.out.println("[SMAYL] The following news are registered:");
                newsService.getAllNews().forEach(smaylNews -> {
                    SmaylProfile author = profileService.getProfile(smaylNews.getAuthorId());
                    System.out.println("> " +  smaylNews.getId() + ": " + smaylNews.getTitle() + " (" + author.getDisplayName() + ")");
                });
            }
        } else if (arguments.length == 2) {
            if (arguments[0].equals("delete")) {
                String id =  arguments[1];
                SmaylNews newsById = newsService.getNewsById(id);

                if (newsById != null) {
                    newsService.deleteNews(newsById);
                    System.out.println("[SMAYL] The news with the id \"" + newsById.getId() + "\" has been successfully deleted.");
                } else {
                    System.out.println("[SMAYL] The given news does not exist.");
                }
            } else if (arguments[0].equals("add")) {
                String authorId = arguments[1];
                SmaylProfile author = profileService.getProfile(authorId);

                if (author != null) {
                    SmaylNews smaylNews = new SmaylNews("Testing Title", "Testing Description", author.getId(), System.currentTimeMillis());
                    newsService.saveNews(smaylNews);
                    System.out.println("[SMAYl] Successfully added news with the id: " + smaylNews.getId());
                } else {
                    System.out.println("[SMAYL] The given profile does not exist.");
                }
            }
        }
    }
}
