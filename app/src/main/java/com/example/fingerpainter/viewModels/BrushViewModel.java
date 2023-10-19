package com.example.fingerpainter.viewModels;

import androidx.databinding.BaseObservable;

import com.example.fingerpainter.BR;
import com.example.fingerpainter.models.BrushModel;

public class BrushViewModel extends BaseObservable {

    BrushModel brushModel = new BrushModel();

    public void setSizeString(String sizeString) {
        this.brushModel.setUserSizeString(sizeString);
        notifyPropertyChanged(BR._all);
    }

    public int getSize() {
        return brushModel.getUserSize();
    }

    public void setSize(int size) {
        this.brushModel.setUserSize(size);
    }

    public int getRequestCode() {
        return brushModel.getRequestCode();
    }

    public String getShape() {
        return brushModel.getUserShape();
    }

    public void setShape(String shape) {
        this.brushModel.setUserShape(shape);
        notifyPropertyChanged(BR._all);
    }

    public String getSizeString() {
        return ("SIZE: " + this.brushModel.getUserSize() + "px");
    }

    public String getShapeString() {
        return ("SHAPE: " + this.brushModel.getUserShape());
    }

    public void setShapeSquare() {
        this.brushModel.setUserShape("SQUARE");
        notifyPropertyChanged(BR._all);
    }

    public void setShapeRound() {
        this.brushModel.setUserShape("ROUND");
        notifyPropertyChanged(BR._all);
    }
}
