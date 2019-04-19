package it.atomicfrog.amado.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import it.atomicfrog.amado.Main;
import it.atomicfrog.amado.screens.GameScreen;
import it.atomicfrog.amado.utils.MyColors;
import it.atomicfrog.amado.utils.SimpleDirectionGestureDetector;

public class Cursor {

    private Square current;
    private Square old;

    private GameScreen game;

    public int curX = 0;
    public int curY = 0;

    public Cursor(GameScreen game){
        this.game = game;

        Gdx.input.setInputProcessor(detector);

        setCurrent();

    }

    public void render(ShapeRenderer renderer){

        renderer.begin(ShapeRenderer.ShapeType.Filled);
        renderer.setColor(current.color);
        renderer.rect(current.position.x - game.scheme.spacing*2/3
                ,current.position.y - game.scheme.spacing*2/3
                ,game.scheme.squareSize + game.scheme.spacing*4/3
                ,game.scheme.spacing/3);

        renderer.rect(current.position.x - game.scheme.spacing*2/3
                ,current.position.y - game.scheme.spacing*2/3
                ,game.scheme.spacing/3
                ,game.scheme.squareSize + game.scheme.spacing*4/3);

        renderer.rect(current.position.x - game.scheme.spacing*2/3
                ,current.position.y + game.scheme.squareSize + game.scheme.spacing*1/3
                ,game.scheme.squareSize + game.scheme.spacing*4/3
                ,game.scheme.spacing/3);

        renderer.rect(current.position.x + game.scheme.squareSize + game.scheme.spacing/3
                ,current.position.y - game.scheme.spacing*2/3
                ,game.scheme.spacing/3
                ,game.scheme.squareSize + game.scheme.spacing*4/3);
        renderer.end();

    }

    SimpleDirectionGestureDetector detector = new SimpleDirectionGestureDetector(new SimpleDirectionGestureDetector.DirectionListener() {
        @Override
        public void onLeft() {
            old = game.scheme.squares[curX][curY];
            if(curX != 0)
                curX--;
            updateSquare();
        }

        @Override
        public void onRight() {
            old = game.scheme.squares[curX][curY];
            if(curX != game.scheme.size - 1)
                curX++;
            updateSquare();
        }

        @Override
        public void onUp() {
            old = game.scheme.squares[curX][curY];
            if(curY != game.scheme.size - 1)
                curY++;
            updateSquare();
        }

        @Override
        public void onDown() {
            old = game.scheme.squares[curX][curY];
            if(curY != 0)
                curY--;
            updateSquare();
        }
    });

    public void setCurrent(){
        current = game.scheme.squares[curX][curY];
    }

    private void updateSquare(){
        setCurrent();

        game.time.playing = true;

        if(old.color != current.color){
            int j = 0;
            while (MyColors.colors[j] == old.color || MyColors.colors[j] == current.color){
                if(j != 2)
                    j++;
                else
                    j = 0;
            }
            game.scheme.squares[curX][curY].color = MyColors.colors[j];
        }
        
        if(game.score.check()){
            game.score.addScore();
            game.time.reset();
            setCurrent();
        }

    }
}
