package it.atomicfrog.amado.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

import it.atomicfrog.amado.Main;
import it.atomicfrog.amado.objects.Background;
import it.atomicfrog.amado.utils.MyColors;

public class MainScreen implements Screen {
    Main main;

    Texture title;
    Texture help;

    Sprite play;

    public MainScreen(Main main){
        this.main = main;

        MyColors.init();

        title = new Texture(MyColors.title);
        play = new Sprite(new Texture("button.png"));
        help = new Texture("button1.png");


    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Background.render(main.renderer);
        main.abatch.begin();
        main.abatch.draw(title,-title.getWidth()/2f, 450f);
        main.abatch.draw(play,-play.getWidth()/2f,-play.getHeight());
        main.abatch.draw(help,-help.getWidth()/2f, -400f);
        main.abatch.end();


        if(Gdx.input.justTouched())
            main.setScreen(new GameScreen(main));
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
