package io.github.adamraichu.suppressopengl1280;

import io.github.adamraichu.suppressopengl1280.config.ConfigOptions;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;

@Environment(EnvType.CLIENT)
public class ModInitClass implements ClientModInitializer {
  @Override
  public void onInitializeClient() {
    AutoConfig.register(ConfigOptions.class, GsonConfigSerializer::new);

    ClientCommandRegistrationCallback.EVENT
        .register((dispatcher, registryAccess) -> dispatcher
            .register(ClientCommandManager.literal("suppressopengl1280:test_all")
                .executes(context -> {
                  MinecraftClient client = MinecraftClient.getInstance();

                  context.getSource().sendFeedback(Text.literal("Triggering OpenGL errors in the log."));

                  client.getWindow().logGlError(65539, 0);

                  return 1;
                })));
  }
}