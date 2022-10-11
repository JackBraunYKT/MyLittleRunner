package com.mylibgdxprojects.myLittleRunner.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mylibgdxprojects.myLittleRunner.MyLittleRunner;
import com.mylibgdxprojects.myLittleRunner.actors.Background;
import com.mylibgdxprojects.myLittleRunner.utils.Constants;

public class MainMenuScreen implements Screen {

    private static final int BUTTON_WIDTH = 150;
    private static final int BUTTON_HEIGHT = 50;
    private static final int EXIT_BUTTON_Y = 150;
    private static final int PLAY_BUTTON_Y = 230;

    Stage stage;
    MyLittleRunner myLittleRunner;
    Background background;
    TextButton exitButton;
    TextButton playButton;
    Label nameOfGame;
    Label highScoreLabel;
    private int highScore;

    public MainMenuScreen(MyLittleRunner myLittleRunner) {
        this.myLittleRunner = myLittleRunner;

        stage = new Stage();
        background = new Background();

        exitButton = new TextButton("EXIT", Constants.SKIN, "default");
        exitButton.setWidth(BUTTON_WIDTH);
        exitButton.setHeight(BUTTON_HEIGHT);
        exitButton.setPosition(Gdx.graphics.getWidth()/2f - BUTTON_WIDTH/2f,
                EXIT_BUTTON_Y - BUTTON_HEIGHT/2f);
        exitButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.exit();
            }
        });

        playButton = new TextButton("PLAY", Constants.SKIN, "default");
        playButton.setWidth(BUTTON_WIDTH);
        playButton.setHeight(BUTTON_HEIGHT);
        playButton.setPosition(Gdx.graphics.getWidth()/2f - BUTTON_WIDTH/2f,
                PLAY_BUTTON_Y - BUTTON_HEIGHT/2f);
        playButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                dispose();
                myLittleRunner.setScreen(new GameScreen(myLittleRunner));
            }
        });

        nameOfGame = new Label("My Little Runner", Constants.SKIN);
        Group group = new Group();
        group.addActor(nameOfGame);
        group.setScale(2f, 2f);
        group.setPosition(Constants.APP_WIDTH /2f - nameOfGame.getWidth(), 300);

        highScore = Constants.PREFERENCES.getInteger("highScore",0);
        highScoreLabel = new Label(new StringBuilder("Highscore: ").append(highScore), Constants.SKIN);
        highScoreLabel.setPosition(Gdx.graphics.getWidth()/2f - highScoreLabel.getWidth()/2f, 300 - 50/2f);

        stage.addActor(new Background());
        stage.addActor(group);
        stage.addActor(playButton);
        stage.addActor(exitButton);
        stage.addActor(highScoreLabel);

        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        myLittleRunner.batch.begin();
        this.stage.draw();
        myLittleRunner.batch.end();
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
