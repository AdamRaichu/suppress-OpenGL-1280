package io.github.adamraichu.suppressopengl1280.mixin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.client.gl.GlDebug;

@Mixin(GlDebug.class)
public abstract class GlDebugMixin {
  private static boolean hasPostedMessage = false;

  private static Logger LOGGER = LoggerFactory.getLogger("Suppress OpenGL Error 1280");

  @Inject(at = @At(value = "HEAD"), method = "info(IIIIIJJ)V", cancellable = true)
  private static void suppressMessage(int source, int type, int id, int severity, int messageLength, long message,
      long l,
      CallbackInfo ci) {
    if (!(id == 1280)) {
      return;
    }
    if (hasPostedMessage) {
      ci.cancel();
    } else {
      LOGGER.info("OpenGL error 1280 (GL_INVALID_ENUM) is known to spam several times per second.");
      LOGGER.info("This is the last time (for this run) that an error with this id will be logged.");
      LOGGER.info("Go to https://github.com/AdamRaichu/suppress-opengl-1280/wiki for more info about this error.");
      hasPostedMessage = true;
    }
  }
}