package com.alyndroid.architecturepatternstutorialshomework.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import com.alyndroid.architecturepatternstutorialshomework.R;
import com.alyndroid.architecturepatternstutorialshomework.databinding.ActivityMainBinding;
import com.alyndroid.architecturepatternstutorialshomework.interfaces.Subtract;
import com.alyndroid.architecturepatternstutorialshomework.models.NumberModel;
import com.alyndroid.architecturepatternstutorialshomework.repository.DataBase;
import com.alyndroid.architecturepatternstutorialshomework.viewmodel.MultiplyViewModel;

import butterknife.BindView;

public class MainActivity extends AppCompatActivity implements Subtract, View.OnClickListener {


    Button btnSummation, btnSubtract, btnMul;
    TextView textViewResultSub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSummation = findViewById(R.id.plus_button);
        btnSubtract = findViewById(R.id.div_button);
        btnMul = findViewById(R.id.mul_button);
        textViewResultSub = findViewById(R.id.div_result_textView);
        btnSummation.setOnClickListener(this);
        btnMul.setOnClickListener(this);
        btnSubtract.setOnClickListener(this);
    }


    // Summation function with MVC design pattern
    private void SummationWithMVC() {
        final TextView textSummationResult;
        final TextView textViewFirstNum, textViewSecondNum;

        textSummationResult = findViewById(R.id.plus_result_textView);
        textViewFirstNum = findViewById(R.id.textView4);
        textViewSecondNum = findViewById(R.id.textView5);
        btnSummation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataBase dataBase = new DataBase();
                NumberModel model = dataBase.getNumbers();
                textViewFirstNum.setText(model.getFirstNum() + "");
                textViewSecondNum.setText(model.getSecondNum() + "");
                int sum = model.getFirstNum() + model.getSecondNum();
                textSummationResult.setText(sum + "");
                Log.e("OK", "OK from MVC");
            }
        });
    }

    // Subtract function user MVP design pattern
    private void SubtractWithMVP() {
        SubtractPresenter presenter = new SubtractPresenter(this);
        presenter.getSubtractResult();
        Log.e("OK", "OK from MVP");
    }

    @Override
    public void onSubtract(String result) {
        textViewResultSub.setText(result);
    }


    ActivityMainBinding binding;
    MultiplyViewModel viewModel;

    // Multiply function using MVVM design pattern
    private void MultiplyWithMVVM() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        viewModel = ViewModelProviders.of(this).get(MultiplyViewModel.class);
        binding.setLifecycleOwner(this);
        binding.setMyViewModel(viewModel);
        Log.e("OK", "OK from MVVM");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.plus_button:
                SummationWithMVC();
                break;
            case R.id.div_button:
                SubtractWithMVP();
                break;
            case R.id.mul_button:
                MultiplyWithMVVM();
                break;
            default:
                break;
        }
    }
}
