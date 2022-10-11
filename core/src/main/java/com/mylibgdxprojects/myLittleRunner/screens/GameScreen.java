package com.mylibgdxprojects.myLittleRunner.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mylibgdxprojects.myLittleRunner.MyLittleRunner;
import com.mylibgdxprojects.myLittleRunner.stages.GameStage;
import com.mylibgdxprojects.myLittleRunner.utils.Constants;

public class GameScreen implements Screen {

    private GameStage stage;
    private MyLittleRunner myLittleRunner;

    public GameScreen(MyLittleRunner myLittleRunner) {
        this.myLittleRunner = myLittleRunner;
        stage = new GameStage(myLittleRunner, this);
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.draw();
        stage.act(delta);
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
