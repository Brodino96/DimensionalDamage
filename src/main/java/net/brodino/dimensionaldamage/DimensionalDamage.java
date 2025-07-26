package net.brodino.dimensionaldamage;

import net.brodino.dimensionaldamage.Config;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.server.command.CommandManager;
import net.minecraft.text.Text;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DimensionalDamage implements ModInitializer {
    public static final String MOD_ID = "dimensionaldamage";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    public static final Config CONFIG = Config.createAndLoad();

    @Override
    public void onInitialize() {
        LOGGER.info("Initializing DimensionalDamage - Players will not take damage in the overworld");

        CommandRegistrationCallback.EVENT.register(((dispatcher, registryAccess, environment) -> {
            dispatcher.register(CommandManager.literal("dimensionaldamage")
                    .requires(source -> source.hasPermissionLevel(2))
                    .executes(context -> {
                        LOGGER.info("Reloading Dimensional Damage's configs!");
                        CONFIG.load();
                        context.getSource().getPlayer().sendMessage(Text.literal("Config reloaded!"), false);
                        return 1;
                    })
            );
        }));
    }
}
