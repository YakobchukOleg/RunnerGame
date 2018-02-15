package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

import java.time.temporal.Temporal;

/**
 * Created by Divinorium on 11.02.2018.
 */
public class GameScreen implements Screen {
    private RunnerGame runnerGame;
    private SpriteBatch batch;
    private Texture textureBackground;
    private Texture textureSand;
    private Texture textureCactus;

    private float groundHeight = 190.0f;
    private float playerAnchor = 200.0f;

    private Player player;
    private Cactus[] enemies;

    public float getPlayerAnchor() {
        return playerAnchor;
    }

    public float getGroundHeight() {
        return groundHeight;
    }

    public GameScreen(RunnerGame runnerGame, SpriteBatch batch){
        this.runnerGame = runnerGame;
        this.batch = batch;
    }

    @Override
    public void show() {
        textureBackground = new Texture("bg.png");
        textureSand = new Texture("ground.png");
        player = new Player(this);
        textureCactus = new Texture("cactus.png");
        enemies = new Cactus[10];
        enemies[0] = new Cactus(textureCactus, new Vector2(1400, groundHeight));
        for (int i = 1; i < 10; ++i) {
            enemies[i] = new Cactus(textureCactus, new Vector2(enemies[i-1]. getPosition().x + MathUtils.random(400, 900), groundHeight));
        }

    }

    @Override
    public void render(float delta) {
        update(delta);
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(textureBackground, 0, 0);
        for (int i = 0; i < 8; i++) {
            batch.draw(textureSand, i * 200 - player.getPosition().x % 200, 0);
        }
        player.render(batch);
        for (int i = 0; i < enemies.length; ++i) {
            enemies[i].render(batch, player.getPosition().x - playerAnchor);
        }
        batch.end();
    }

    public float getRightestEnemy() {
        float maxValue = 0.0f;
        for (int i = 0; i < enemies.length; i++) {
            if (enemies[i].getPosition().x > maxValue) {
                maxValue =  enemies[i].getPosition().x;
            }
        }
        return maxValue;
    }

    public void update(float dt){
        player.update(dt);
        for (int i =0; i<enemies.length; i++) {
            if (enemies[i].getPosition().x < player.getPosition().x - playerAnchor - 80) {
                enemies[i].setPosition(getRightestEnemy() + MathUtils.random(400, 900), groundHeight);
            }
        }
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
        textureBackground.dispose();
        textureSand.dispose();
        textureCactus.dispose();
    }
}
