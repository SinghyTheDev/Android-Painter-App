package com.example.fingerpainter.models;

public class BrushModel {

    public static final int REQUEST_CODE = 1;
    int size;
    String shape;
    String sizeString;

    public void setUserSizeString(String sizeString) {
        this.sizeString = sizeString;
    }

    public int getUserSize() {
        return size;
    }

    public void setUserSize(int size) {
        this.size = size;
    }

    public int getRequestCode() {
        return REQUEST_CODE;
    }

    public String getUserShape() {
        return shape;
    }

    public void setUserShape(String shape) {
        this.shape = shape;
    }
}
