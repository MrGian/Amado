package it.atomicfrog.amado.objects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

public class Square {
    public Vector2 position;
    public Color color;
    private float size;

    public Square(Vector2 position, Color color, float size){
        this.position = position;
        this.color = color;
        this.size = size;

    }

    public void render(ShapeRenderer renderer){
        renderer.begin(ShapeRenderer.ShapeType.Filled);
        renderer.setColor(color);
        renderer.rect(position.x,position.y,size,size);
        renderer.end();
    }
}
