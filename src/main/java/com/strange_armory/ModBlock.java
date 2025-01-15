package com.strange_armory;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModBlock {
    public static Block register(String name, Function<Block.Settings, Block> factory, Block.Settings settings){
        final RegistryKey<Block> registryKey = RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(strange_armory.MOD_ID,name));
        return Blocks.register(registryKey,factory, settings);
    }
    public static void  registermodblocks(){}
}
