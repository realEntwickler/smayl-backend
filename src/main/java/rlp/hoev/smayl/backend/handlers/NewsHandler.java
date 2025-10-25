/*
 *
 *  * (c) 2025 Nils Kevin Koerting-Eberhardt (realEntwickler)
 *  *
 *  * File: NewsHandler.java
 *  * Created on: 25.10.25, 11:07
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

import com.google.gson.Gson;
import rlp.hoev.smayl.backend.interfaces.ISmaylNews;

public class NewsHandler {

    private final Gson gson;

    public NewsHandler() {
        this.gson = new Gson();
    }

    public void saveNews(ISmaylNews news) {

    }
}
