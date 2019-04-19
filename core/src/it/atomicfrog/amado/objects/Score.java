package it.atomicfrog.amado.objects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;

import it.atomicfrog.amado.screens.GameScreen;
import it.atomicfrog.amado.utils.FontGenerator;

public class Score {
    int score = 0;

    BitmapFont font;
    GlyphLayout layout;

    GameScreen game;

    public Score(GameScreen game){
        this.game = game;

        font = FontGenerator.generate(120);
        layout = new GlyphLayout();
    }

    public boolean check(){
        for(int y=0;y<game.scheme.size;y++){
            for(int x=0;x<game.scheme.size;x++) {
                if(game.scheme.squares[x][y].color != game.oscheme.squares[x][y].color)
                    return false;
            }
        }

        return true;
    }

    public void addScore(){
        score++;

        if(score == 5)
            game.scheme.size = game.oscheme.size = 4;

        if(score == 10)
            game.scheme.size = game.oscheme.size = 5;

        if(score == 15){
            game.time.tick = 3;
        }

        reset();
    }

    public void loose(){
        score = 0;

        game.scheme.size = game.oscheme.size = 3;
        game.cursor.curX = game.cursor.curY = 0;
        game.time.playing = false;


        reset();
    }

    public void render(Batch abatch){
        layout.setText(font,String.valueOf(score));

        abatch.begin();
        font.draw(abatch,String.valueOf(score),-layout.width/2f,850f);
        abatch.end();
    }

    private void reset(){
        game.scheme.init();
        game.oscheme.init();
        game.time.updatePosition();
    }
}
