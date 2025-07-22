package net.alfalut.clawsandfeathers.entity;

import net.alfalut.clawsandfeathers.ClawsAndFeathers;
import net.alfalut.clawsandfeathers.entity.custom.OstromiaEntity;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.EventBus;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;
public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, ClawsAndFeathers.MOD_ID);

    public static final Supplier<EntityType<OstromiaEntity>> OSTROMIA =
            ENTITY_TYPES.register("ostromia", () -> EntityType.Builder.of(OstromiaEntity::new, MobCategory.CREATURE)
                    .sized(0.75f, 0.35f).build("gecko"));




    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(EventBus);
    }
}
