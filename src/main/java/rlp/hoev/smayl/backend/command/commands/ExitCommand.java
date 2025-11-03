/*
 *
 *  * (c) 2025 Nils Kevin Koerting-Eberhardt (realEntwickler)
 *  *
 *  * File: ExitCommand.java
 *  * Created on: 25.10.25, 12:57
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

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;
import rlp.hoev.smayl.backend.command.CommandRegistry;
import rlp.hoev.smayl.backend.command.SmaylBackendCommandLine;

@Component
public class ExitCommand implements ConsoleCommand{

    private final ConfigurableApplicationContext context;
    private final SmaylBackendCommandLine commandLine;
    private final CommandRegistry commandRegistry;

    public ExitCommand(ConfigurableApplicationContext context, SmaylBackendCommandLine commandLine, CommandRegistry commandRegistry) {
        this.context = context;
        this.commandLine = commandLine;
        this.commandRegistry = commandRegistry;
    }

    @Override
    public String getName() {
        return "exit";
    }

    @Override
    public String getDescription() {
        return "Shuts down the application";
    }

    @Override
    public String[] getAliases() {
        return new String[]{"stop", "shutdown"};
    }

    @Override
    public void onCommand(String[] arguments) {
        if (arguments.length == 0) {
            System.out.println("[SMAYL] Do you really want to shutdown  the application? Write: \"exit confirm\"");
        } else if (arguments.length == 1) {
            if (arguments[0].equalsIgnoreCase("confirm")) {
                System.out.println("[SMAYL] Backend shuts down...");

                commandLine.stopLoop();
                new Thread(() -> {
                    try { Thread.sleep(500); } catch (InterruptedException ignored) {}
                    context.close();
                }).start();
            } else {
                System.out.println("[SMAYL] Wrong usage.");
            }
        } else {
            System.out.println("[SMAYL] Wrong usage.");
        }
    }
}
