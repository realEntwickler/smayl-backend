/*
 *
 *  * (c) 2025 Nils Kevin Koerting-Eberhardt (realEntwickler)
 *  *
 *  * File: HelpCommand.java
 *  * Created on: 25.10.25, 12:40
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
import rlp.hoev.smayl.backend.command.CommandRegistry;

@Component
public class HelpCommand implements ConsoleCommand{

    private final CommandRegistry commandRegistry;

    public HelpCommand(CommandRegistry commandRegistry) {
        this.commandRegistry = commandRegistry;
    }

    @Override
    public String getName() {
        return "help";
    }

    @Override
    public String getDescription() {
        return "Shows you some help.";
    }

    @Override
    public String[] getAliases() {
        return new String[]{"?"};
    }

    @Override
    public void onCommand(String[] arguments) {
        System.out.println("[SMAYL] The following commands are supported:");
        commandRegistry.getCommandList().forEach(consoleCommand -> {
            String cmdAndAlias = consoleCommand.getName() + ",";
            for (String alias : consoleCommand.getAliases()){
                cmdAndAlias = cmdAndAlias.concat(alias);
            }
            System.out.println("> \"" + cmdAndAlias + "\" - " + consoleCommand.getDescription());
        });
    }
}
