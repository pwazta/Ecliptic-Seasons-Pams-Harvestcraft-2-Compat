package com.pwazta.eclipticseasonspamhc2compat;

import net.minecraftforge.common.ForgeConfigSpec;

public final class Config {
    public static final ForgeConfigSpec SPEC;
    public static final ForgeConfigSpec.BooleanValue FRUIT_MIXIN_ENABLED;

    static {
        ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();
        FRUIT_MIXIN_ENABLED = builder
                .comment("Gate Pam's fruit-block growth by season. When off, fruit blocks grow year-round; crops and saplings are unaffected.")
                .define("fruitMixinEnabled", true);
        SPEC = builder.build();
    }

    private Config() {}
}
