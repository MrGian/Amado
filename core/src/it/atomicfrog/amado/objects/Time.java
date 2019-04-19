package it.atomicfrog.amado.objects;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

import java.util.Timer;
import java.util.TimerTask;

import it.atomicfrog.amado.utils.FontGenerator;
import it.atomicfrog.amado.utils.MyColors;
import it.atomicfrog.amado.utils.Projector;

public class Time {

    final int tottime = 3;

    public int time = tottime;
    public int tick = 5;

    public boolean playing = false;

    Vector2 position;
    float width = 1.5f;
    float height = 0.1f;
    float spacing = 0.05f;

    BitmapFont font;
    GlyphLayout layout;

    Score score;

    public Time(Scheme oscheme, Score score){
        this.score = score;

        position = new Vector2(-2.25f - oscheme.pixelSize/4f - width/2f,-7.15f);

        font = FontGenerator.generate(50);
        layout = new GlyphLayout();

    }

    public void render(ShapeRenderer renderer, SpriteBatch abacth, OrthographicCamera camera, OrthographicCamera acamera){
        renderer.begin(ShapeRenderer.ShapeType.Filled);
        renderer.setColor(MyColors.colors[0]);

        for(int i = 0; i < time; i++){
            renderer.rect(position.x,position.y + (height + spacing)*i,width,height);
        }
        renderer.end();

        layout.setText(font,"TIME");

        Vector2 txtpos = Projector.project(position.x + width/2,-4.3f,camera,acamera);

        abacth.begin();
        font.draw(abacth,"TIME",txtpos.x - layout.width/2f,txtpos.y);
        abacth.end();
    }

    public void reset(){
        time = tottime;
    }
}
