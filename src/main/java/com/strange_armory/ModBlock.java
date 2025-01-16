package com.strange_armory;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;


public class ModBlock {

    //ブロックの追加1
    public static final RegistryKey<Block> IMAGINARY_BLOCK_KEY = RegistryKey.of(
            RegistryKeys.BLOCK,
            Identifier.of(strange_armory.MOD_ID,"imaginary_block")
    );

    //ブロックの追加2
    public static final Block IMAGINARY_BLOCK = registerblock(
            new Block(AbstractBlock.Settings.create().registryKey(IMAGINARY_BLOCK_KEY).strength(3.5F,25).sounds(BlockSoundGroup.METAL).requiresTool()),
            IMAGINARY_BLOCK_KEY,
            true
    );

    //ブロックの追加1
    public static final RegistryKey<Block> IMAGINARY_ORB_TABLE_KET = RegistryKey.of(
            RegistryKeys.BLOCK,
            Identifier.of(strange_armory.MOD_ID,"imaginary_orb_table")
    );

    //ブロックの追加2
    public static final Block IMAGINARY_ORB_TABLE = registerblock(
            new imaginary_orb_table(AbstractBlock.Settings.create().registryKey(IMAGINARY_ORB_TABLE_KET).strength(3.5F,25).sounds(BlockSoundGroup.METAL).requiresTool()),
            IMAGINARY_ORB_TABLE_KET,
            true
    );

    //ブロックの登録の引数
    public static Block registerblock(Block block, RegistryKey<Block> blockkey,boolean shouldregisteritem) {

        if(shouldregisteritem) {

            RegistryKey<Item> itemkey = RegistryKey.of(RegistryKeys.ITEM, blockkey.getValue());

            BlockItem blockItem = new BlockItem(block,new Item.Settings().registryKey(itemkey));

            Registry.register(Registries.ITEM, itemkey, blockItem);

        }

        return Registry.register(Registries.BLOCK,blockkey,block);

        }

    //クリエイティブタグにブロックアイテムの追加
    public static void customIngredients(FabricItemGroupEntries entries) {

        entries.add(IMAGINARY_BLOCK);
        entries.add(IMAGINARY_ORB_TABLE);

    }

    //クラスの初期化
    public static void registermodblocks() {
    }
}


