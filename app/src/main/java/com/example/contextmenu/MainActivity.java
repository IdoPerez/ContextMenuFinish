package com.example.contextmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

/**
 * @author Ido Perez
 *  @since 2/9/2003, 16/11/19
 * @version 0.01
 */
public class MainActivity extends AppCompatActivity {
    EditText Diff, First;
    String diff, first;
    double firstNumber, difference;
    RadioButton Geometric, Invoice;
    int kind;
    RadioGroup rg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Diff = (EditText) findViewById(R.id.Diff);
        First = (EditText) findViewById(R.id.First);
        Geometric = (RadioButton) findViewById(R.id.Geometric);
        Invoice = (RadioButton) findViewById(R.id.Invoice);
        rg = (RadioGroup) findViewById(R.id.rg);
    }

    /**
     * The method checking the input and if hes correct she moving you to the next activity, with the first number in the series and with the difference.
     * @param view
     */
    public void NextActivity(View view) {

        diff = Diff.getText().toString();
        first = First.getText().toString();
        if (Invoice.isChecked() || Geometric.isChecked()) {
            if (!diff.isEmpty() && !first.isEmpty()) {
                firstNumber = Double.parseDouble(first);
                difference = Double.parseDouble(diff);
                kind = rg.getCheckedRadioButtonId();
                Intent si = new Intent(this, calculator.class);
                si.putExtra("kind", kind);
                si.putExtra("diff", difference);
                si.putExtra("firstNum", firstNumber);
                startActivity(si);
            } else {
                Toast.makeText(this, "Albert, yes i did input check. please put in the first number and diff", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Albert, yes i did input check.please enter Type", Toast.LENGTH_SHORT).show();
        }
    }
}


