package net.ok.forgotten_relics;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import net.ok.forgotten_relics.entity.BowBlastModel;
import net.ok.forgotten_relics.entity.BowBlastRenderer;
import net.ok.forgotten_relics.entity.ModEntities;

@Mod(value = ForgottenRelics.MODID, dist = Dist.CLIENT)
//You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
@EventBusSubscriber(modid = ForgottenRelics.MODID, value = Dist.CLIENT)
public class ForgottenRelicsClient {
 public ForgottenRelicsClient(ModContainer container) {
     // Allows NeoForge to create a config screen for this mod's configs.
     // The config screen is accessed by going to the Mods screen > clicking on your mod > clicking on config.
     // Do not forget to add translations for your config options to the en_us.json file.
     container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
 }

 
 @SubscribeEvent
 static void onClientSetup(FMLClientSetupEvent event) {
	
 }
 
 
 @SubscribeEvent
 public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
     event.registerLayerDefinition(
             BowBlastModel.LAYER_LOCATION,
             BowBlastModel::createBodyLayer
     );
 }

 @SubscribeEvent
 public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
     event.registerEntityRenderer(
             ModEntities.BOW_BLAST.get(),
             BowBlastRenderer::new
     );
 }
}
