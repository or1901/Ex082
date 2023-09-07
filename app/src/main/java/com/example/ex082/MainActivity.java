package com.example.ex082;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

/**
 * @author    Ori Roitzaid <or1901 @ bs.amalnet.k12.il>
 * @version	  1
 * @since	  4/5/2023
 * An activity that collects data of a mathematical series, and sends it to another activity.
 */
public class MainActivity extends AppCompatActivity {
    RadioButton ariRb;
    RadioButton geoRb;
    EditText firstValueEt;
    EditText diffQuotEt;
    String firstValueStr;
    String diffQuotStr;
    Intent si;
    int seriesType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ariRb = (RadioButton) findViewById(R.id.ariRb);
        geoRb = (RadioButton) findViewById(R.id.geoRb);
        firstValueEt = (EditText) findViewById(R.id.firstValueEt);
        diffQuotEt = (EditText) findViewById(R.id.diffQuotEt);

    }

    /**
     * This function sends the data of the series to the second activity(if valid).
     * If not valid, presents a toast message.
     * <p>
     *
     * @param view The view object of the next button.
     */
    public void nextActivity(View view) {
        if(isDataValid()) {
            si = new Intent(this, ResultsActivity.class);

            seriesType = getSeriesType();

            si.putExtra("Type", seriesType);
            startActivity(si);
        }
        else {
            Toast.makeText(this, "There is an empty field!", Toast.LENGTH_LONG).show();
        }
    }

    /**
     * This function checks if the data of the series is valid(there isn't an empty field).
     * <p>
     *
     * @return Whether the series data is valid, or not.
     */
    public boolean isDataValid() {
        firstValueStr = firstValueEt.getText().toString();
        diffQuotStr = diffQuotEt.getText().toString();

        return (ariRb.isChecked() || geoRb.isChecked()) && (!firstValueStr.equals("")) &&
                (!diffQuotStr.equals(""));
    }

    /**
     * This function converts the chosen series type into a number, and returns it.
     * <p>
     *
     * @return 0 if the series is arithmetic, 1 if it is geometric.
     */
    public int getSeriesType(){
        if(ariRb.isChecked())
            return 0;
        else
            return 1;
    }
}