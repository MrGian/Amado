package it.atomicfrog.amado.utils;

import com.badlogic.gdx.graphics.Color;

import java.util.Random;

public class MyColors {
    public static Color[] colors = {Color.valueOf("EA4335"),Color.valueOf("FBBC04"),Color.valueOf("4285F4")};
    public static Color white = Color.valueOf("F6EDDD");
    public static Color black = Color.valueOf("1E1E1E");

    public static Color randomColor(){
        Random randy = new Random();
        return colors[randy.nextInt(colors.length)];
    }
}
