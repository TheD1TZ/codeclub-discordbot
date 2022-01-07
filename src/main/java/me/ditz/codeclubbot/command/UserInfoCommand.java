package me.ditz.codeclubbot.command;

import org.javacord.api.entity.message.MessageAuthor;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.entity.user.User;
import org.javacord.api.event.interaction.SlashCommandCreateEvent;
import org.javacord.api.exception.MissingPermissionsException;
import org.javacord.api.interaction.SlashCommand;
import org.javacord.api.interaction.SlashCommandInteraction;
import org.javacord.api.listener.interaction.SlashCommandCreateListener;
import org.javacord.api.util.logging.ExceptionLogger;

public class UserInfoCommand implements SlashCommandCreateListener {
    @Override
    public void onSlashCommandCreate(SlashCommandCreateEvent event) {
        SlashCommand userinfo = SlashCommand.with("userinfo", "Sends the userinfo")
                .createForServer(event.getApi().getServerById(922516089320128513L).get())
                .join();

        User author = event.getInteraction().getUser();

        EmbedBuilder embed = new EmbedBuilder()
                .setTitle("User Info")
                .addField("Display Name", author.getName(), true)
                .addField("Name + Discriminator", author.getDiscriminatedName(), true)
                .addField("User Id", author.getIdAsString(), true)
                .addField("Online Status", author.getStatus().getStatusString(), true)
                .addField("Connected Clients", author.getCurrentClients().toString(),true)
                .setAuthor(author);


        SlashCommandInteraction interact = event.getSlashCommandInteraction();
        if (interact.getCommandName().equals("userinfo")) {
            interact.createImmediateResponder()
                    .addEmbed(embed)
                    .respond();
        }
    }
}
