package it.atomicfrog.amado.utils;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;

public class Projector {
    public static Vector2 project(float x, float y, OrthographicCamera camera, OrthographicCamera acamera){
        return new Vector2(x * acamera.viewportWidth / camera.viewportWidth,y * acamera.viewportHeight / camera.viewportHeight);
    }
}
