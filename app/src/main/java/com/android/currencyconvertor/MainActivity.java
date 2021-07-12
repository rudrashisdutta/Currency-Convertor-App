package com.android.currencyconvertor;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


/*TODO -- Extract $ in ₹ from google
*  Maybe remove action bar
 */

public class MainActivity extends AppCompatActivity {
    private ImageView image;
    private EditText getCur;
    private TextView showCur;
    protected Button convert;
    protected Button reverse;
    private TextView toCon,con;
    private static final String check = CurrencyConvertor.getFromResources(R.string.enter_USD);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getCur= findViewById(R.id.enteredCur);
        showCur= findViewById(R.id.convertedCur);
        convert= findViewById(R.id.convert);
        reverse= findViewById(R.id.reverse);
        toCon= findViewById(R.id.toconvert);
        con= findViewById(R.id.converted);
        image= findViewById(R.id.logo);

        convert.setOnClickListener(view -> {
            if(!getCur.getText().toString().equals("")) {
                if (toCon.getText().toString().equals(check)) {
                    double usd;
                    usd = Double.parseDouble(getCur.getText().toString());
                    String inr = "";
                    inr += convertFromUSDtoINR(usd);
                    showCur.setText(inr);
                } else {
                    double inr;
                    inr = Double.parseDouble(getCur.getText().toString());
                    String usd = "";
                    usd += convertFromINRtoUSD(inr);
                    showCur.setText(usd);
                }
            }
            else{
                showCur.setText("");
            }
        });
        reverse.setOnClickListener(view -> {
            if(toCon.getText().toString().equals(check)){
                toCon.setText(R.string.enter_INR);
                con.setText(R.string.is_USD);
                getCur.setHint("Enter in INR");
                image.setImageResource(R.drawable.inr);
            }
            else{
                toCon.setText(R.string.enter_USD);
                con.setText(R.string.is_INR);
                getCur.setHint("Enter in USD");
                image.setImageResource(R.drawable.dollar);
            }
            showCur.setText("");
        });
    }
    private double convertFromUSDtoINR(double USD){
        return 73.76*USD;
    }
    private double convertFromINRtoUSD(double INR){
        return INR/73.76;
    }
}