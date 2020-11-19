package svenhjol.charm.base.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemStack;
import svenhjol.charm.base.CharmModule;

public abstract class CharmEnchantment extends Enchantment implements ICharmEnchantment {
    protected CharmModule module;

    protected CharmEnchantment(CharmModule module, String name, Rarity weight, EnchantmentTarget type, EquipmentSlot[] slotTypes) {
        super(weight, type, slotTypes);
        this.register(module, name);
        this.module = module;
    }

    public boolean enabled() {
        return module.enabled;
    }

    @Override
    public boolean isAcceptableItem(ItemStack stack) {
        return module.enabled && super.isAcceptableItem(stack);
    }

    @Override
    public boolean isAvailableForEnchantedBookOffer() {
        return module.enabled && super.isAvailableForEnchantedBookOffer();
    }

    @Override
    public boolean isAvailableForRandomSelection() {
        return module.enabled && super.isAvailableForRandomSelection();
    }
}
