package com.chaosdog.frivycat;

import com.chaosdog.frivycat.init.ModItems;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("frivycat")
public class FrivyCatMod {
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String ID = "frivycat";

    public FrivyCatMod() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModItems.init(eventBus);
    }
}
