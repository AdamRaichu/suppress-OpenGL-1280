package io.github.adamraichu.suppressopengl1280.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;

@Config(name = "suppressopengl1280")
public class ConfigOptions implements ConfigData {
  public boolean suppress1280 = true;
  public boolean suppress1281 = true;
  public boolean suppress1282 = true;
}