package net.benmoore.projectmod;

import com.mojang.logging.LogUtils;
import net.benmoore.projectmod.block.ModBlocks;
import net.benmoore.projectmod.entity.client.CrypticRenderer;
import net.benmoore.projectmod.item.ModItems;
import net.benmoore.projectmod.entity.ModEntities;
import net.benmoore.projectmod.item.ModCreativeModeTabs;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(ProjectMod.MOD_ID)
public class ProjectMod
{
    public static final String MOD_ID = "projectmod";
    private static final Logger LOGGER = LogUtils.getLogger();


    public ProjectMod()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        modEventBus.addListener(this::commonSetup);
        ModEntities.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }

    private void addCreative(CreativeModeTabEvent.BuildContents event){
        if(event.getTab() == CreativeModeTabs.INGREDIENTS){
            event.accept(ModItems.IRIDESCENT_OBSIDIAN);
            event.accept(ModItems.RAW_IRIDESCENT_OBSIDIAN);
            event.accept(ModItems.IRIDESCENT_OBSIDIAN_SWORD);
        }
        if(event.getTab() == CreativeModeTabs.BUILDING_BLOCKS){
            event.accept(ModBlocks.IRIDESCENT_OBSIDIAN_BLOCK);
        }
        if(event.getTab() == CreativeModeTabs.NATURAL_BLOCKS){
            event.accept(ModBlocks.IRIDESCENT_OBSIDIAN_ORE);
            event.accept(ModBlocks.DEEPSLATE_IRIDESCENT_OBSIDIAN_ORE);
            event.accept(ModBlocks.NETHERRACK_IRIDESCENT_OBSIDIAN_ORE);
            event.accept(ModBlocks.ENDSTONE_IRIDESCENT_OBSIDIAN_ORE);
        }

        if(event.getTab() == ModCreativeModeTabs.PROJECT_TAB){
            event.accept(ModItems.IRIDESCENT_OBSIDIAN);
            event.accept(ModItems.RAW_IRIDESCENT_OBSIDIAN);
            event.accept(ModBlocks.IRIDESCENT_OBSIDIAN_BLOCK);
            event.accept(ModBlocks.IRIDESCENT_OBSIDIAN_ORE);
            event.accept(ModBlocks.DEEPSLATE_IRIDESCENT_OBSIDIAN_ORE);
            event.accept(ModBlocks.NETHERRACK_IRIDESCENT_OBSIDIAN_ORE);
            event.accept(ModBlocks.ENDSTONE_IRIDESCENT_OBSIDIAN_ORE);
            event.accept(ModItems.IRIDESCENT_OBSIDIAN_SWORD);
            event.accept(ModItems.CRYPTIC_SPAWN_EGG);
        }
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            EntityRenderers.register(ModEntities.CRYPTIC.get(), CrypticRenderer::new);
        }
    }
}
