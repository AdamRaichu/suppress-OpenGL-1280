package io.github.adamraichu.suppressopengl1280;

import io.github.adamraichu.suppressopengl1280.config.ConfigOptions;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class ModInitClass implements ClientModInitializer {
  @Override
  public void onInitializeClient() {
    AutoConfig.register(ConfigOptions.class, GsonConfigSerializer::new);
  }
}