package io.github.adamraichu.suppressopengl1280.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import net.minecraft.client.gl.GlDebug;

@Mixin(GlDebug.class)
public abstract class GlDebugMixin {
  boolean hasPostedMessage = false;

  @Inject(at = @At(value = "HEAD"), method = "info(IIIIIjj)V")
  private void suppressMessage(int source, int type, int id, int severity, int messageLength, long message, long l, CallbackInfo ci) {
    if () {}
  } 
}