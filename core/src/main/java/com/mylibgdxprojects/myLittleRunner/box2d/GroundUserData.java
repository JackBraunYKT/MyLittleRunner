package com.mylibgdxprojects.myLittleRunner.box2d;

import com.mylibgdxprojects.myLittleRunner.enums.UserDataType;

public class GroundUserData extends UserData {
    public GroundUserData(float width, float height) {
        super(width, height);
        userDataType = UserDataType.GROUND;
    }
}
