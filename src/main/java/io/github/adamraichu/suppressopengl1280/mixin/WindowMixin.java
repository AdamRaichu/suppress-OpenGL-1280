package io.github.adamraichu.suppressopengl1280.mixin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import io.github.adamraichu.suppressopengl1280.config.ConfigOptions;
import me.shedaniel.autoconfig.AutoConfig;
import net.minecraft.client.util.Window;

@Mixin(Window.class)
public abstract class WindowMixin {
  private static boolean hasPostedMessage65539 = false;

  private static Logger LOGGER = LoggerFactory.getLogger("Suppress OpenGL Error 1280 (Window)");

  @Inject(at = @At(value = "HEAD"), method = "logGlError", cancellable = true)
  private static void suppressMessage(int error, long description, CallbackInfo ci) {
    ConfigOptions config = AutoConfig.getConfigHolder(ConfigOptions.class).getConfig();

    if (config.suppressAll) {
      ci.cancel();
    }

    if (error == 65539 && config.suppress65539) {
      if (hasPostedMessage65539) {
        ci.cancel();
      } else {
        LOGGER.info("This mod has been configured to suppress OpenGL error 65539.");
        LOGGER.info("You can change that at any time via cloth config.");
        LOGGER.info("This error will not be shown again for this run of Minecraft unless you change the config.");
        hasPostedMessage65539 = true;
      }
    }
  }
}
