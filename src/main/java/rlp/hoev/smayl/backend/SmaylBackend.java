/*
 *
 *  * (c) 2025 Nils Kevin Koerting-Eberhardt (realEntwickler)
 *  *
 *  * File: SmaylBackend.java
 *  * Created on: 23.10.25, 13:54
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

package rlp.hoev.smayl.backend;

import rlp.hoev.smayl.backend.controllers.NewsController;
import rlp.hoev.smayl.backend.controllers.UserController;
import rlp.hoev.smayl.backend.handlers.NewsHandler;
import rlp.hoev.smayl.backend.handlers.UserHandler;

public class SmaylBackend {

    private static SmaylBackend instance;

    private final UserHandler userHandler;
    private final UserController userController;
    private final NewsHandler newsHandler;
    private final NewsController newsController;

    public SmaylBackend() {
        instance = this;
        this.userHandler = new UserHandler();
        this.userController = new UserController();
        this.newsHandler = new NewsHandler();
        this.newsController = new NewsController();
    }

    public NewsController getNewsController() {
        return newsController;
    }

    public NewsHandler getNewsHandler() {
        return newsHandler;
    }

    public UserController getUserController() {
        return userController;
    }

    public UserHandler getUserHandler() {
        return userHandler;
    }

    public static SmaylBackend getInstance() {
        return instance;
    }
}
