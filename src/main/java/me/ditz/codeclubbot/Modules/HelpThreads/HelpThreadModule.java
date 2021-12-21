package me.ditz.codeclubbot.Modules.HelpThreads;

import org.javacord.api.entity.channel.*;
import org.javacord.api.entity.message.MessageBuilder;
import org.javacord.api.entity.message.MessageFlag;
import org.javacord.api.entity.message.component.ActionRow;
import org.javacord.api.entity.message.component.Button;
import org.javacord.api.entity.server.Server;
import org.javacord.api.entity.user.User;
import org.javacord.api.event.interaction.MessageComponentCreateEvent;
import org.javacord.api.interaction.MessageComponentInteraction;
import org.javacord.api.listener.interaction.MessageComponentCreateListener;
import org.javacord.api.util.logging.ExceptionLogger;

import java.util.Optional;

public class HelpThreadModule implements MessageComponentCreateListener {
    @Override
    public void onComponentCreate(MessageComponentCreateEvent event) {

        if (!event.getMessageComponentInteraction().getChannel().equals(event.getApi().getTextChannelById("922555442796847185"))) return;
        MessageComponentInteraction messageComponentInteraction = event.getMessageComponentInteraction();
        String customId = messageComponentInteraction.getCustomId();
        Server server = event.getInteraction().getServer().get();
        User user = event.getInteraction().getUser();

            switch (customId) {
                case "create":
                    ChannelCategory channelCategory = event.getInteraction().getApi().getChannelCategoryById("922883860155486258").get();

                    messageComponentInteraction.createImmediateResponder()
                            .respond();

                    ServerTextChannel channel = new ServerTextChannelBuilder(server)
                            .setName(user.getName() + " help thread")
                            .setTopic(user.getDiscriminatedName())
                            .setCategory(channelCategory)
                            .create().join();

                    new MessageBuilder()
                            .setContent("~~**---------------------------------------------------------------------------------------------**~~\n**" +
                                    user.getName() + "'s Help Thread**\n" +
                                    "\n" +
                                    "Describe the issue you need solving in as much detail as possible. Post the code snippets in good formatting so it can be read easily.\n" +
                                    "Once the issue has been solved, close the channel by clicking the red button.\n" +
                                    "\n" +
                                    "~~**---------------------------------------------------------------------------------------------**~~")
                            .addComponents(
                                    ActionRow.of(Button.danger("remove","Remove Thread")))
                            .send(channel);


                    break;
                case "remove":
                        if (server.getTextChannelById(event.getInteraction().getChannel().get().getId()).get().getTopic().equals(user.getDiscriminatedName())) {
                            messageComponentInteraction.createImmediateResponder()
                                    .setContent("Removing your thread!")
                                    .setFlags(MessageFlag.EPHEMERAL)
                                    .respond();
                            event.getInteraction().getServer().flatMap(server1 -> server1.getTextChannelById(event.getInteraction().getChannel().get().getId())).ifPresent(serverTextChannel -> serverTextChannel.delete().exceptionally(ExceptionLogger.get()));
                        } else {
                            messageComponentInteraction.createImmediateResponder()
                                    .setContent("This is not your thread!")
                                    .setFlags(MessageFlag.EPHEMERAL)
                                    .respond();
                        }

                    break;
            }
        }
}
