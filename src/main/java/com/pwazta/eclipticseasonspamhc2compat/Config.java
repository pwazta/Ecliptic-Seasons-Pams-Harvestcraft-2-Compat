package com.pwazta.eclipticseasonspamhc2compat;

import net.minecraftforge.common.ForgeConfigSpec;

public final class Config {
    public static final ForgeConfigSpec SPEC;
    public static final ForgeConfigSpec.BooleanValue FRUIT_MIXIN_ENABLED;

    static {
        ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();
        FRUIT_MIXIN_ENABLED = builder
                .comment("If true, Pam's fruit blocks (BlockPamFruit, BlockPamLogFruit) have their random-tick growth gated by season via Ecliptic Seasons. If false, fruit blocks grow year-round (saplings and crops are unaffected by this toggle — they are season-locked through Forge's vanilla CropGrowEvent / SaplingGrowTreeEvent flow which Ecliptic Seasons already listens to). Toggle takes effect immediately, no game restart required.")
                .define("fruitMixinEnabled", true);
        SPEC = builder.build();
    }

    private Config() {}
}
