package it.atomicfrog.amado.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import it.atomicfrog.amado.utils.MyColors;
import it.atomicfrog.amado.utils.SimpleDirectionGestureDetector;

public class Cursor {

    private Square current;
    private Square old;
    private Scheme scheme;
    private Score score;

    private int curX = 0;
    private int curY = 3;

    public Cursor(Score score, Scheme scheme){
        this.scheme = scheme;
        this.score = score;

        Gdx.input.setInputProcessor(detector);

        current = scheme.squares[curX][curY];

    }

    public void render(ShapeRenderer renderer){

        renderer.begin(ShapeRenderer.ShapeType.Filled);
        renderer.setColor(current.color);
        renderer.rect(current.position.x - scheme.spacing*2/3
                ,current.position.y - scheme.spacing*2/3
                ,scheme.squareSize + scheme.spacing*4/3
                ,scheme.spacing/3);

        renderer.rect(current.position.x - scheme.spacing*2/3
                ,current.position.y - scheme.spacing*2/3
                ,scheme.spacing/3
                ,scheme.squareSize + scheme.spacing*4/3);

        renderer.rect(current.position.x - scheme.spacing*2/3
                ,current.position.y + scheme.squareSize + scheme.spacing*1/3
                ,scheme.squareSize + scheme.spacing*4/3
                ,scheme.spacing/3);

        renderer.rect(current.position.x + scheme.squareSize + scheme.spacing/3
                ,current.position.y - scheme.spacing*2/3
                ,scheme.spacing/3
                ,scheme.squareSize + scheme.spacing*4/3);
        renderer.end();

    }

    SimpleDirectionGestureDetector detector = new SimpleDirectionGestureDetector(new SimpleDirectionGestureDetector.DirectionListener() {
        @Override
        public void onLeft() {
            old = scheme.squares[curX][curY];
            if(curX != 0)
                curX--;
            current = scheme.squares[curX][curY];
            updateSquare();
        }

        @Override
        public void onRight() {
            old = scheme.squares[curX][curY];
            if(curX != scheme.size - 1)
                curX++;
            current = scheme.squares[curX][curY];
            updateSquare();
        }

        @Override
        public void onUp() {
            old = scheme.squares[curX][curY];
            if(curY != scheme.size - 1)
                curY++;
            current = scheme.squares[curX][curY];
            updateSquare();
        }

        @Override
        public void onDown() {
            old = scheme.squares[curX][curY];
            if(curY != 0)
                curY--;
            current = scheme.squares[curX][curY];
            updateSquare();
        }
    });

    private void updateSquare(){
        if(old.color != current.color){
            int j = 0;
            while (MyColors.colors[j] == old.color || MyColors.colors[j] == current.color){
                if(j != 2)
                    j++;
                else
                    j = 0;
            }
            scheme.squares[curX][curY].color = MyColors.colors[j];
        }
        
        if(score.check()){
            score.addScore();
            current = scheme.squares[curX][curY];
        }

    }
}
