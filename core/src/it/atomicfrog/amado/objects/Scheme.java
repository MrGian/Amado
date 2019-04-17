package it.atomicfrog.amado.objects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;
import java.util.List;

import it.atomicfrog.amado.utils.MyColors;

public class Scheme {

    final int size = 4;

    float squareSize;
    float spacing;

    Vector2 position;

    float pixelSize;


    Square[][] squares = new Square[size][size];

    public Scheme(Vector2 position, float squareSize, float spacing){
        this.position = position;
        this.squareSize = squareSize;
        this.spacing = spacing;
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

    public void init(){
        Vector2 tempPos = position;

        for(int y=0;y<size;y++){
            for(int x=0;x<size;x++){
                Vector2 localPos = new Vector2(tempPos.x - pixelSize/2,tempPos.y - pixelSize/2);
                squares[x][y] = new Square(localPos, MyColors.randomColor(),squareSize);
                tempPos = new Vector2(tempPos.x + (squareSize + spacing), tempPos.y);
            }

            tempPos = new Vector2(0, tempPos.y + (squareSize + spacing));
        }
    }
}
