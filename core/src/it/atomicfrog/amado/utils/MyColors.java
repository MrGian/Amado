package it.atomicfrog.amado.utils;

import com.badlogic.gdx.graphics.Color;

import java.util.Random;

public class MyColors {
    public static Color[] colors = {Color.RED,Color.YELLOW,Color.BLUE};

    public static Color randomColor(){
        Random randy = new Random();
        return colors[randy.nextInt(colors.length)];
    }
}
