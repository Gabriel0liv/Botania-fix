package com.gabri.botaniaslot;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import top.theillusivec4.curios.api.SlotTypeMessage;

/**
 * Classe principal do mod Botania Slot.
 * Focada exclusivamente na restrição de mana e integração com Curios.
 * 
 * @author Sato
 */
@Mod(BotaniaSlot.MODID)
@SuppressWarnings("removal")
public class BotaniaSlot
{
    public static final String MODID = "botania_slots";
    private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger("Botania-Slots");

    public BotaniaSlot(FMLJavaModLoadingContext context)
    {
        IEventBus modEventBus = context.getModEventBus();

        // Registro do setup comum
        modEventBus.addListener(this::commonSetup);
        // Registro da mensagem IMC para o Curios (Garante o funcionamento do slot)
        modEventBus.addListener(this::enqueueIMC);

        // Registra o barramento de eventos do Minecraft para outros eventos
        MinecraftForge.EVENT_BUS.register(this);

        // Registro da configuração
        context.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        LOGGER.info("Botania-Slot: Mod carregado com sucesso!");
    }

    private void enqueueIMC(final InterModEnqueueEvent event)
    {
        // Registro do slot customizado "botania_mana" com tamanho 2 e ícone de colar
        // Usamos IMC como fallback robusto para garantir que o slot apareça
        InterModComms.sendTo("curios", SlotTypeMessage.REGISTER_TYPE, 
            () -> new SlotTypeMessage.Builder("botania_mana")
                .icon(new net.minecraft.resources.ResourceLocation("curios", "slot/empty_charm_slot"))
                .size(2)
                .build());
    }
}
