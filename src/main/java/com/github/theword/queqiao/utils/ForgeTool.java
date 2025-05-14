package com.github.theword.queqiao.utils;

import com.github.theword.queqiao.event.forge.ForgeServerPlayer;
import net.minecraft.entity.player.EntityPlayerMP;

public class ForgeTool {
    public static ForgeServerPlayer getForgePlayer(EntityPlayerMP player) {
        ForgeServerPlayer forgeServerPlayer = new ForgeServerPlayer();
        forgeServerPlayer.setNickname(player.getName());
        forgeServerPlayer.setDisplayName(player.getDisplayName().toString());
        forgeServerPlayer.setUuid(player.getUniqueID());
        forgeServerPlayer.setIpAddress(player.getPlayerIP());
        return forgeServerPlayer;
    }
}