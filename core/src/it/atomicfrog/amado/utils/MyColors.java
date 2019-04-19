package it.atomicfrog.amado.utils;

import com.badlogic.gdx.graphics.Color;

import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.Random;

public class MyColors {
    private final static boolean dark = false;

    public static Color[] colors = {Color.valueOf("EA4335"),Color.valueOf("FBBC04"),Color.valueOf("4285F4")};
    public static Color white = Color.valueOf("F6EDDD");
    public static Color black = Color.valueOf("1E1E1E");

    public static Color[] uicolors;
    public static String title;

    public static Color[] lightuicolors = {white, Color.BLACK};
    public static Color[] darkuicolors = {black, Color.WHITE};

    public static Color randomColor(){
        Random randy = new Random();
        return colors[randy.nextInt(colors.length)];
    }

    public static void init(){
        if(dark){
            uicolors = darkuicolors;
            title = "title_dark.png";
        }
        else{
            uicolors = lightuicolors;
            title = "title.png";
        }
    }
}
