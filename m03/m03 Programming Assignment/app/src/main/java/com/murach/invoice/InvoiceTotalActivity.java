package com.murach.invoice;

import android.os.Bundle;
import android.app.Activity;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.TextView.OnEditorActionListener;
import android.view.KeyEvent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class InvoiceTotalActivity extends Activity implements OnEditorActionListener{

	private TextView discountPercentText;
	private TextView discountAmountText;
	private TextView totalText;
	private EditText subtotalEditText;
    private String subtotalToString = "";

    private SharedPreferences savedValues;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_invoice_total);

		discountPercentText = (TextView) findViewById(R.id.discountPercentTextView);
		discountAmountText = (TextView) findViewById(R.id.discountAmountTextView);
		totalText = (TextView) findViewById(R.id.totalTextView);
		subtotalEditText = (EditText) findViewById(R.id.subtotalEditText);
		subtotalEditText.setOnEditorActionListener(this);
		savedValues = getSharedPreferences("SavedValues", MODE_PRIVATE);

	}


	@Override
	public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
		if (actionId == EditorInfo.IME_ACTION_DONE || actionId == EditorInfo.IME_ACTION_UNSPECIFIED){
            calculateAndDisplay();
		}
		return false;
	}

	@Override
    public void onPause(){
	    Editor editor = savedValues.edit();
	    editor.putString("subtotalToString", subtotalToString);
        editor.apply();

        super.onPause();
    }
	@Override
    public void onResume(){
	    super.onResume();
	    subtotalToString = savedValues.getString("subtotalToString", "");
	    subtotalEditText.setText(subtotalToString);
	    calculateAndDisplay();
    }

    public void calculateAndDisplay() {
        float total; // Running total starting with initial subtotal
        float discountPercent; // Holds the calculated percentage
        String displayPercent; // Holds the percentage to be displayed
        float discountAmount; // Holds the total discount applied
        subtotalToString = subtotalEditText.getText().toString(); // get subtotal widget text into string format

        // Determine is the subTotal has a value or not
        if(subtotalToString.equals("")){
            total = 0;
        }
        else{
            total = Float.parseFloat(subtotalToString);
        }

        // Set the discount percent. 200 and above is a 20% discount
        if(total > 199){
            discountPercent = .20f;
        }
        else if(total > 99){
            discountPercent = .10f;
        }
        else {
            discountPercent = 0;
        }



        // Calculate total discount
        discountAmount = total * discountPercent;

        // Calculate final total with discount
        total = total - discountAmount;

        // Format text for display

        displayPercent = String.valueOf((int) (discountPercent * 100)) + "%";
        String discountAmountString = "$" + String.format("%.2f", discountAmount);
        String totalString = "$" + String.format("%.2f", total);

        // Update text in application
        discountPercentText.setText(displayPercent);
        discountAmountText.setText(discountAmountString);
        totalText.setText(totalString);


    }

}