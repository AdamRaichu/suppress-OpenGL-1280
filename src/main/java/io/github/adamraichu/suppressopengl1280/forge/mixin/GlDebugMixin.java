package io.github.adamraichu.suppressopengl1280.forge.mixin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.mojang.blaze3d.platform.GlDebug;

import io.github.adamraichu.suppressopengl1280.forge.config.ConfigOptions;
import me.shedaniel.autoconfig.AutoConfig;

@Mixin(GlDebug.class)
public abstract class GlDebugMixin {
  private static boolean hasPostedMessage1280 = false;
  private static boolean hasPostedMessage1281 = false;
  private static boolean hasPostedMessage1282 = false;
  private static boolean hasPostedMessage2 = false;

  private static Logger LOGGER = LoggerFactory.getLogger("Suppress OpenGL Error 1280");

  @Inject(at = @At(value = "HEAD"), method = "printDebugLog(IIIIIJJ)V", cancellable = true)
  private static void suppressMessage(int source, int type, int id, int severity, int messageLength, long message,
      long l,
      CallbackInfo ci) {
    ConfigOptions config = AutoConfig.getConfigHolder(ConfigOptions.class).getConfig();

    if (id == 1280 && config.suppress1280) {
      if (hasPostedMessage1280) {
        ci.cancel();
      } else {
        LOGGER.info("This mod has been configured to suppress OpenGL error 1280.");
        LOGGER.info("You can change that at any time via cloth config.");
        LOGGER.info("This error will not be shown again for this run of Minecraft unless you change the config.");
        hasPostedMessage1280 = true;
      }
    }
    if (id == 1281 && config.suppress1281) {
      if (hasPostedMessage1281) {
        ci.cancel();
      } else {
        LOGGER.info("This mod has been configured to suppress OpenGL error 1281.");
        LOGGER.info("You can change that at any time via cloth config.");
        LOGGER.info("This error will not be shown again for this run of Minecraft unless you change the config.");
        hasPostedMessage1281 = true;
      }
    }
    if (id == 1282 && config.suppress1282) {
      if (hasPostedMessage1282) {
        ci.cancel();
      } else {
        LOGGER.info("This mod has been configured to suppress OpenGL error 1282.");
        LOGGER.info("You can change that at any time via cloth config.");
        LOGGER.info("This error will not be shown again for this run of Minecraft unless you change the config.");
        hasPostedMessage1282 = true;
      }
    }
    if (id == 2 && config.suppress2) {
      if (hasPostedMessage2) {
        ci.cancel();
      } else {
        LOGGER.info("This mod has been configured to suppress OpenGL error 2.");
        LOGGER.info("You can change that at any time via cloth config.");
        LOGGER.info("This error will not be shown again for this run of Minecraft unless you change the config.");
        hasPostedMessage2 = true;
      }
    }
  }
}