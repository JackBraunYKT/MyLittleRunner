package com.mylibgdxprojects.myLittleRunner.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.mylibgdxprojects.myLittleRunner.MyLittleRunner;
import com.mylibgdxprojects.myLittleRunner.screens.GameScreen;
import com.mylibgdxprojects.myLittleRunner.utils.Constants;

public class GameOverDialogBox extends Dialog {
    private final static String TITLE = "GAME OVER";

    private GameScreen gameScreen;
    private MyLittleRunner myLittleRunner;
    private String scoreInfo;
    private boolean scoreUpdated;

    public GameOverDialogBox(GameScreen gameScreen, MyLittleRunner myLittleRunner) {
        super(TITLE, Constants.SKIN);

        this.gameScreen = gameScreen;
        this.myLittleRunner = myLittleRunner;

        scoreUpdated = false;

        setWidth(300);
        setHeight(150);
        setPosition(Constants.APP_WIDTH/2f - getWidth()/2,
                    Constants.APP_HEIGHT/2f - getHeight()/2);

        button("RESTART", "restartButton");
        button("EXIT", "exitButton");
    }

    @Override
    protected void result(Object object) {
        if(object.equals("restartButton")) {
            gameScreen.dispose();
            myLittleRunner.setScreen(new GameScreen(myLittleRunner));
        } else {
            Gdx.app.exit();
        }
    }

    public void updateScore(String scoreText, int highScore) {
        scoreInfo = scoreText + "\n" + "Highscore: " + highScore;
        scoreUpdated = true;
        text(scoreInfo);
    }

    public boolean isScoreUpdated() {
        return scoreUpdated;
    }
}
