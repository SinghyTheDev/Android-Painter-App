package com.example.fingerpainter.models;

import com.example.fingerpainter.views.FingerPainterView;

public class MainModel {

    public static final int BRUSH_ACTIVITY_CODE = 1;
    public static final int COLOUR_ACTIVITY_CODE = 2;
    public FingerPainterView canvas;

    public FingerPainterView getUserCanvas() {
        return canvas;
    }

    public void setUserCanvas(FingerPainterView canvas) {
        this.canvas = canvas;
    }

    public int getBrushActivityCode() {
        return BRUSH_ACTIVITY_CODE;
    }

    public int getColourActivityCode() {
        return COLOUR_ACTIVITY_CODE;
    }
}
