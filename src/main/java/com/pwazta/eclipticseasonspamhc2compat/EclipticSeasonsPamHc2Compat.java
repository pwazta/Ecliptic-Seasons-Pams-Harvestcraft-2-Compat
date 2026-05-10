package com.pwazta.eclipticseasonspamhc2compat;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(EclipticSeasonsPamHc2Compat.MOD_ID)
public class EclipticSeasonsPamHc2Compat {
    public static final String MOD_ID = "eclipticseasonspamhc2compat";

    public EclipticSeasonsPamHc2Compat(FMLJavaModLoadingContext context) {
        context.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }
}
