package net.benmoore.projectmod.item;

import net.benmoore.projectmod.ProjectMod;
import net.benmoore.projectmod.entity.ModEntities;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ProjectMod.MOD_ID);

    public static final RegistryObject<Item> IRIDESCENT_OBSIDIAN = ITEMS.register("iridescent_obsidian",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_IRIDESCENT_OBSIDIAN = ITEMS.register("raw_iridescent_obsidian",
            () -> new Item(new Item.Properties()));

   public static final RegistryObject<SwordItem> IRIDESCENT_OBSIDIAN_SWORD = ITEMS.register("iridescent_obsidian_sword",
            () -> new SwordItem(Tiers.EXAMPLE, 5, 3.5f, new Item.Properties()));

    public static final RegistryObject<Item> CRYPTIC_SPAWN_EGG = ITEMS.register("cryptic_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.CRYPTIC, 0xD57E36, 0x1D0D00,
                    new Item.Properties()));

    public static void register(IEventBus eventBus){
       ITEMS.register(eventBus);
    }

    public static class Tiers{
        public static final Tier EXAMPLE = new ForgeTier(
                2,
                800,
                1.5f,
                3,
                350,
                null,
                () -> Ingredient.of(ModItems.IRIDESCENT_OBSIDIAN.get()));
    }
}
