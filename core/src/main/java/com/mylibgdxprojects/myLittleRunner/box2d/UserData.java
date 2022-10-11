package com.mylibgdxprojects.myLittleRunner.box2d;

import com.mylibgdxprojects.myLittleRunner.enums.UserDataType;

public abstract class UserData {
    protected UserDataType userDataType;
    protected float width;
    protected float height;

    public UserData() {
    }

    public UserData(float width, float height) {
        this.width = width;
        this.height = height;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public UserDataType getUserDataType() {
        return userDataType;
    }
}
