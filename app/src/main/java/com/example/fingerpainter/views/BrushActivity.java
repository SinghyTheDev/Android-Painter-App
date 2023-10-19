package com.example.fingerpainter.views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;

import com.example.fingerpainter.R;
import com.example.fingerpainter.viewModels.BrushViewModel;
import com.example.fingerpainter.databinding.ActivityBrushSelectorBinding;

public class BrushActivity extends AppCompatActivity {

    BrushViewModel brushViewModel = new BrushViewModel();
    ActivityBrushSelectorBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setBinding(DataBindingUtil.setContentView(this, R.layout.activity_brush_selector));
        getBinding().setViewModel(getBrushViewModel());
        getBinding().getViewModel().setShape(getIntent().getStringExtra("currentShape"));
        getBinding().getViewModel().setSize(getIntent().getIntExtra("currentSize", 0));


//        set listener for brush size seekbar
        getBinding().brushSizeSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
//                if seekbar progress changes then update brush size value and textview
                binding.getViewModel().setSize(i);
                binding.getViewModel().setSizeString("SIZE: " + i + "px");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }

    //    save brush size and shape states
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putInt("currentSize", getBinding().getViewModel().getSize());
        outState.putString("currentShape", getBinding().getViewModel().getShape());
        super.onSaveInstanceState(outState);
    }

    //    restore brush size and shape states
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        getBinding().getViewModel().setSize(savedInstanceState.getInt("currentSize"));
        getBinding().getViewModel().setShape(savedInstanceState.getString("currentShape"));
    }

    //    when user clicks OK button, put brush settings in intent for next activity and close this activity
    public void onOKButtonClick(View v) {
        Intent intent = new Intent();
        intent.putExtra("newSize", getBinding().getViewModel().getSize());
        intent.putExtra("newShape", getBinding().getViewModel().getShape());
        intent.putExtra("requestCode", getBinding().getViewModel().getRequestCode());
        setResult(Activity.RESULT_OK, intent);
        finish();
    }

    public BrushViewModel getBrushViewModel() {
        return brushViewModel;
    }

    public ActivityBrushSelectorBinding getBinding() {
        return binding;
    }

    public void setBinding(ActivityBrushSelectorBinding binding) {
        this.binding = binding;
    }
}