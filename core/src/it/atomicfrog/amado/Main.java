package it.atomicfrog.amado;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import it.atomicfrog.amado.screens.MainScreen;

public class Main extends Game {
	public SpriteBatch batch;
	public ShapeRenderer renderer;
	public OrthographicCamera camera;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		camera = new OrthographicCamera(9,16);
		renderer = new ShapeRenderer();
		this.setScreen(new MainScreen(this));
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.setProjectionMatrix(camera.combined);
		renderer.setProjectionMatrix(camera.combined);

		super.render();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
