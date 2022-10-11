package com.mylibgdxprojects.myLittleRunner.box2d;

import com.badlogic.gdx.math.Vector2;
import com.mylibgdxprojects.myLittleRunner.enums.UserDataType;
import com.mylibgdxprojects.myLittleRunner.utils.Constants;

public class ObstacleUserData extends UserData {
    private static Vector2 obstacleLinearVelocity = new Vector2(-10f, 0);

    private String textureRegion;

    public ObstacleUserData(float width, float height, String textureRegion) {
        super(width, height);
        userDataType = UserDataType.OBSTACLE;
        this.textureRegion = textureRegion;
    }

    public Vector2 getLinearVelocity() {
        obstacleLinearVelocity.x -= 0.001f;
        return obstacleLinearVelocity;
    }

    public String getTextureRegion() {
        return textureRegion;
    }
}
