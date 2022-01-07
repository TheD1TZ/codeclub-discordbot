package me.ditz.codeclubbot.command;

import me.ditz.codeclubbot.Main;
import org.javacord.api.DiscordApi;
import org.javacord.api.entity.server.Server;
import org.javacord.api.interaction.*;
import org.javacord.api.interaction.internal.SlashCommandBuilderDelegate;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class UserInfoCommand2 {
    Main bot;
    public UserInfoCommand2(Main bot) {
        this.bot = bot;
    }

}
