package com.mylibgdxprojects.myLittleRunner.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class Constants {

    public static final int APP_WIDTH = 1334;
    public static final int APP_HEIGHT = 750;
    public static final float WORLD_TO_SCREEN = 32;

    public static final Preferences PREFERENCES = Gdx.app.getPreferences("Game Preferences");
    public static final Skin SKIN = new Skin(Gdx.files.internal("skins/uiskin.json"));

    public static final Vector2 WORLD_GRAVITY = new Vector2(0, -10);

    public static final float GROUND_X = 0;
    public static final float GROUND_Y = 0;
    public static final float GROUND_WIDTH = 45f;
    public static final float GROUND_HEIGHT = 2f;
    public static final float GROUND_DENSITY = 0f;

    public static final float RUNNER_X = 2;
    public static final float RUNNER_Y = GROUND_Y + GROUND_HEIGHT;
    public static final float RUNNER_WIDTH = 1f;
    public static final float RUNNER_HEIGHT = 2f;
    public static final float RUNNER_DENSITY = 0.5f;
    public static final float RUNNER_GRAVITY_SCALE = 3f;
    public static final Vector2 RUNNER_JUMPING_LINEAR_IMPULSE = new Vector2(0, 13f);
    public static final float RUNNER_HIT_ANGULAR_IMPULSE = 10f;

    public static final float OBSTACLE_X = 45f;
    public static final float OBSTACLE_DENSITY = RUNNER_DENSITY;
    public static final float OBSTACLE_SHORT_Y = 1.5f;
    public static final float OBSTACLE_LONG_Y = 2f;
    public static final Vector2 OBSTACLE_LINEAR_VELOCITY = new Vector2(-10f, 0);

    public static final String BACKGROUND_IMAGE_PATH = "img/background.png";
    public static final String GROUND_IMAGE_PATH = "img/ground.png";

    public static final String RUNNER_ATLAS_PATH = "img/runner.atlas";
    public static final String[] RUNNER_RUNNING_REGION_NAMES = new String[] {"run-frame-1", "run-frame-2", "run-frame-3", "run-frame-4", "run-frame-5", "run-frame-6"};
    public static final String RUNNER_HIT_REGION_NAME = "frame-got-hit";
    public static final String RUNNER_JUMP_UP_REGION_NAME = "jump_up";

    public static final String OBSTACLES_ATLAS_PATH = "img/obstacles.atlas";
    public static final String OBSTACLES_SMALL_REGION_NAME = "brick_small";
    public static final String OBSTACLES_WIDE_REGION_NAME = "brick_wide";
    public static final String OBSTACLES_LONG_REGION_NAME = "brick_long";
    public static final String OBSTACLES_BIG_REGION_NAME = "brick_big";

}
