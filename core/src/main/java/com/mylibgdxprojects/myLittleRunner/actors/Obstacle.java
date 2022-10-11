package com.mylibgdxprojects.myLittleRunner.actors;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.Body;
import com.mylibgdxprojects.myLittleRunner.box2d.ObstacleUserData;
import com.mylibgdxprojects.myLittleRunner.utils.Constants;

public class Obstacle extends GameActor {

    private TextureRegion obstacleTexture;

    public Obstacle(Body body) {
        super(body);
        TextureAtlas textureAtlas = new TextureAtlas(Constants.OBSTACLES_ATLAS_PATH);
        String path = getUserData().getTextureRegion();
        obstacleTexture = textureAtlas.findRegion(path);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);

        batch.draw(obstacleTexture, screenRectangle.x, screenRectangle.y, screenRectangle.width, screenRectangle.height);
    }

    @Override
    public ObstacleUserData getUserData() {
        return (ObstacleUserData) userData;
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        body.setLinearVelocity(getUserData().getLinearVelocity());
    }
}
