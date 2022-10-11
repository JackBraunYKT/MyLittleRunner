package com.mylibgdxprojects.myLittleRunner.utils;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class Assets {
    public static final AssetManager manager = new AssetManager();

    public static final AssetDescriptor<Texture> barrel = new AssetDescriptor<Texture>("img/barrel.png", Texture.class);
    public static final AssetDescriptor<Skin> uiSkin = new AssetDescriptor<Skin>("skins/uiskin.json", Skin.class);

    public static void dispose() {
        manager.dispose();
    }
}
