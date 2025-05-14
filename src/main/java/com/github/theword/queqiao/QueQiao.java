package com.github.theword.queqiao;

import com.github.theword.queqiao.handle.HandleApiImpl;
import com.github.theword.queqiao.handle.HandleCommandReturnMessageImpl;
import com.github.theword.queqiao.tool.constant.BaseConstant;
import com.github.theword.queqiao.tool.constant.ServerTypeConstant;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.event.FMLServerStoppingEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import static com.github.theword.queqiao.tool.utils.Tool.initTool;
import static com.github.theword.queqiao.tool.utils.Tool.websocketManager;

@Mod(modid = BaseConstant.MOD_ID, name = BaseConstant.MODULE_NAME, useMetadata = true, serverSideOnly =true)
public class QueQiao {

    public static MinecraftServer minecraftServer;

    public QueQiao() {
        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(new EventProcessor());
    }

    @SideOnly(Side.SERVER)
    @Mod.EventHandler
    public void onServerStarting(FMLServerStartingEvent event) {
        minecraftServer = event.getServer();
        initTool(true, minecraftServer.getMinecraftVersion(), ServerTypeConstant.FORGE, new HandleApiImpl(), new HandleCommandReturnMessageImpl());
        websocketManager.startWebsocketOnServerStart();
    }

    @SideOnly(Side.SERVER)
    @Mod.EventHandler
    public void onServerStopping(FMLServerStoppingEvent event) {
        websocketManager.stopWebsocketByServerClose();
    }

}
