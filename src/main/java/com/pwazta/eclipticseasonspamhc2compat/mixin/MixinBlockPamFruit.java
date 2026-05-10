package com.pwazta.eclipticseasonspamhc2compat.mixin;

import com.pam.pamhc2trees.blocks.BlockPamFruit;
import com.pwazta.eclipticseasonspamhc2compat.Config;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.Event;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

// Gates BlockPamFruit#randomTick by season. BlockPamFruit doesn't extend CropBlock and doesn't fire
// any growth event natively, so Ecliptic Seasons' CropGrowEvent.Pre listener never sees these blocks.
// We re-fire it ourselves; ES's existing handler then runs the full season/humidity/greenhouse check.
@Mixin(BlockPamFruit.class)
public class MixinBlockPamFruit {

    @Inject(method = "m_213898_", at = @At("HEAD"), cancellable = true, require = 0)
    private void eclipticseasonspamhc2compat$gateGrowthBySeason(
            BlockState state, ServerLevel level, BlockPos pos, RandomSource rng, CallbackInfo ci) {
        if (!Config.FRUIT_MIXIN_ENABLED.get()) return;
        BlockEvent.CropGrowEvent.Pre event = new BlockEvent.CropGrowEvent.Pre(level, pos, state);
        MinecraftForge.EVENT_BUS.post(event);
        if (event.getResult() == Event.Result.DENY) ci.cancel();
    }
}
