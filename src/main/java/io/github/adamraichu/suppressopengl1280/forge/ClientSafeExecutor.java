package io.github.adamraichu.suppressopengl1280.forge;

import io.github.adamraichu.suppressopengl1280.forge.config.ConfigOptions;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.minecraftforge.client.ConfigGuiHandler.ConfigGuiFactory;
import net.minecraftforge.fml.ModLoadingContext;

public class ClientSafeExecutor {
  public static void run() {
    AutoConfig.register(ConfigOptions.class, GsonConfigSerializer::new);

    ModLoadingContext.get().registerExtensionPoint(ConfigGuiFactory.class, () -> new ConfigGuiFactory((mc, screen) -> {
      return AutoConfig.getConfigScreen(ConfigOptions.class, screen).get();
    }));
  }
}
