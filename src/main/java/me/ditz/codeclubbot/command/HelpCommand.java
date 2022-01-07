package me.ditz.codeclubbot.command;

import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.interaction.SlashCommandCreateEvent;
import org.javacord.api.interaction.SlashCommand;
import org.javacord.api.interaction.SlashCommandInteraction;
import org.javacord.api.listener.interaction.SlashCommandCreateListener;

import java.awt.*;

public class HelpCommand implements SlashCommandCreateListener {
    @Override
    public void onSlashCommandCreate(SlashCommandCreateEvent event) {
        SlashCommand help = SlashCommand.with("help", "Sends a helpful embed!")
                .createForServer(event.getApi().getServerById(922516089320128513L).get())
                .join();
        EmbedBuilder embed = new EmbedBuilder()
                .setTitle("Need help " + event.getInteraction().getUser().getName()+"?")
                .setDescription("Need help coding go to <#922516090062532641>!"+
                        "\nNeed specific help? Go to <#922618951878447125> and select your languages" +
                        "\nThen just ask your question in the specific channel!")
                .setColor(Color.orange);

        SlashCommandInteraction interact = event.getSlashCommandInteraction();
        if (interact.getCommandName().equals("help")) {
            interact.createImmediateResponder()
                    .addEmbed(embed)
                    .respond();
        }
    }
}
