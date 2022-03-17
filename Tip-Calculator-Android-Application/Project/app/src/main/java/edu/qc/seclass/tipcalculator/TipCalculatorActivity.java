package edu.qc.seclass.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TipCalculatorActivity extends AppCompatActivity implements View.OnClickListener {
    double totalBill;
    double totalPeople;
    EditText checkValue;
    EditText partySize;
    EditText tipof15P;
    EditText tipof20P;
    EditText tipof25P;
    EditText totalof15P;
    EditText totalof20P;
    EditText totalof25P;
    Button Compute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkValue = (EditText) findViewById(R.id.checkAmountValue);
        partySize = (EditText) findViewById(R.id.partySizeValue);
        tipof15P = (EditText) findViewById(R.id.fifteenPercentTipValue);
        tipof20P = (EditText) findViewById(R.id.twentyPercentTipValue);
        tipof25P = (EditText) findViewById(R.id.twentyfivePercentTipValue);
        totalof15P = (EditText) findViewById(R.id.fifteenPercentTotalValue);
        totalof20P = (EditText) findViewById(R.id.twentyPercentTotalValue);
        totalof25P = (EditText) findViewById(R.id.twentyfivePercentTotalValue);
        Compute = (Button) findViewById(R.id.buttonCompute);
        Compute.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.buttonCompute) {

            //}
            checkValue = (EditText) findViewById(R.id.checkAmountValue);
            partySize = (EditText) findViewById(R.id.partySizeValue);

            if (checkValue.getText().toString().isEmpty()) {
                Toast.makeText(TipCalculatorActivity.this, "Enter a valid number for check amount.", Toast.LENGTH_LONG).show();
            }
            else if (partySize.getText().toString().isEmpty()) {
                Toast.makeText(TipCalculatorActivity.this, "Enter a valid number for the number of people.", Toast.LENGTH_LONG).show();
            }
            else if (Integer.valueOf(checkValue.getText().toString()) <= 0) {
                Toast.makeText(TipCalculatorActivity.this, "Enter a number positive number for check amount.", Toast.LENGTH_LONG).show();
            } else if (Integer.valueOf(partySize.getText().toString()) <= 0) {
                Toast.makeText(TipCalculatorActivity.this, "Enter a number positive number for the number of people.", Toast.LENGTH_LONG).show();
            }
            else {
                tipof15P = (EditText) findViewById(R.id.fifteenPercentTipValue);
                tipof20P = (EditText) findViewById(R.id.twentyPercentTipValue);
                tipof25P = (EditText) findViewById(R.id.twentyfivePercentTipValue);
                totalof15P = (EditText) findViewById(R.id.fifteenPercentTotalValue);
                totalof20P = (EditText) findViewById(R.id.twentyPercentTotalValue);
                totalof25P = (EditText) findViewById(R.id.twentyfivePercentTotalValue);
                totalBill = Double.valueOf(checkValue.getText().toString());
                totalPeople = Double.valueOf(partySize.getText().toString());
                double BeforeTipsPerPerson = totalBill/totalPeople;

                int TipPerPersonWith15 = (int) Math.ceil(BeforeTipsPerPerson * 0.15);
                int TipPerPersonWith20 = (int) Math.ceil(BeforeTipsPerPerson * 0.20);
                int TipPerPersonWith25 = (int) Math.ceil(BeforeTipsPerPerson * 0.25);


                int TotalPerPersonWith15 = (int) Math.ceil(BeforeTipsPerPerson + TipPerPersonWith15);
                int TotalPerPersonWith20 = (int) Math.ceil(BeforeTipsPerPerson + TipPerPersonWith20);
                int TotalPerPersonWith25 = (int) Math.ceil(BeforeTipsPerPerson + TipPerPersonWith25);

                String IndividualTipWith15 = Integer.toString(TipPerPersonWith15);
                tipof15P.setText(IndividualTipWith15);

                String IndividualTipWith20 = Integer.toString(TipPerPersonWith20);
                tipof20P.setText(IndividualTipWith20);

                String IndividualTipWith25 = Integer.toString(TipPerPersonWith25);
                tipof25P.setText(IndividualTipWith25);

                String IndividualTotalWith15 = Integer.toString(TotalPerPersonWith15);
                totalof15P.setText(IndividualTotalWith15);

                String IndividualTotalWith20 = Integer.toString(TotalPerPersonWith20);
                totalof20P.setText(IndividualTotalWith20);

                String IndividualTotalWith25 = Integer.toString(TotalPerPersonWith25);
                totalof25P.setText(IndividualTotalWith25);



            }
        }
    }
}



