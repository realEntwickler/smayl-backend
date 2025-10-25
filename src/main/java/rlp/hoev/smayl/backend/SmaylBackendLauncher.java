/*
 *
 *  * (c) 2025 Nils Kevin Koerting-Eberhardt (realEntwickler)
 *  *
 *  * File: SmaylBackendLauncher.java
 *  * Created on: 25.10.25, 10:35
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

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication()
public class SmaylBackendLauncher {

    public static void main(String[] arguments) {
        printLauncherMessage();
        SpringApplication.run(SmaylBackendLauncher.class, arguments);
        System.out.println("[SMAYL] Spring Boot has been loaded.");
        new SmaylBackend();
    }

    private static void printLauncherMessage() {
        System.out.println("   _____ __  __      __     ___        ____             _                  _ ");
        System.out.println("  / ____|  \\/  |   /\\\\ \\   / / |      |  _ \\           | |                | |");
        System.out.println(" | (___ | \\  / |  /  \\\\ \\_/ /| |      | |_) | __ _  ___| | _____ _ __   __| |");
        System.out.println("  \\___ \\| |\\/| | / /\\ \\\\   / | |      |  _ < / _` |/ __| |/ / _ \\ '_ \\ / _` |");
        System.out.println("  ____) | |  | |/ ____ \\| |  | |____  | |_) | (_| | (__|   <  __/ | | | (_| |");
        System.out.println(" |_____/|_|  |_/_/    \\_\\_|  |______| |____/ \\__,_|\\___|_|\\_\\___|_| |_|\\__,_|");
    }
}
