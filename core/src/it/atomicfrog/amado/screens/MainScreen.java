package it.atomicfrog.amado.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import it.atomicfrog.amado.Main;
import it.atomicfrog.amado.objects.Cursor;
import it.atomicfrog.amado.objects.Scheme;
import it.atomicfrog.amado.objects.Square;

public class MainScreen implements Screen {
    Main main;

    Scheme scheme;
    Cursor cursor;

    public MainScreen(Main main){
        this.main = main;

        scheme = new Scheme();
        cursor = new Cursor(scheme);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        scheme.render(main.renderer);
        cursor.render(main.renderer);

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
