package io.github.adamraichu.suppressopengl1280.forge;

import io.github.adamraichu.suppressopengl1280.forge.config.ConfigOptions;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.ConfigGuiHandler.ConfigGuiFactory;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.IExtensionPoint;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.network.NetworkConstants;

@Mod("suppressopengl1280")
public class ModInitClass {
  public ModInitClass() {
    ModLoadingContext.get().registerExtensionPoint(IExtensionPoint.DisplayTest.class,
        () -> new IExtensionPoint.DisplayTest(() -> NetworkConstants.IGNORESERVERONLY, (a, b) -> true));
    DistExecutor.safeRunWhenOn(Dist.CLIENT, () -> ModInitClass::clientSetup);
  }

  public static void clientSetup() {
    AutoConfig.register(ConfigOptions.class, GsonConfigSerializer::new);

    ModLoadingContext.get().registerExtensionPoint(ConfigGuiFactory.class, () -> new ConfigGuiFactory((mc, screen) -> {
      return AutoConfig.getConfigScreen(ConfigOptions.class, screen).get();
    }));
  }
}
