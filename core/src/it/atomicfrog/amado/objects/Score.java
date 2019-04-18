package it.atomicfrog.amado.objects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;

import it.atomicfrog.amado.utils.FontGenerator;

public class Score {
    int score = 0;
    Scheme scheme;
    Scheme oscheme;

    BitmapFont font;
    BitmapFont fontt;

    GlyphLayout layout;

    public Score(Scheme scheme, Scheme oscheme){
        this.scheme = scheme;
        this.oscheme = oscheme;
        font = new FontGenerator().generate();
        fontt = new BitmapFont();
        layout = new GlyphLayout();
    }

    public boolean check(){
        for(int y=0;y<scheme.size;y++){
            for(int x=0;x<scheme.size;x++) {
                if(scheme.squares[x][y].color != oscheme.squares[x][y].color)
                    return false;
            }
        }

        return true;
    }

    public void addScore(){
        score++;

        scheme.init();
        oscheme.init();
    }

    public void render(Batch abatch){
        layout.setText(font,String.valueOf(score));

        abatch.begin();
        font.setColor(Color.BLACK);
        font.draw(abatch,String.valueOf(score),-layout.width/2f,850f);
        fontt.draw(abatch,"Build170419_1 by Gianmatteo Palmieri",0,-900f);
        abatch.end();
    }
}
