package net.brodino.dimensionaldamage;

import net.brodino.dimensionaldamage.Config;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Dimensionaldamage implements ModInitializer {
    public static final String MOD_ID = "dimensionaldamage";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    public static final Config CONFIG = Config.createAndLoad();

    @Override
    public void onInitialize() {
        LOGGER.info("Initializing DimensionalDamage - Players will not take damage in the overworld");
    }
}
