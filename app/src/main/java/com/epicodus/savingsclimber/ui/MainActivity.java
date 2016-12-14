package com.epicodus.savingsclimber.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.epicodus.savingsclimber.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.addExpenseButton)
    Button mAddExpenseButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mAddExpenseButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == mAddExpenseButton) {
            Intent intent = new Intent(MainActivity.this, CreateExpenseActivity.class);
            startActivity(intent);
        }
    }
}
//TODO build recurring expenses list display
//TODO build savings goal model
//TODO build savings goal form
//TODO build savings goal list display
//TODO connect savings goal and recurring expenses

