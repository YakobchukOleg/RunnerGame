package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import java.util.Vector;

/**
 * Created by Divinorium on 11.02.2018.
 */
public class Player {
    private GameScreen gameScreen;

    private Texture texture;
    private Vector2 position;
    private Vector2 velocity;

    private float score;

    private float time;

    private final int WIGHT = 100;
    private final int HEIGHT = 100;

    public Vector2 getPosition() {
        return position;
    }

    public Player(GameScreen gameScreen){
        this.gameScreen = gameScreen;
        this.texture = new Texture("runner.png");
        this.position = new Vector2(0, 190);
        this.velocity = new Vector2(240.0f, 0.0f);
        this.score = 0;

    }

    public void render(SpriteBatch batch){
        int frame = (int) (time / 0.1f);
        frame = frame % 6;
        batch.draw(texture, gameScreen.getPlayerAnchor(), position.y, frame * 100, 0, WIGHT, HEIGHT);
    }

    public void update(float dt){
        time += velocity.x * dt / 300.0f;

        position.mulAdd(velocity, dt);
    }
}
