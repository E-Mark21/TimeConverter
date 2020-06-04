package com.hfad.timeconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;


import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void convert(View view) {
        EditText editText = (EditText) findViewById(R.id.enter_time);
        String time = editText.getText().toString();
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getApplicationWindowToken(), 0);
        if (!TextUtils.isEmpty(editText.getText().toString())) {
            long sec = Long.parseLong(time, 16);
            long one = sec / 2;
            long two = sec - one;
            Calendar calendar1958 = new GregorianCalendar(1958,0,1);
            calendar1958.add(Calendar.SECOND, (int)one);
            calendar1958.add(Calendar.SECOND, (int)two);
            TextView textView = (TextView) findViewById(R.id.timeInSat);
            textView.getPaint().setUnderlineText(true);
            String time1 = calendar1958.getTime().toString();
            textView.setText(time1);

        } else {
            TextView error = (TextView) findViewById(R.id.timeInSat);
            error.getPaint().setUnderlineText(true);
            error.setText("Введите время!");
        }


    }
}
