package me.ditz.codeclubbot;

import io.github.cdimascio.dotenv.Dotenv;
import me.ditz.codeclubbot.Events.MemberJoinEvent;
import me.ditz.codeclubbot.Modules.HelpThreads.HelpThreadMessage;
import me.ditz.codeclubbot.Modules.HelpThreads.HelpThreadModule;
import me.ditz.codeclubbot.Modules.MenuRespond;
import me.ditz.codeclubbot.Modules.ServerInfo;
import me.ditz.codeclubbot.Modules.Suggestions;
import me.ditz.codeclubbot.command.UserInfoCommand;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.util.logging.FallbackLoggerConfiguration;

public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);

    /**
     * The entrance point of our program.
     *
     * @param args The arguments for the program. The first element should be the bot's token.
     */
    public static void main(String[] args) {
        // Enable debugging, if no slf4j logger was found
        Dotenv dotenv = Dotenv.load();

        // We login blocking, just because it is simpler and doesn't matter here
        DiscordApi api = new DiscordApiBuilder().setToken(System.getenv("TOKEN")).setAllIntents().login().join();

        // Print the invite url of the bot
        logger.info("You can invite me by using the following url: " + api.createBotInvite());

        // Add Commands
        api.addMessageCreateListener(new UserInfoCommand());

        // Add Events
        api.addServerMemberJoinListener(new MemberJoinEvent());
        api.addMessageCreateListener(new Suggestions());
        api.addMessageCreateListener(new ServerInfo());
        api.addMessageCreateListener(new HelpThreadMessage());
        api.addMessageComponentCreateListener(new HelpThreadModule());
        api.addMessageComponentCreateListener(new MenuRespond());

    }

}
