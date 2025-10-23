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

public class SmaylBackend {

    private static SmaylBackend instance;

    public SmaylBackend() {
        instance = this;
    }

    public static SmaylBackend getInstance() {
        return instance;
    }
}
