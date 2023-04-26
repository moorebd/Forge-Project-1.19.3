package net.benmoore.projectmod.entity;

import net.benmoore.projectmod.ProjectMod;
import net.benmoore.projectmod.entity.custom.CrypticEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, ProjectMod.MOD_ID);

    public static final RegistryObject<EntityType<CrypticEntity>> CRYPTIC =
            ENTITY_TYPES.register("cryptic",
                    () -> EntityType.Builder.of(CrypticEntity::new, MobCategory.CREATURE)
                            .sized(1.5f, 1.75f)
                            .build(new ResourceLocation(ProjectMod.MOD_ID, "cryptic").toString()));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
