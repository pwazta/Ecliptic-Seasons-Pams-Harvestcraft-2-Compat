package com.pwazta.eclipticseasonspamhc2compat.mixin;

import com.pam.pamhc2trees.blocks.BlockPamLogFruit;
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

// Gates BlockPamLogFruit growth by season. Note that BlockPamLogFruit (verified via javap) overrides
// m_213897_ which is BlockBehaviour#tick (scheduled tick), NOT m_213898_ (randomTick). This is unusual
// but it's what Pam's actually does in the 1.20 jar. Whichever method drives growth, that's what we hook.
@Mixin(BlockPamLogFruit.class)
public class MixinBlockPamLogFruit {

    @Inject(method = "m_213897_", at = @At("HEAD"), cancellable = true, require = 0)
    private void eclipticseasonspamhc2compat$gateGrowthBySeason(
            BlockState state, ServerLevel level, BlockPos pos, RandomSource rng, CallbackInfo ci) {
        if (!Config.FRUIT_MIXIN_ENABLED.get()) return;
        BlockEvent.CropGrowEvent.Pre event = new BlockEvent.CropGrowEvent.Pre(level, pos, state);
        MinecraftForge.EVENT_BUS.post(event);
        if (event.getResult() == Event.Result.DENY) ci.cancel();
    }
}
