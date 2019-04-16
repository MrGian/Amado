package it.atomicfrog.amado.objects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;
import java.util.List;

import it.atomicfrog.amado.utils.MyColors;

public class Scheme {

    final int size = 4;

    float squareSize = 1.1f;
    float spacing = 0.2f;

    Vector2 position;

    float pixelSize;


    Square[][] squares = new Square[size][size];

    public Scheme(){
        position = new Vector2(0,0);
        pixelSize = (squareSize * size) + (spacing * (size - 1));

        init();

    }

    public void render(ShapeRenderer renderer){
        for(int x=0;x<size;x++){
            for(int y=0;y<size;y++){
                squares[x][y].render(renderer);
            }
        }
    }

    private void init(){
        for(int y=0;y<size;y++){
            for(int x=0;x<size;x++){
                Vector2 localPos = new Vector2(position.x - pixelSize/2,position.y - pixelSize/2);
                squares[x][y] = new Square(localPos, MyColors.randomColor(),squareSize);
                position = new Vector2(position.x + (squareSize + spacing), position.y);
            }

            position = new Vector2(0, position.y + (squareSize + spacing));
        }
    }
}
