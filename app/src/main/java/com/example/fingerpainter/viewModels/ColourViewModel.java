package com.example.fingerpainter.viewModels;

import android.graphics.Color;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.fingerpainter.BR;
import com.example.fingerpainter.models.ColourModel;

public class ColourViewModel extends BaseObservable {

    ColourModel colourModel = new ColourModel();

    @Bindable
    public int getColour() {
        return colourModel.getUserColour();
    }

    public void setColour(int colour) {
        this.colourModel.setUserColour(colour);
        notifyPropertyChanged(BR.viewModel);
    }

    public void setColourBlack() {
        this.colourModel.setUserColour(Color.parseColor("BLACK"));
        notifyPropertyChanged(BR._all);
    }

    public void setColourRed() {
        this.colourModel.setUserColour(Color.parseColor("RED"));
        notifyPropertyChanged(BR._all);
    }

    public void setColourGreen() {
        this.colourModel.setUserColour(Color.parseColor("GREEN"));
        notifyPropertyChanged(BR._all);
    }

    public void setColourBlue() {
        this.colourModel.setUserColour(Color.parseColor("BLUE"));
        notifyPropertyChanged(BR._all);
    }

    public void setColourYellow() {
        this.colourModel.setUserColour(Color.parseColor("YELLOW"));
        notifyPropertyChanged(BR._all);
    }

    public int getRequestCode() {
        return this.colourModel.getRequestCode();
    }
}
