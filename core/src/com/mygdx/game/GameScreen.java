package com.mygdx.game;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.time.temporal.Temporal;

/**
 * Created by Divinorium on 11.02.2018.
 */
public class GameScreen implements Screen {
    private RunnerGame runnerGame;
    private SpriteBatch batch;
    private Texture texture;


    public GameScreen(RunnerGame runnerGame, SpriteBatch batch){
        this.runnerGame = runnerGame;
        this.batch = batch;
    }

    @Override
    public void show() {
        this.texture = new Texture("badlogic.jpg");
    }

    @Override
    public void render(float delta) {
        batch.begin();
        batch.draw(texture, 0, 0);
        batch.end();
    }

    @Override
    public void resize(int width, int height) {
        runnerGame.getViewport().update(width, height, true);
        runnerGame.getViewport().apply();
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
