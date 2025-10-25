/*
 *
 *  * (c) 2025 Nils Kevin Koerting-Eberhardt (realEntwickler)
 *  *
 *  * File: SmaylBackendCommandLine.java
 *  * Created on: 25.10.25, 12:41
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

package rlp.hoev.smayl.backend.command;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class SmaylBackendCommandLine implements CommandLineRunner {

    private final CommandRegistry commandRegistry;

    public SmaylBackendCommandLine(CommandRegistry commandRegistry) {
        this.commandRegistry = commandRegistry;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("[SMAYL] Commando system started successfully. Type \"help\"");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("» ");
            String command = scanner.nextLine();
            commandRegistry.executeCommand(command);
        }
    }
}
