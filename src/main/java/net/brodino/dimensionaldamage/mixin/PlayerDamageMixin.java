package net.brodino.dimensionaldamage.mixin;

import net.brodino.dimensionaldamage.DimensionalDamage;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
class PlayerDamageMixin {

    @Inject(method = "applyDamage", at = @At("HEAD"), cancellable = true)
    private void applyDamage(DamageSource source, float amount, CallbackInfo ci) {

        PlayerEntity player = (PlayerEntity) (Object) this;

        Identifier currentDimension = player.getWorld().getRegistryKey().getValue();

        if (!DimensionalDamage.CONFIG.dimensions().contains(currentDimension.toString())) {
            return;
        }

        ci.cancel();
    }
}