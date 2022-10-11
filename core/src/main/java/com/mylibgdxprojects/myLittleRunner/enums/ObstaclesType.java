package com.mylibgdxprojects.myLittleRunner.enums;

import com.mylibgdxprojects.myLittleRunner.utils.Constants;

public enum ObstaclesType {

    OBSTACLES_SMALL(1f, 1f, Constants.OBSTACLE_X, Constants.OBSTACLE_SHORT_Y,
            Constants.OBSTACLE_DENSITY, Constants.OBSTACLES_SMALL_REGION_NAME),
    OBSTACLES_WIDE(2f, 1f, Constants.OBSTACLE_X, Constants.OBSTACLE_SHORT_Y,
            Constants.OBSTACLE_DENSITY, Constants.OBSTACLES_WIDE_REGION_NAME),
    OBSTACLES_LONG(1f, 2f, Constants.OBSTACLE_X, Constants.OBSTACLE_LONG_Y,
            Constants.OBSTACLE_DENSITY, Constants.OBSTACLES_LONG_REGION_NAME),
    OBSTACLES_BIG(2f, 2f, Constants.OBSTACLE_X, Constants.OBSTACLE_LONG_Y,
            Constants.OBSTACLE_DENSITY, Constants.OBSTACLES_BIG_REGION_NAME);

    private float width;
    private float height;
    private float x;
    private float y;
    private float density;
    private String region;

    ObstaclesType(float width, float height, float x, float y, float density, String region) {
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        this.density = density;
        this.region = region;
    }

    public String getRegion() {
        return region;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getDensity() {
        return density;
    }
}
