package me.ditz.codeclubbot.command;

import me.ditz.codeclubbot.Main;
import org.javacord.api.event.interaction.SlashCommandCreateEvent;
import org.javacord.api.interaction.*;
import org.javacord.api.listener.interaction.SlashCommandCreateListener;

public class PingCommand implements SlashCommandCreateListener {
    @Override
    public void onSlashCommandCreate(SlashCommandCreateEvent event) {
        SlashCommand ping = SlashCommand.with("ping", "Checks if the CodeClub bot is online!")
                .createForServer(event.getApi().getServerById(922516089320128513L).get())
                .join();

        SlashCommandInteraction interact = event.getSlashCommandInteraction();
        if (interact.getCommandName().equals("ping")) {
            interact.createImmediateResponder()
                    .setContent("pong!")
                    .respond();
        }
    }
}
