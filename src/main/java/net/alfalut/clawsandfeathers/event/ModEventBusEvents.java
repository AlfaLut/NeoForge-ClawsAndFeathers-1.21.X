package net.alfalut.clawsandfeathers.event;

import net.alfalut.clawsandfeathers.ClawsAndFeathers;
import net.alfalut.clawsandfeathers.entity.ModEntities;
import net.alfalut.clawsandfeathers.entity.client.OstromiaModel;
import net.alfalut.clawsandfeathers.entity.custom.OstromiaEntity;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;

@EventBusSubscriber(modid = ClawsAndFeathers.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
@SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
     event.registerLayerDefinition(OstromiaModel.LAYER_LOCATION, OstromiaModel::createBodyLayer);
    }
@SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
event.put(ModEntities.OSTROMIA.get(), OstromiaEntity.createAttributes().build());
    }
}
