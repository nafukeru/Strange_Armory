package com.strange_armory;

import com.strange_armory.item.ModItems;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Strange_armory implements ModInitializer {

    //modidを「strange_armory」にする
    public static final String MOD_ID = "strange_armory";

    //logger(ログファイルの書き込みにいるらしい)をmodidにする
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {

        //マイクラがロードされたときに実行される
        //初期化がうんちゃらカンチャラ
        LOGGER.info("debug:\"strange armory mod\" successfully loaded");
        ModItems.registermoditems();
    }
}
