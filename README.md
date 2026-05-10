# Botania Slot

**Botania Slot** é um mod de utilidade e otimização para Minecraft 1.20.1 (Forge) focado em melhorar a performance de servidores ao lidar com o sistema de mana do Botania.

## Objetivo
O Botania original, por padrão, verifica todos os 36 slots do inventário principal do jogador sempre que uma ferramenta precisa de mana. Em servidores com muitos jogadores e máquinas complexas, essa varredura constante pode causar picos significativos de CPU (lag de TPS).

Este mod resolve o problema restringindo a busca de mana **apenas** a slots específicos do **Curios API**, bloqueando o acesso ao inventário principal.

## Funcionalidades
*   **Slot Customizado:** Adiciona o slot exclusivo "**Mana do Botania**" (tipo: `botania_mana`).
*   **Filtro Rigoroso:** Apenas itens de mana (Anéis e Tablets de Mana) podem ser colocados no novo slot.
*   **Performance:** Redução drástica no consumo de μs/t (microsegundos por tick) por jogador ao ignorar o inventário principal na busca por mana.

## Configuração
O mod adiciona slots customizados via Curios API. 
*   **Ícone:** Amuleto (Charm).
*   **Quantidade:** 2 slots por padrão.

## Créditos
*   **Desenvolvedor:** Sato/SatDPhoe
*   **Inspirado por:** Necessidades de otimização de grandes servidores de Botania.

---
**Versão:** 1.0.0
**Target:** Minecraft 1.20.1 (Forge/Curios API)
