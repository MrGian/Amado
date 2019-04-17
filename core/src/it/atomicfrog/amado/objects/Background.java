package it.atomicfrog.amado.objects;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import it.atomicfrog.amado.utils.MyColors;

public class Background {
    public static void render(ShapeRenderer renderer){
        renderer.begin(ShapeRenderer.ShapeType.Filled);
        renderer.setColor(MyColors.white);
        renderer.rect(-4.5f,-8,9,16);
        renderer.end();
    }
}
