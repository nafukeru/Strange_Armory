package com.strange_armory;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModItems {

    public static final Item IMAGINARY_INGOT = register("imaginary_ingot", Item::new, new Item.Settings());
    public static final Item RAW_IMAGINARY = register("raw_imaginary", Item::new, new Item.Settings());

    public static Item register(String name, Function<Item.Settings, Item> factory, Item.Settings settings){
        final RegistryKey<Item> registryKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(strange_armory.MOD_ID,name));
        return Items.register(registryKey,factory, settings);
    }

    private static void customIngredients(FabricItemGroupEntries entries) {
        entries.add(IMAGINARY_INGOT);
        entries.add(RAW_IMAGINARY);
    }

    public static final RegistryKey<ItemGroup> CUSTOM_ITEM_GROUP_KEY = RegistryKey.of(
            Registries.ITEM_GROUP.getKey(),Identifier.of(strange_armory.MOD_ID,"item_group"));

    public static final ItemGroup CUSTOM_ITEM_GROUP = FabricItemGroup.builder()
            .icon(()-> new ItemStack(ModItems.IMAGINARY_INGOT))
            .displayName(Text.translatable("item_group.strange_armory"))
            .build();

    public static void registermoditems(){
        Registry.register(Registries.ITEM_GROUP, CUSTOM_ITEM_GROUP_KEY, CUSTOM_ITEM_GROUP);

        ItemGroupEvents.modifyEntriesEvent(CUSTOM_ITEM_GROUP_KEY).register(ModItems::customIngredients);
    }
}