package com.example.android.tipcalculator;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private EditText mEditAmount;
    private EditText mEditPercentage;
    private double tip_res;
    private CoordinatorLayout mSnackBarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEditAmount = findViewById(R.id.total_amount);
        mEditPercentage = findViewById(R.id.tip_percentage);
        mSnackBarLayout = findViewById(R.id.coordinatorLayout);
        final Button mTip = findViewById(R.id.tip);
        mTip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double amount = Double.parseDouble(mEditAmount.getText().toString());
                double tip_per = Double.parseDouble(mEditPercentage.getText().toString());
                tip_res = (amount*tip_per)/100;
                Log.d(TAG, "onClick() called with: v = [" + tip_res + "]");
                mTip.setTextColor(Color.WHITE);

                final Snackbar snackbar = Snackbar.make(mSnackBarLayout,
                        "Tip is: $"+tip_res,
                        Snackbar.LENGTH_INDEFINITE);

                snackbar.show();

            }
        });
    }
}
