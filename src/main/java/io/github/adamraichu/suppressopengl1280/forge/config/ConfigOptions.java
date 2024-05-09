package io.github.adamraichu.suppressopengl1280.forge.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@Config(name = "suppressopengl1280")
public class ConfigOptions implements ConfigData {
  @ConfigEntry.Gui.Tooltip(count = 2)
  public boolean suppress1280 = true;

  @ConfigEntry.Gui.Tooltip(count = 3)
  public boolean suppress1281 = true;

  @ConfigEntry.Gui.Tooltip(count = 3)
  public boolean suppress1282 = true;

  @ConfigEntry.Gui.Tooltip(count = 2)
  public boolean suppress2 = true;
}