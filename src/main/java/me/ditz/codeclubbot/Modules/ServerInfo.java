package me.ditz.codeclubbot.Modules;

import org.javacord.api.DiscordApi;
import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.entity.emoji.CustomEmoji;
import org.javacord.api.entity.emoji.Emoji;
import org.javacord.api.entity.message.Message;
import org.javacord.api.entity.message.MessageBuilder;
import org.javacord.api.entity.message.component.ActionRow;
import org.javacord.api.entity.message.component.SelectMenu;
import org.javacord.api.entity.message.component.SelectMenuOption;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.interaction.MessageComponentCreateEvent;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.interaction.MessageComponentInteraction;
import org.javacord.api.listener.interaction.MessageComponentCreateListener;
import org.javacord.api.listener.message.MessageCreateListener;

import java.awt.*;
import java.util.Arrays;

public class ServerInfo implements MessageCreateListener {
    @Override
    public void onMessageCreate(MessageCreateEvent event) {
        TextChannel channel = event.getServer().get().getRulesChannel().get();
        if (!event.getChannel().equals(channel)) return;
        if (event.getMessageContent().equals(".renew")) {
            channel.deleteMessages(channel.getMessagesAsStream()::iterator);

            new MessageBuilder()
                    .setContent("https://cumming.xyz/FUgA2/kIZaVuWA56.png")
                    .send(channel);

            new MessageBuilder()
                    .setContent(
                            "Welcome to the CodeClub! <:CodeClub:922884681932886066>\n" +
                            "\n" +
                            "Rules :newspaper:\n" +
                            "The rules are simple and are based upon common sense along with Discord's community guidelines: https://discord.com/guidelines\n" +
                            "\n" +
                            "1. Don't be rude or hateful\n" +
                            "2. Don't advertise in help channels or places that it doesn't make sense\n" +
                            "3. Don't DM staff for help with programming unless they ask you to\n" +
                            "\n" +
                            "Besides that, we are pretty chill and you should be too. This is a place of learning and growing!")
                    .removeAllEmbeds()
                    .send(channel);

            new MessageBuilder()
                    .addEmbed(new EmbedBuilder()
                            .setTitle("\uD83E\uDD16 Coding language roles")
                            .setDescription(
                                    "Select the languages you want to be added on your account. You can add the following languages:\n\n" +
                                    "<:cpp:922525879219937330> **C++**\n" +
                                    "<:cs:922526359484518440> **C#**\n" +
                                    "<:html:922526360151412786> **HTML**\n" +
                                    "<:java:922526359996203018> **Java**\n" +
                                    "<:js:922526359178313739> **JavaScript**\n" +
                                    "<:kotlin:922526359560024115> **Kotlin**\n" +
                                    "<:python:922526359421616179> **Python**\n" +
                                    "<:php:922562995672973322> **PHP**")
                            .setColor(Color.LIGHT_GRAY))
                    .addComponents(
                            ActionRow.of(SelectMenu.create("languages", "Click here to show the languages", 0, 8,
                                    Arrays.asList(
                                            SelectMenuOption.create("C++", "cpp", "Click here to add C++",event.getApi().getCustomEmojiById("922525879219937330").get()),
                                            SelectMenuOption.create("C#", "cs", "Click here to add C#",event.getApi().getCustomEmojiById("922526359484518440").get()),
                                            SelectMenuOption.create("HTML", "html", "Click here to add HTML",event.getApi().getCustomEmojiById("922526360151412786").get()),
                                            SelectMenuOption.create("Java", "java", "Click here to add Java",event.getApi().getCustomEmojiById("922526359996203018").get()),
                                            SelectMenuOption.create("JavaScript", "js", "Click here to add JavaScript",event.getApi().getCustomEmojiById("922526359178313739").get()),
                                            SelectMenuOption.create("Kotlin", "kotlin", "Click here to add Kotlin",event.getApi().getCustomEmojiById("922526359560024115").get()),
                                            SelectMenuOption.create("Python", "python", "Click here to add Python",event.getApi().getCustomEmojiById("922526359421616179").get()),
                                            SelectMenuOption.create("PHP", "php", "Click here to add PHP",event.getApi().getCustomEmojiById("922562995672973322").get())
                                    ))))
                    .send(channel);


        }
    }
}

