package com.example.fingerpainter.viewModels;

import androidx.databinding.BaseObservable;

import com.example.fingerpainter.models.MainModel;
import com.example.fingerpainter.views.FingerPainterView;

public class MainViewModel extends BaseObservable {

    public MainModel mainModel = new MainModel();

    public FingerPainterView getCanvas() {
        return this.mainModel.getUserCanvas();
    }

    public void setCanvas(FingerPainterView canvas) {
        this.mainModel.setUserCanvas(canvas);
    }

    public int getBrushActivityCode() {
        return this.mainModel.getBrushActivityCode();
    }

    public int getColourActivityCode() {
        return this.mainModel.getColourActivityCode();
    }
}
