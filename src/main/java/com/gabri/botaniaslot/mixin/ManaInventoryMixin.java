package com.gabri.botaniaslot.mixin;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import vazkii.botania.common.impl.mana.ManaItemHandlerImpl;

import java.util.Collections;
import java.util.List;

/**
 * Mixin para a classe ManaItemHandlerImpl do Botania.
 * Responsável por restringir a busca de itens de mana apenas aos slots do Curios API.
 * 
 * @author Sato
 */
@Mixin(value = ManaItemHandlerImpl.class, remap = false)
public class ManaInventoryMixin {

    /**
     * Intercepta o método getManaItems para bloquear a busca no inventário principal.
     * Este método é o responsável por encontrar itens de mana nos 36 slots do jogador.
     * Ao retornar uma lista vazia, garantimos que o inventário principal seja ignorado.
     * 
     * @param player O jogador que está tentando usar mana.
     * @param cir O retorno do método (Lista de itens encontrados no inventário).
     */
    @Inject(method = "getManaItems", at = @At("HEAD"), cancellable = true)
    private void onGetManaItems(Player player, CallbackInfoReturnable<List<ItemStack>> cir) {
        // Bloqueamos completamente o inventário principal retornando uma lista vazia.
        // O Botania continuará chamando 'getManaAccesories', que lida com o Curios e Baubles.
        cir.setReturnValue(Collections.emptyList());
    }
}
