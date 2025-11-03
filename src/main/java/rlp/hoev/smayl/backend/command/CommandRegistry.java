/*
 *
 *  * (c) 2025 Nils Kevin Koerting-Eberhardt (realEntwickler)
 *  *
 *  * File: CommandRegistry.java
 *  * Created on: 25.10.25, 12:28
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

import org.springframework.stereotype.Component;
import rlp.hoev.smayl.backend.command.commands.ConsoleCommand;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class CommandRegistry {

    private final List<ConsoleCommand> commandList = new ArrayList<>();

    public void registerCommand (ConsoleCommand command) {
        commandList.add(command);
    }

    public void executeCommand(String command) {
        String[] args = command.split(" ");

        if (args.length == 0) return;

        String name = args[0].toLowerCase();
        Optional<ConsoleCommand> first = commandList.stream().filter(consoleCommand -> consoleCommand.getName().equalsIgnoreCase(name) || Arrays.stream(consoleCommand.getAliases()).toList().contains(name)).findFirst();
        if (first.isPresent()) {
            first.get().onCommand(Arrays.copyOfRange(args, 1, args.length));
        } else {
            System.out.println("[SMAYL] Unknown command: " + name);
        }
    }

    public List<ConsoleCommand> getCommandList() {
        return commandList;
    }
}
