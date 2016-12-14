package com.epicodus.savingsclimber.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.epicodus.savingsclimber.Constants;
import com.epicodus.savingsclimber.R;
import com.epicodus.savingsclimber.models.Expense;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.Bind;
import butterknife.ButterKnife;

public class CreateExpenseActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.expenseNameEditText) EditText mExpenseNameEditText;
    @Bind(R.id.expenseCostEditText) EditText mExpenseCostEditText;
    @Bind(R.id.createExpenseButton) Button mCreateExpenseButton;

    private DatabaseReference mExpenseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        mExpenseReference = FirebaseDatabase
                .getInstance()
                .getReference()
                .child(Constants.FIREBASE_CHILD_EXPENSE);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_expense);
        ButterKnife.bind(this);

        mCreateExpenseButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == mCreateExpenseButton) {
            String expenseName = mExpenseNameEditText.getText().toString().trim();
            float expenseCost = Float.parseFloat(mExpenseCostEditText.getText().toString().trim());
            Expense expense = new Expense(expenseName, expenseCost);

            mExpenseReference.push().setValue(expense);
            Toast.makeText(CreateExpenseActivity.this, "Expense Saved!", Toast.LENGTH_SHORT).show();
        }
    }
}
