package com.alyndroid.architecturepatternstutorialshomework.ui;

import com.alyndroid.architecturepatternstutorialshomework.interfaces.Subtract;
import com.alyndroid.architecturepatternstutorialshomework.models.NumberModel;
import com.alyndroid.architecturepatternstutorialshomework.repository.DataBase;

public class SubtractPresenter {

    Subtract subtract;

    public SubtractPresenter(Subtract subtract) {
        this.subtract = subtract;
    }

    private NumberModel getNumberFromDB() {
        return new DataBase().getNumbers();
    }

    public void getSubtractResult() {
        subtract.onSubtract((getNumberFromDB().getFirstNum() - getNumberFromDB().getSecondNum()) + "");
    }
}
