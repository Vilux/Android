package com.example.a00647591.tipcalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.RadioGroup;
import java.text.DecimalFormat;



public class MainActivity extends AppCompatActivity implements TextView.OnEditorActionListener{


    Button minusButton;
    Button plusButton;
    Button applyButton;
    EditText billAmount;
    TextView tipPercent;
    TextView tipAmount;
    TextView totalAmount;
    Spinner numberOfPeople;
    RadioButton noneButton;
    TextView perPerson;
    RadioGroup radioGroup;


    double billMoney;
    double tipPer;
    double totalMoney;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        minusButton = (Button) findViewById(R.id.minusButton);
        plusButton = (Button) findViewById(R.id.plusButton);
        applyButton = (Button) findViewById(R.id.applyButton);
        billAmount = (EditText) findViewById(R.id.billAmount);
        tipPercent = (TextView) findViewById(R.id.tipPercent);
        tipAmount = (TextView) findViewById(R.id.tipAmount);
        totalAmount = (TextView) findViewById(R.id.totalAmount);
        numberOfPeople = (Spinner) findViewById(R.id.numberOfPeople);
        noneButton = (RadioButton) findViewById(R.id.noneButton);
        perPerson = (TextView) findViewById(R.id.perPerson);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);

        tipPer = Double.parseDouble((tipPercent.getText().toString()).replace("%",""));

        billAmount.setOnEditorActionListener(this);

        minusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tipPer = tipPer - 1;
                tipPercent.setText(tipPer + "%");
                tipAmount.setText("$" + df.format((tipPer * 0.01) * billMoney));
                totalAmount.setText("$" + df.format(((tipPer * 0.01) * billMoney) + billMoney));

            }
        });

        plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tipPer = tipPer + 1;
                tipPercent.setText(tipPer + "%");
                tipAmount.setText("$" + df.format((tipPer * 0.01) * billMoney));
                totalAmount.setText("$" + df.format(((tipPer * 0.01) * billMoney) + billMoney));
            }
        });


        applyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (noneButton.getText().equals("Tip"))
                {
                    tipAmount.setText("$" + (Math.round(tipPer * 0.01 * billMoney)));
                    totalAmount.setText("$" + (Math.round(tipPer * 0.01 * billMoney) + billMoney));
                    totalMoney = Math.round(tipPer * 0.01 * billMoney) + billMoney;
                }
                else if(noneButton.getText().equals("Total"))
                {
                    totalAmount.setText("$" + (Math.round(tipPer * 0.01 * billMoney) + billMoney));
                    totalMoney = Math.round(tipPer * 0.01 * billMoney) + billMoney;
                }
                else if(noneButton.getText().equals("None"))
                {
                    totalMoney = (tipPer * 0.01 * billMoney) + billMoney;
                }

                String spinnerVal = numberOfPeople.getSelectedItem().toString();
                 if (spinnerVal.equals("None")){
                    perPerson.setText("$" + df.format(totalMoney));
                }
                else if (spinnerVal.equals("2 people")){
                    perPerson.setText("$" + df.format(totalMoney/2));
                }
                else if (spinnerVal.equals("3 people")){
                    perPerson.setText("$" + df.format(totalMoney/3));
                }
                else if (spinnerVal.equals("4 people")){
                    perPerson.setText("$" + df.format(totalMoney/4));
                }

                int selectedId = radioGroup.getCheckedRadioButtonId();
                noneButton = (RadioButton) findViewById(selectedId);
            }
        });
    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        billMoney = Double.parseDouble(billAmount.getText().toString());
        if (actionId == EditorInfo.IME_ACTION_DONE) {
            tipAmount.setText("$" + df.format((tipPer * 0.01) * billMoney));
            totalAmount.setText("$" + df.format(((tipPer * 0.01) * billMoney) + billMoney));
        }
        return false;
    }

    DecimalFormat df = new DecimalFormat("#.00");

}