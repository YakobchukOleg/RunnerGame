package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class RunnerGame extends Game {
	private SpriteBatch batch;
	private GameScreen gameScreen;
	private Viewport viewport;

	public Viewport getViewport() {
		return viewport;
	}

	@Override
	public void create () {
		batch = new SpriteBatch();
		gameScreen = new GameScreen(this, batch);
		viewport = new FillViewport(1280, 720);
		setScreen(gameScreen);
	}

	@Override
	public void render () {
		float dt = Gdx.graphics.getDeltaTime();
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		getScreen().render(dt);
	}

	@Override
	public void dispose () {
		batch.dispose();
		getScreen().dispose();
	}
}
