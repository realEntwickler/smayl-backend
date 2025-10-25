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
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class SmaylBackendCommandLine implements CommandLineRunner {

    private final CommandRegistry commandRegistry;
    private final ConfigurableApplicationContext configurableApplicationContext;
    private volatile boolean running = true;

    public SmaylBackendCommandLine(CommandRegistry commandRegistry, ConfigurableApplicationContext configurableApplicationContext) {
        this.commandRegistry = commandRegistry;
        this.configurableApplicationContext = configurableApplicationContext;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("[SMAYL] Commando system started successfully. Type \"help\"");
        Scanner scanner = new Scanner(System.in);

        Thread shutdownWatcher = new Thread(() -> {
            while (configurableApplicationContext.isActive()) {
                try { Thread.sleep(100); } catch (InterruptedException ignored) {}
            }
            running = false;
            try { scanner.close(); } catch (Exception ignored) {}
        });
        shutdownWatcher.setDaemon(true);
        shutdownWatcher.start();

        while (running) {
            System.out.print("» ");
            if (!scanner.hasNextLine()) break;
            String command = scanner.nextLine();
            commandRegistry.executeCommand(command);
        }

        System.out.println("[SMAYL] Commando system stopped successfully.");
    }

    public void stopLoop() {
        this.running = false;
    }
}
