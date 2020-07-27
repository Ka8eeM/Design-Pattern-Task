package com.alyndroid.architecturepatternstutorialshomework.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.alyndroid.architecturepatternstutorialshomework.models.NumberModel;
import com.alyndroid.architecturepatternstutorialshomework.repository.DataBase;

public class MultiplyViewModel extends ViewModel {
    public MutableLiveData<String> resultMutableLiveData = new MutableLiveData<>();

    private NumberModel getNumberFromDB() {
        return new DataBase().getNumbers();
    }

    public void getMultiplyResult() {
        String ret = getNumberFromDB().getFirstNum() * getNumberFromDB().getSecondNum() + "";
        resultMutableLiveData.setValue(ret);
    }
}
