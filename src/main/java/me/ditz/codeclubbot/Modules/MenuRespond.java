package me.ditz.codeclubbot.Modules;

import me.ditz.codeclubbot.Roles;
import org.javacord.api.entity.message.component.SelectMenuOption;
import org.javacord.api.entity.user.User;
import org.javacord.api.event.interaction.MessageComponentCreateEvent;
import org.javacord.api.interaction.MessageComponentInteraction;
import org.javacord.api.listener.interaction.MessageComponentCreateListener;

public class MenuRespond implements MessageComponentCreateListener {
    @Override
    public void onComponentCreate(MessageComponentCreateEvent event) {
        MessageComponentInteraction messageComponentInteraction = event.getMessageComponentInteraction();
        String customId = messageComponentInteraction.getCustomId();

        if (!event.getInteraction().getChannel().equals(event.getInteraction().getServer().get().getTextChannelById(922618951878447125L))) return;

        if ("languages".equals(customId)) {
            User user = messageComponentInteraction.getUser();

            if (messageComponentInteraction.asSelectMenuInteraction().get().getChosenOptions().isEmpty()) {
                messageComponentInteraction.createImmediateResponder()
                        .respond();
            }

            // C++ Ranks
            if (messageComponentInteraction.asSelectMenuInteraction().get().getChosenOptions().stream().anyMatch(selectMenuOption -> selectMenuOption.getValue().contains("cpp"))) {
                messageComponentInteraction.createImmediateResponder()
                        .respond();
                user.addRole(event.getApi().getRoleById(Roles.CPP_ROLE.getRole()).get());
            } else {
                messageComponentInteraction.createImmediateResponder()
                        .respond();
                user.removeRole(event.getApi().getRoleById(Roles.CPP_ROLE.getRole()).get());
            }

            // C# Ranks
            if (messageComponentInteraction.asSelectMenuInteraction().get().getChosenOptions().stream().anyMatch(selectMenuOption -> selectMenuOption.getValue().contains("cs"))) {
                messageComponentInteraction.createImmediateResponder()
                        .respond();
                user.addRole(event.getApi().getRoleById(Roles.CS_ROLE.getRole()).get());
            } else {
                messageComponentInteraction.createImmediateResponder()
                        .respond();
                user.removeRole(event.getApi().getRoleById(Roles.CS_ROLE.getRole()).get());
            }

            //WebDev
            if (messageComponentInteraction.asSelectMenuInteraction().get().getChosenOptions().stream().anyMatch(selectMenuOption -> selectMenuOption.getValue().contains("html"))) {
                messageComponentInteraction.createImmediateResponder()
                        .respond();
                user.addRole(event.getApi().getRoleById(Roles.HTML_ROLE.getRole()).get());
            } else {
                user.removeRole(event.getApi().getRoleById(Roles.HTML_ROLE.getRole()).get());
            }

            // Java
            if (messageComponentInteraction.asSelectMenuInteraction().get().getChosenOptions().stream().anyMatch(selectMenuOption -> selectMenuOption.getValue().contains("java"))) {
                messageComponentInteraction.createImmediateResponder()
                        .respond();
                user.addRole(event.getApi().getRoleById(Roles.JAVA_ROLE.getRole()).get());
            } else {
                messageComponentInteraction.createImmediateResponder()
                        .respond();
                user.removeRole(event.getApi().getRoleById(Roles.JAVA_ROLE.getRole()).get());
            }

            // JavaScript Role
            if (messageComponentInteraction.asSelectMenuInteraction().get().getChosenOptions().stream().anyMatch(selectMenuOption -> selectMenuOption.getValue().contains("js"))) {
                messageComponentInteraction.createImmediateResponder()
                        .respond();
                user.addRole(event.getApi().getRoleById(Roles.JAVASCRIPT_ROLE.getRole()).get());
            } else {
                messageComponentInteraction.createImmediateResponder()
                        .respond();
                user.removeRole(event.getApi().getRoleById(Roles.JAVASCRIPT_ROLE.getRole()).get());
            }

            // Kotlin Role
            if (messageComponentInteraction.asSelectMenuInteraction().get().getChosenOptions().stream().anyMatch(selectMenuOption -> selectMenuOption.getValue().contains("kotlin"))) {
                messageComponentInteraction.createImmediateResponder()
                        .respond();
                user.addRole(event.getApi().getRoleById(Roles.KOTLIN_ROLE.getRole()).get());
            } else {
                messageComponentInteraction.createImmediateResponder()
                        .respond();
                user.removeRole(event.getApi().getRoleById(Roles.KOTLIN_ROLE.getRole()).get());
            }

            // Python Role
            if (messageComponentInteraction.asSelectMenuInteraction().get().getChosenOptions().stream().anyMatch(selectMenuOption -> selectMenuOption.getValue().contains("python"))) {
                messageComponentInteraction.createImmediateResponder()
                        .respond();
                user.addRole(event.getApi().getRoleById(Roles.PYTHON_ROLE.getRole()).get());
            } else {
                messageComponentInteraction.createImmediateResponder()
                        .respond();
                user.removeRole(event.getApi().getRoleById(Roles.PYTHON_ROLE.getRole()).get());
            }

            // PHP Role
            if (messageComponentInteraction.asSelectMenuInteraction().get().getChosenOptions().stream().anyMatch(selectMenuOption -> selectMenuOption.getValue().contains("php"))) {
                messageComponentInteraction.createImmediateResponder()
                        .respond();
                user.addRole(event.getApi().getRoleById(Roles.PHP_ROLE.getRole()).get());
            } else {
                messageComponentInteraction.createImmediateResponder()
                        .respond();
                user.removeRole(event.getApi().getRoleById(Roles.PHP_ROLE.getRole()).get());
            }


            // RUBY Role
            if (messageComponentInteraction.asSelectMenuInteraction().get().getChosenOptions().stream().anyMatch(selectMenuOption -> selectMenuOption.getValue().contains("ruby"))) {
                messageComponentInteraction.createImmediateResponder()
                        .respond();
                user.addRole(event.getApi().getRoleById(Roles.RUBY_ROLE.getRole()).get());
            } else {
                messageComponentInteraction.createImmediateResponder()
                        .respond();
                user.removeRole(event.getApi().getRoleById(Roles.RUBY_ROLE.getRole()).get());
            }


            // LINUX Role
            if (messageComponentInteraction.asSelectMenuInteraction().get().getChosenOptions().stream().anyMatch(selectMenuOption -> selectMenuOption.getValue().contains("linux"))) {
                messageComponentInteraction.createImmediateResponder()
                        .respond();
                user.addRole(event.getApi().getRoleById(Roles.LINUX_ROLE.getRole()).get());
            } else {
                messageComponentInteraction.createImmediateResponder()
                        .respond();
                user.removeRole(event.getApi().getRoleById(Roles.LINUX_ROLE.getRole()).get());
            }


            // SERVERS Role
            if (messageComponentInteraction.asSelectMenuInteraction().get().getChosenOptions().stream().anyMatch(selectMenuOption -> selectMenuOption.getValue().contains("servers"))) {
                messageComponentInteraction.createImmediateResponder()
                        .respond();
                user.addRole(event.getApi().getRoleById(Roles.SERVERS_ROLE.getRole()).get());
            } else {
                messageComponentInteraction.createImmediateResponder()
                        .respond();
                user.removeRole(event.getApi().getRoleById(Roles.SERVERS_ROLE.getRole()).get());
            }



        }
    }
}
