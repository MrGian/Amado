package it.atomicfrog.amado;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import it.atomicfrog.amado.screens.GameScreen;
import it.atomicfrog.amado.screens.MainScreen;

public class Main extends Game {
	public SpriteBatch batch;
	public SpriteBatch abatch;
	public OrthographicCamera camera;
	public OrthographicCamera acamera;

    public ShapeRenderer renderer;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		abatch = new SpriteBatch();
		camera = new OrthographicCamera(9,16);
		acamera = new OrthographicCamera(1080,1920);
		renderer = new ShapeRenderer();
		this.setScreen(new MainScreen(this));
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(246/255f, 237/255f, 221/255f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.setProjectionMatrix(camera.combined);
		abatch.setProjectionMatrix(acamera.combined);
		renderer.setProjectionMatrix(camera.combined);

		super.render();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
