package it.atomicfrog.amado.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import java.util.Timer;
import java.util.TimerTask;

import it.atomicfrog.amado.Main;
import it.atomicfrog.amado.objects.Background;
import it.atomicfrog.amado.objects.Cursor;
import it.atomicfrog.amado.objects.Line;
import it.atomicfrog.amado.objects.Scheme;
import it.atomicfrog.amado.objects.Score;
import it.atomicfrog.amado.objects.Square;
import it.atomicfrog.amado.objects.Time;
import it.atomicfrog.amado.utils.MyColors;

public class GameScreen implements Screen {
    Main main;

    Scheme scheme;
    Scheme oscheme;

    Cursor cursor;
    Score score;
    Time time;

    Timer timer;

    public GameScreen(Main main){
        this.main = main;

        scheme = new Scheme(new Vector2(0,2f),1.1f,0.2f);
        oscheme = new Scheme(new Vector2(0,-6f),0.5f,0.09f);

        score = new Score(scheme,oscheme);
        time = new Time(oscheme, score);
        cursor = new Cursor(score, scheme,time);

        timer = new Timer();
        timer.scheduleAtFixedRate(ticktimer, time.tick*1000, time.tick*1000);
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
        time.render(main.renderer,main.abatch,main.camera,main.acamera);
        score.render(main.abatch);


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

    TimerTask ticktimer = new TimerTask() {
        @Override
        public void run() {
            if(time.playing){
                time.time--;

                if(time.time == 0){
                    score.loose();
                    time.reset();
                    cursor.setCurrent();
                }
            }
        }
    };
}
