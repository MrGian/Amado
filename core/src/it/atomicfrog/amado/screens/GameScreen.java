package it.atomicfrog.amado.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import it.atomicfrog.amado.Main;
import it.atomicfrog.amado.objects.Background;
import it.atomicfrog.amado.objects.Cursor;
import it.atomicfrog.amado.objects.Line;
import it.atomicfrog.amado.objects.Scheme;
import it.atomicfrog.amado.objects.Square;

public class GameScreen implements Screen {
    Main main;

    Scheme scheme;
    Scheme oscheme;

    Cursor cursor;

    public GameScreen(Main main){
        this.main = main;

        scheme = new Scheme(new Vector2(0,2f),1.1f,0.2f);
        oscheme = new Scheme(new Vector2(0,-6f),0.5f,0.09f);

        cursor = new Cursor(scheme);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Background.render(main.renderer);
        Line.render(main.renderer);
        scheme.render(main.renderer);
        oscheme.render(main.renderer);
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
