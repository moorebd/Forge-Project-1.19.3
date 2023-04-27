package net.benmoore.projectmod.item;

import net.benmoore.projectmod.ProjectMod;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ProjectMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCreativeModeTabs {
    public static CreativeModeTab PROJECT_TAB;

    @SubscribeEvent
    public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event) {
        PROJECT_TAB = event.registerCreativeModeTab(new ResourceLocation(ProjectMod.MOD_ID, "project_tab"),
                builder -> builder.icon(() -> new ItemStack(ModItems.IRIDESCENT_OBSIDIAN.get()))
                        .title(Component.translatable("creativemodetab.project_tab")));
    }
}