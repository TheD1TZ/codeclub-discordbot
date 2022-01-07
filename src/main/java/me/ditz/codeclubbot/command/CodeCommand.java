package me.ditz.codeclubbot.command;

import org.javacord.api.entity.message.MessageBuilder;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.interaction.SlashCommandCreateEvent;
import org.javacord.api.interaction.SlashCommand;
import org.javacord.api.interaction.SlashCommandInteraction;
import org.javacord.api.listener.interaction.SlashCommandCreateListener;

import java.awt.*;

public class CodeCommand implements SlashCommandCreateListener {
    @Override
    public void onSlashCommandCreate(SlashCommandCreateEvent event) {
        SlashCommand code = SlashCommand.with("code", "Get information on how to properly post your code!")
                .createForServer(event.getApi().getServerById(922516089320128513L).get())
                .join();

        SlashCommandInteraction interact = event.getSlashCommandInteraction();
        if (interact.getCommandName().equals("code")) {
            interact.createImmediateResponder()
                    .addEmbed(
                            new EmbedBuilder()
                                    .setTitle("Code Blocks")
                                    .setDescription("Please send your code in code blocks!\n\n" +
                                            "**Example**\n" +
                                            "```\n"+
                                            "`\u200B``java\n" +
                                            "public static void main(String[] args) {\n" +
                                            "System.out.println(\"Hello World!\");\n" +
                                            "}\n`\u200B``\n```\n" +
                                            ""+
                                            "**Becomes**\n" +
                                            "```java\n" +
                                            "public static void main(String[] args) {\n" +
                                            "    System.out.println(\"Hello World!\");\n" +
                                            "}```\n" +
                                            "Use [PasteBin](https://pastebin.com/) or [Gist](https://gist.github.com/) for larger segments of code!")
                                    .setColor(Color.orange)
                    )
                    .respond();
        }
    }
}
