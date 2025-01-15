package com.strange_armory;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class strange_armory implements ModInitializer {

    //modidを「strange_armory」にする
    public static final String MOD_ID = "strange_armory";

    //logger(ログファイルの書き込みにいるらしい)をmodidにする
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {


        //アイテムのjavaクラスの初期化
        LOGGER.info("Strange_armory initializing");
        ModItems.registermoditems();
        ModBlock.registermodblocks();
    }
}
