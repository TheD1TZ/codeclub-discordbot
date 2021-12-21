package me.ditz.codeclubbot.Events;

import me.ditz.codeclubbot.Roles;
import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.entity.message.MessageBuilder;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.entity.user.User;
import org.javacord.api.event.server.member.ServerMemberJoinEvent;
import org.javacord.api.listener.server.member.ServerMemberJoinListener;

import java.awt.*;

public class MemberJoinEvent implements ServerMemberJoinListener {
    @Override
    public void onServerMemberJoin(ServerMemberJoinEvent event) {
        long id = Long.parseLong("922516089492111368");
        TextChannel welcomeChannel = event.getServer().getApi().getServerTextChannelById(id).get();
        User user = event.getUser();

        new MessageBuilder().addEmbed(
        new EmbedBuilder()
                .setTitle("New member joined!")
                .setDescription("Welcome **" + user.getName() + "** to the **CodeClub**!")
                .setColor(Color.DARK_GRAY)
                .setThumbnail(user.getAvatar())
        ).send(welcomeChannel);

        user.addRole(event.getServer().getRoleById(Roles.MEMBER_ROLE.getRole()).get());
    }
}
