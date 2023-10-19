package com.example.fingerpainter.views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.fingerpainter.R;
import com.example.fingerpainter.databinding.ActivityColourSelectorBinding;
import com.example.fingerpainter.viewModels.ColourViewModel;

public class ColourActivity extends AppCompatActivity {

    ColourViewModel colourViewModel = new ColourViewModel();
    ActivityColourSelectorBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setBinding(DataBindingUtil.setContentView(this, R.layout.activity_colour_selector));
        getBinding().setViewModel(colourViewModel);
        getBinding().getViewModel().setColour(getIntent().getIntExtra("currentColour", 0));
    }

    //    save colour state
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putInt("newColour", getBinding().getViewModel().getColour());
        super.onSaveInstanceState(outState);
    }

    //    restore colour state
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        getBinding().getViewModel().setColour(savedInstanceState.getInt("newColour"));
    }

    //    when user clicks OK button, put colour setting in intent for next activity and close this activity
    public void onOKButtonClick(View v) {
        Intent intent = new Intent();
        intent.putExtra("newColour", getBinding().getViewModel().getColour());
        intent.putExtra("requestCode", getBinding().getViewModel().getRequestCode());
        setResult(Activity.RESULT_OK, intent);
        finish();
    }

    public ColourViewModel getColourViewModel() {
        return colourViewModel;
    }

    public ActivityColourSelectorBinding getBinding() {
        return binding;
    }

    public void setBinding(ActivityColourSelectorBinding binding) {
        this.binding = binding;
    }
}