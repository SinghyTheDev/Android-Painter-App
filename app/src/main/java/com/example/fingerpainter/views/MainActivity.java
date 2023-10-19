package com.example.fingerpainter.views;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;

import com.example.fingerpainter.R;
import com.example.fingerpainter.databinding.ActivityMainBinding;
import com.example.fingerpainter.viewModels.MainViewModel;

public class MainActivity extends AppCompatActivity {

    ActivityResultLauncher<Intent> activityResultLauncher;
    ActivityMainBinding binding;
    MainViewModel mainViewModel = new MainViewModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBinding(DataBindingUtil.setContentView(this, R.layout.activity_main));
        getBinding().setViewModel(getMainViewModel());
        getBinding().getViewModel().setCanvas(findViewById(R.id.canvasView));

//        load image if applicable
        if (getIntent().getData() != null) {
            getBinding().getViewModel().getCanvas().load(getIntent().getData());
        }

        setActivityResultLauncher(registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
            if (result.getResultCode() == Activity.RESULT_OK) {
//                get data and request code of previous activity
                Intent data = result.getData();
                assert data != null;
                int requestCode = data.getIntExtra("requestCode", 0);
                Bundle bundle = data.getExtras();
//                apply previous activity data
                if (requestCode == getBinding().getViewModel().getColourActivityCode()) {
                    getBinding().getViewModel().getCanvas().setColour(bundle.getInt("newColour"));
                } else if (requestCode == getBinding().getViewModel().getBrushActivityCode()) {
                    getBinding().getViewModel().getCanvas().setBrushWidth(bundle.getInt("newSize"));
                    getBinding().getViewModel().getCanvas().setBrush(Paint.Cap.valueOf(bundle.getString("newShape")));
                }
            }
        }));
    }

    //    save colour, size, and shape states
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putInt("currentColour", getBinding().getViewModel().getCanvas().getColour());
        outState.putInt("currentSize", getBinding().getViewModel().getCanvas().getBrushWidth());
        outState.putString("currentShape", getBinding().getViewModel().getCanvas().getBrush().toString());
        super.onSaveInstanceState(outState);
    }

    //    restore colour, size, and shape states
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        getBinding().getViewModel().getCanvas().setColour(savedInstanceState.getInt("currentColour"));
        getBinding().getViewModel().getCanvas().setBrushWidth(savedInstanceState.getInt("currentSize"));
        getBinding().getViewModel().getCanvas().setBrush(Paint.Cap.valueOf(savedInstanceState.getString("currentShape")));
    }

    //    when user clicks on brush button, put current size and shape states in intent and open brush activity
    public void onBrushButtonClick(View v) {
        Intent intent = new Intent(MainActivity.this, BrushActivity.class);
        intent.putExtra("currentSize", getBinding().getViewModel().getCanvas().getBrushWidth());
        intent.putExtra("currentShape", getBinding().getViewModel().getCanvas().getBrush().toString());
        getActivityResultLauncher().launch(intent);
    }

    //    when user clicks on brush button, put current size and shape states in intent and open colour activity
    public void onColourButtonClick(View v) {
        Intent intent = new Intent(MainActivity.this, ColourActivity.class);
        intent.putExtra("currentColour", getBinding().getViewModel().getCanvas().getColour());
        getActivityResultLauncher().launch(intent);
    }

    public ActivityResultLauncher<Intent> getActivityResultLauncher() {
        return activityResultLauncher;
    }

    public void setActivityResultLauncher(ActivityResultLauncher<Intent> activityResultLauncher) {
        this.activityResultLauncher = activityResultLauncher;
    }

    public ActivityMainBinding getBinding() {
        return binding;
    }

    public void setBinding(ActivityMainBinding binding) {
        this.binding = binding;
    }

    public MainViewModel getMainViewModel() {
        return mainViewModel;
    }
}