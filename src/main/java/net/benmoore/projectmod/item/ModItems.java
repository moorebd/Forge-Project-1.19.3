package net.benmoore.projectmod.item;

import net.benmoore.projectmod.ProjectMod;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ProjectMod.MOD_ID);

    public static final RegistryObject<Item> BLACK_OPAL = ITEMS.register("black_opal",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_BLACK_OPAL = ITEMS.register("raw_black_opal",
            () -> new Item(new Item.Properties()));

   public static final RegistryObject<SwordItem> OPAL_SWORD = ITEMS.register("opal_sword",
            () -> new SwordItem(Tiers.EXAMPLE, 5, 3.5f, new Item.Properties()));



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
                () -> Ingredient.of(ModItems.BLACK_OPAL.get()));
    }
}
