/*
 *
 *  * (c) 2025 Nils Kevin Koerting-Eberhardt (realEntwickler)
 *  *
 *  * File: CommandInitializer.java
 *  * Created on: 25.10.25, 12:38
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

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import rlp.hoev.smayl.backend.command.commands.ConsoleCommand;

import java.util.List;

@Component
public class CommandInitializer {

    private final CommandRegistry commandRegistry;
    private final List<ConsoleCommand> commands;

    public CommandInitializer(CommandRegistry commandRegistry, List<ConsoleCommand> commands) {
        this.commandRegistry = commandRegistry;
        this.commands = commands;
    }

    @PostConstruct
    public void init() {
        for (ConsoleCommand command : commands) {
            commandRegistry.registerCommand(command);
        }
        System.out.println("[SMAYL] Registered " + commands.size() + " commands.");
    }
}
