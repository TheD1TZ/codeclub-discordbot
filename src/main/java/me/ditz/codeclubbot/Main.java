package me.ditz.codeclubbot;

import me.ditz.codeclubbot.Events.MemberJoinEvent;
import me.ditz.codeclubbot.Modules.HelpThreads.HelpThreadMessage;
import me.ditz.codeclubbot.Modules.HelpThreads.HelpThreadModule;
import me.ditz.codeclubbot.Modules.IntroductionChannel;
import me.ditz.codeclubbot.Modules.MenuRespond;
import me.ditz.codeclubbot.Modules.ServerInfo;
import me.ditz.codeclubbot.Modules.Suggestions;
import me.ditz.codeclubbot.command.CodeCommand;
import me.ditz.codeclubbot.command.HelpCommand;
import me.ditz.codeclubbot.command.PingCommand;
import me.ditz.codeclubbot.command.UserInfoCommand;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.entity.activity.ActivityType;
import org.javacord.api.entity.server.Server;
import org.javacord.api.entity.user.UserStatus;
import org.javacord.api.interaction.SlashCommand;
import org.javacord.api.interaction.SlashCommandOption;
import org.javacord.api.interaction.SlashCommandOptionChoice;
import org.javacord.api.interaction.SlashCommandOptionType;
import org.javacord.api.util.logging.FallbackLoggerConfiguration;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);


    public static void main(String[] args) {
        // We login blocking, just because it is simpler and doesn't matter here
        DiscordApi api = new DiscordApiBuilder().setToken(args[0]).setAllIntents().login().join();
        Server server = api.getServerById(922516089320128513L).get();
        api.updateStatus(UserStatus.IDLE);
        api.updateActivity(ActivityType.LISTENING, "events");


        // Add Commands
        //api.addMessageCreateListener(new UserInfoCommand());
        api.addSlashCommandCreateListener(new PingCommand());
        api.addSlashCommandCreateListener(new CodeCommand());
        api.addSlashCommandCreateListener(new UserInfoCommand());
        api.addSlashCommandCreateListener(new HelpCommand());




        // Add Events
        api.addServerMemberJoinListener(new MemberJoinEvent());
        api.addMessageCreateListener(new Suggestions());
        api.addMessageCreateListener(new ServerInfo());
        api.addMessageCreateListener(new HelpThreadMessage());
        api.addMessageComponentCreateListener(new HelpThreadModule());
        api.addMessageComponentCreateListener(new MenuRespond());
        api.addMessageCreateListener(new IntroductionChannel());


    }
}
