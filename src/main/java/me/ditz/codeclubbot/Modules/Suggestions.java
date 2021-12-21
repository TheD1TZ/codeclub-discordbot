package me.ditz.codeclubbot.Modules;

import org.javacord.api.entity.channel.ServerTextChannel;
import org.javacord.api.entity.message.Message;
import org.javacord.api.entity.message.MessageBuilder;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.entity.user.User;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

import java.awt.*;

public class Suggestions implements MessageCreateListener {
    @Override
    public void onMessageCreate(MessageCreateEvent event) {
        long id = Long.parseLong("922611421597040721");
        ServerTextChannel suggestChannel = event.getApi().getServerTextChannelById(id).get();
        Message message = event.getMessage();

        if(!message.getChannel().equals(suggestChannel)) return;

        User user = event.getMessageAuthor().asUser().get();



        if(!message.getAuthor().isBotUser()) {
            message.delete();
            new MessageBuilder()
                    .addEmbed(new EmbedBuilder()
                            .setAuthor(user.getDiscriminatedName(), "", user.getAvatar())
                            .setDescription(message.getReadableContent())
                            .setColor(Color.gray)
                    ).send(suggestChannel).join().addReactions(":green_checkmark:922608548377141248", ":indiffrent_tick:922608547953537095", ":red_checkmark:922608548440060014");
        }
    }
}
