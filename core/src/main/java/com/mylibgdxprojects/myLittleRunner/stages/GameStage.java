package com.mylibgdxprojects.myLittleRunner.stages;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.ScalingViewport;
import com.mylibgdxprojects.myLittleRunner.MyLittleRunner;
import com.mylibgdxprojects.myLittleRunner.actors.Background;
import com.mylibgdxprojects.myLittleRunner.actors.GameOverDialogBox;
import com.mylibgdxprojects.myLittleRunner.actors.Obstacle;
import com.mylibgdxprojects.myLittleRunner.actors.Ground;
import com.mylibgdxprojects.myLittleRunner.actors.Runner;
import com.mylibgdxprojects.myLittleRunner.screens.GameScreen;
import com.mylibgdxprojects.myLittleRunner.utils.BodyUtils;
import com.mylibgdxprojects.myLittleRunner.utils.Constants;
import com.mylibgdxprojects.myLittleRunner.utils.WorldUtils;

public class GameStage extends Stage implements ContactListener {

    private static final int VIEWPORT_WIDTH = Constants.APP_WIDTH;
    private static final int VIEWPORT_HEIGHT = Constants.APP_HEIGHT;

    private World world;
    private Ground ground;
    private Runner runner;
    private GameOverDialogBox gameOverDialogBox;
    private MyLittleRunner myLittleRunner;
    private GameScreen gameScreen;

    private float TIME_STEP = 1/300f;
    private float accumulator = 0f;

    private int highScore;
    private int currentScore;
    private int halfSecond;
    private StringBuilder scoreText;
    private Label currentScoreLabel;


    private OrthographicCamera camera;

    public GameStage(MyLittleRunner myLittleRunner, GameScreen gameScreen) {

        super(new ScalingViewport(Scaling.stretch, VIEWPORT_WIDTH, VIEWPORT_HEIGHT,
                new OrthographicCamera(VIEWPORT_WIDTH, VIEWPORT_HEIGHT)));

        this.myLittleRunner = myLittleRunner;
        this.gameScreen = gameScreen;
        highScore = Constants.PREFERENCES.getInteger("highScore",0);
        currentScore = 0;
        halfSecond = 0;
        scoreText = new StringBuilder("Score: ").append(currentScore);
        currentScoreLabel = new Label(scoreText, Constants.SKIN);
        gameOverDialogBox = new GameOverDialogBox(gameScreen, myLittleRunner);
        gameOverDialogBox.setVisible(false);

        setUpWorld();
        setUpCamera();
        addActor(gameOverDialogBox);
        Gdx.input.setInputProcessor(this);
    }

    private void setUpWorld() {
        world = WorldUtils.createWorld();
        world.setContactListener(this);
        setUpBackground();
        setUpGround();
        setUpRunner();
        setUpScore();
        setUpObstacles();
    }

    private void setUpBackground() {
        addActor(new Background());
    }

    private void setUpScore() {
        currentScore = 0;
        halfSecond = 0;
        currentScoreLabel.setWidth(150);
        currentScoreLabel.setHeight(50);
        currentScoreLabel.setPosition(50,
                300 - 50/2f);
        addActor(currentScoreLabel);
    }

    private void setUpObstacles() {
        Obstacle obstacle = new Obstacle(WorldUtils.createObstacles(world));
        addActor(obstacle);
    }

    private void setUpRunner() {
        runner = new Runner(WorldUtils.createRunner(world));
        addActor(runner);
    }

    private void setUpGround() {
        ground = new Ground(WorldUtils.createGround(world));
        addActor(ground);
    }

    private void setUpCamera() {
        camera = new OrthographicCamera(VIEWPORT_WIDTH, VIEWPORT_HEIGHT);
        camera.position.set(camera.viewportWidth/2, camera.viewportHeight/2, 0f);
        camera.update();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        runner.jump();
        return super.touchDown(screenX, screenY, pointer, button);
    }

    @Override
    public void draw() {
        super.draw();
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        Array<Body> bodies = new Array<Body>(world.getBodyCount());
        world.getBodies(bodies);
        for(Body body: bodies) {
            update(body);
        }

        accumulator += delta;

        while (accumulator >= delta) {
            world.step(TIME_STEP, 6, 2);
            accumulator -= TIME_STEP;
        }
    }

    private void update(Body body) {
        if(!BodyUtils.bodyIsBounds(body)) {
            if(BodyUtils.bodyIsObstacle(body) && !runner.isHit()) {
                setUpObstacles();
            }
            world.destroyBody(body);
        }
        if(runner.isHit()) {
            if (currentScore > highScore) {
                Constants.PREFERENCES.putInteger("highScore", currentScore);
                Constants.PREFERENCES.flush();
                highScore = Constants.PREFERENCES.getInteger("highScore", 0);
            }
            gameOverDialogBox.setVisible(true);
            currentScore = 0;
            if(runner.isHit() && !gameOverDialogBox.isScoreUpdated()) {
                gameOverDialogBox.updateScore(String.valueOf(scoreText), highScore);
            }
        } else {
            halfSecond++;
            if(halfSecond == 120) {
                currentScore++;
                halfSecond = 0;
            }
            currentScoreLabel.setText(scoreText.replace(7, scoreText.length(), String.valueOf(currentScore)));
        }
    }



    @Override
    public void beginContact(Contact contact) {
        Body a = contact.getFixtureA().getBody();
        Body b = contact.getFixtureB().getBody();

        if((BodyUtils.bodyIsRunner(a) && BodyUtils.bodyIsObstacle(b)) ||
                (BodyUtils.bodyIsObstacle(a) && BodyUtils.bodyIsRunner(b))) {
            runner.hit();
        }
        else if((BodyUtils.bodyIsRunner(a) && BodyUtils.bodyIsGround(b)) ||
        (BodyUtils.bodyIsGround(a) && BodyUtils.bodyIsRunner(b))) {
            runner.landed();
        }
    }



    @Override
    public void endContact(Contact contact) {

    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {

    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {

    }
}
