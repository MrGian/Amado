package it.atomicfrog.amado.objects;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import it.atomicfrog.amado.utils.MyColors;

public class Line {

    public static void render(ShapeRenderer renderer){
        renderer.begin(ShapeRenderer.ShapeType.Filled);
        renderer.setColor(MyColors.colors[0]);
        renderer.rect(-4.5f,-3f,9f,0.1f);
        renderer.end();
    }
}
