package net.brodino.dimensionaldamage;

import io.wispforest.owo.config.annotation.Config;

import java.util.ArrayList;

@Config(name = "dimensionaldamage", wrapperName = "Config")
public class ConfigHelper {

    public ArrayList<String> dimensions;

    public ConfigHelper() {
        this.dimensions = new ArrayList<>();
        this.dimensions.add("minecraft:the_end");
        this.dimensions.add("minecraft:the_nether");
    }
}