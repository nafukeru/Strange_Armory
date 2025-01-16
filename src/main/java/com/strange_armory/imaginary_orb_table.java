package com.strange_armory;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import java.util.concurrent.ThreadLocalRandom;

public class imaginary_orb_table extends Block {
    public imaginary_orb_table(Settings settings) {
        super(settings);
    }

    @Override
    protected ActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {

        if (stack.getItem() == ModItems.IMAGINARY_ORB) {
            world.playSound(player, pos, SoundEvents.BLOCK_END_PORTAL_SPAWN, SoundCategory.BLOCKS, 1f, 1f);
            stack.decrement(1);

            ItemStack weapon = getRandomWeapon();
            if (!player.giveItemStack(weapon)){
                player.dropItem(weapon,false);
            }

        }else {
            world.playSound(player,pos,SoundEvents.ENTITY_TNT_PRIMED,SoundCategory.BLOCKS,1f,1f);
        }
        return ActionResult.SUCCESS;
    }

    private ItemStack getRandomWeapon(){
        int chance = ThreadLocalRandom.current().nextInt(3);
        switch (chance) {
            case 0:
                return new ItemStack(Items.IRON_INGOT, 1);
            case 1:
                return new ItemStack(Items.GOLD_INGOT, 1);
            case 2:
                return new ItemStack(Items.NETHERITE_INGOT, 1);
            default:
                return ItemStack.EMPTY;
        }
    }
}