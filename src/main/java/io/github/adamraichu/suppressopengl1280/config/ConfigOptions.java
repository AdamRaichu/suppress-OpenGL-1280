package io.github.adamraichu.suppressopengl1280.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@Config(name = "suppressopengl1280")
public class ConfigOptions implements ConfigData {
  boolean suppress1280 = true;
  boolean suppress1281 = true;
  boolean suppress1282 = true;
}