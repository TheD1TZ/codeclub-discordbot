package me.ditz.codeclubbot.Modules.HelpThreads;

import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.entity.message.MessageBuilder;
import org.javacord.api.entity.message.component.ActionRow;
import org.javacord.api.entity.message.component.Button;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

public class HelpThreadMessage implements MessageCreateListener {
    @Override
    public void onMessageCreate(MessageCreateEvent event) {
        TextChannel channel = event.getServer().get().getTextChannelById("922555442796847185").get();
        if (!event.getChannel().equals(channel)) return;
        if (event.getMessageContent().equals(".renew")) {
            channel.deleteMessages(channel.getMessagesAsStream()::iterator);

            new MessageBuilder()
                    .setContent(
                            "**Help Threads**\n" +
                            "Help threads are channels you can create just for your specific thing that you need help with.\n" +
                            "\n" +
                            "After creating the channel, describe what you need help with in as much detail as possible. Do not use the thread channels as chatrooms. Speak about the issue.")
                    .addComponents(
                            ActionRow.of(Button.success("create","Create Thread"))
                    )
                    .send(channel);
        }
    }
}
