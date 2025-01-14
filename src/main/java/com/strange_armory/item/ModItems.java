package com.strange_armory.item;

import com.strange_armory.Strange_armory;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModItems {

    public static final Item IMAGINARY_INGOT = registeritem("imaginary_ingot", Item::new, new Item.Settings());

    public  static Item registeritem(String name, Function<Item.Settings, Item> factory, Item.Settings settings){
        final RegistryKey<Item> registryKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Strange_armory.MOD_ID,name));
        return Items.register(registryKey,factory, settings);
    }

    private static void customIngredients(FabricItemGroupEntries entries) {
        entries.add(IMAGINARY_INGOT);
    }

    public static void registermoditems(){
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::customIngredients);
    }
}
