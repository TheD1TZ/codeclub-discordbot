package me.ditz.codeclubbot.Modules;

import me.ditz.codeclubbot.Main;
import me.ditz.codeclubbot.Roles;
import org.javacord.api.entity.message.MessageBuilder;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.entity.user.User;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;
import org.javacord.api.util.logging.ExceptionLogger;

import java.awt.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class IntroductionChannel implements MessageCreateListener {
    ArrayList<String> addedRoles = new ArrayList<>();
    int pos;
    long latestBotMessage;

    @Override
    public void onMessageCreate(MessageCreateEvent event) {
        User user = event.getMessageAuthor().asUser().get();
        String message = event.getMessageContent();

        if (event.getChannel() != event.getServer().get().getChannelById(926210644112453712L).get()) return;

        if (user.isBot()) {
            event.getChannel().deleteMessages(latestBotMessage);
            latestBotMessage = event.getMessageId();

            event.getApi().getThreadPool().getScheduler().schedule(
                    () -> event.getChannel().deleteMessages(latestBotMessage),
                    30L, TimeUnit.SECONDS);
            return;
        }
        if (event.getApi().getRoleById(Roles.INTRODUCED_ROLE.getRole()).get().hasUser(user)) {
            EmbedBuilder embed = new EmbedBuilder()
                    .setTitle("Warning!")
                    .setDescription("You already have been introduced!\nAsk a Admin if you want to introduce again!")
                    .setColor(Color.RED);
            user.sendMessage(embed);
            event.getMessage().delete();
            return;
        }


        if (message.length() < 25) {
            new MessageBuilder()
                    .addEmbed(new EmbedBuilder()
                            .setColor(Color.red)
                            .setDescription("Your introduction has to be at least 25 characters long.")
                            .setTimestamp(Instant.now()))
                    .send(user);
            event.getMessage().delete();
            return;
        }

        if (message.contains("cpp") || message.contains("c++") || message.contains("C++")) {
            addedRoles.add("C++");
            user.addRole(event.getServer().get().getRoleById(Roles.CPP_ROLE.getRole()).get());
        }
        if (message.contains("cs") || message.contains("c#") || message.contains("C#")) {
            addedRoles.add("C#");
            user.addRole(event.getServer().get().getRoleById(Roles.CS_ROLE.getRole()).get());
        }
        if (message.contains("HTML") || message.contains("WebDev") || message.contains("html")) {
            addedRoles.add("HTML");
            user.addRole(event.getServer().get().getRoleById(Roles.HTML_ROLE.getRole()).get());
        }
        if (message.contains("Java") || message.contains("java")) {
            addedRoles.add("Java");
            user.addRole(event.getServer().get().getRoleById(Roles.JAVA_ROLE.getRole()).get());
        }
        if (message.contains("JS") || message.contains("js") || message.contains("JavaScript") || message.contains("javascript")) {
            addedRoles.add("JavaScript");
            user.addRole(event.getServer().get().getRoleById(Roles.JAVASCRIPT_ROLE.getRole()).get());
        }
        if (message.contains("Kotlin") || message.contains("kotlin")) {
            addedRoles.add("Kotlin");
            user.addRole(event.getServer().get().getRoleById(Roles.KOTLIN_ROLE.getRole()).get());
        }
        if (message.contains("python") || message.contains("Python") || message.contains("py")) {
            addedRoles.add("Python");
            user.addRole(event.getServer().get().getRoleById(Roles.PYTHON_ROLE.getRole()).get());
        }
        if (message.contains("PHP") || message.contains("php")) {
            addedRoles.add("PHP");
            user.addRole(event.getServer().get().getRoleById(Roles.PHP_ROLE.getRole()).get());
        }
        if (message.contains("ruby") || message.contains("Ruby")) {
            addedRoles.add("Ruby");
            user.addRole(event.getServer().get().getRoleById(Roles.RUBY_ROLE.getRole()).get());
        }
        if (message.contains("Linux") || message.contains("linux")) {
            addedRoles.add("Linux");
            user.addRole(event.getServer().get().getRoleById(Roles.LINUX_ROLE.getRole()).get());
        }
        if (message.contains("Servers") || message.contains("servers") || message.contains("host")) {
            addedRoles.add("Servers");
            user.addRole(event.getServer().get().getRoleById(Roles.SERVERS_ROLE.getRole()).get());
        }

        event.getChannel().deleteMessages(latestBotMessage);

        if (!addedRoles.isEmpty()) {
            new MessageBuilder()
                    .addEmbed(new EmbedBuilder()
                            .setColor(Color.green)
                            .setDescription("Welcome " + user.getName() + ", Nice to meet you!" + "\nYou have automatically been given the roles:\n" + addedRoles + "\n\nIf you want to add more roles head over to <#922618951878447125>")
                            .setTimestamp(Instant.now()))
                    .send(event.getChannel());
        } else {
            new MessageBuilder()
                    .addEmbed(new EmbedBuilder()
                            .setColor(Color.green)
                            .setDescription("Welcome " + user.getName() + ", Nice to meet you!" + "\nDo not forget to add your coding languages in <#922618951878447125>")
                            .setTimestamp(Instant.now()))
                    .send(event.getChannel());
        }
        addedRoles.clear();
        user.addRole(event.getServer().get().getRoleById(Roles.INTRODUCED_ROLE.getRole()).get());
    }
}
