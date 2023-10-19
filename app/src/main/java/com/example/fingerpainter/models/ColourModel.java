package com.example.fingerpainter.models;

import static android.graphics.Color.parseColor;

public class ColourModel {

    public static final int REQUEST_CODE = 2;
    public int colour = parseColor("BLACK");

    public int getUserColour() {
        return colour;
    }

    public void setUserColour(int colour) {
        this.colour = colour;
    }

    public int getRequestCode() {
        return REQUEST_CODE;
    }
}
