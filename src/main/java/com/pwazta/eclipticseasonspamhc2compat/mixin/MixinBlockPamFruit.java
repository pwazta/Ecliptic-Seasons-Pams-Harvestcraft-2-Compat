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

// BlockPamFruit doesn't extend CropBlock and never fires CropGrowEvent.Pre natively;
// re-fire it from randomTick so the seasons handler can veto growth.
@Mixin(BlockPamFruit.class)
public class MixinBlockPamFruit {

    @Inject(
            method = "randomTick(Lnet/minecraft/world/level/block/state/BlockState;Lnet/minecraft/server/level/ServerLevel;Lnet/minecraft/core/BlockPos;Lnet/minecraft/util/RandomSource;)V",
            at = @At("HEAD"), cancellable = true, require = 0)
    private void eclipticseasonspamhc2compat$gateGrowthBySeason(
            BlockState state, ServerLevel level, BlockPos pos, RandomSource rng, CallbackInfo ci) {
        if (!Config.FRUIT_MIXIN_ENABLED.get()) return;
        BlockEvent.CropGrowEvent.Pre event = new BlockEvent.CropGrowEvent.Pre(level, pos, state);
        MinecraftForge.EVENT_BUS.post(event);
        if (event.getResult() == Event.Result.DENY) ci.cancel();
    }
}
