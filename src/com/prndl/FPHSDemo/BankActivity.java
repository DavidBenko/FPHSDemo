package com.prndl.fphsdemo;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class BankActivity extends Activity {

	@Override
	/*
	 * onCreate is called when the Activity is first created.
	 * If you want to do something when the Activity loads, it should go here.
	 * 
	 * (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bank);
		updateUI();
	}

	@Override
	/*
	 * (non-Javadoc)
	 * @see android.app.Activity#onCreateOptionsMenu(android.view.Menu)
	 */
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.bank, menu);
		return true;
	}
	
	/*
	 * Gets the number from the user's input
	 */
	public float getUserEntry(){
		// Find the EditText
		EditText amountTextField = (EditText) findViewById(R.id.amountTextField);
		// Parse user entry into a floating-point number
		float number = 0.0f;
		try{
			number = Float.valueOf(amountTextField.getText().toString());
		}
		catch(Exception e){
			// Create error message
			AlertDialog alertDialog = new AlertDialog.Builder(this).create();
            // Setting Dialog Title
            alertDialog.setTitle("Error");
            // Setting Dialog Message
            alertDialog.setMessage("Please enter a valid currency amount");
            // Setting OK Button
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog,int which) 
                {
                    // close dialog
                	dialog.cancel();
                }
            });
            // Showing Alert Message
            alertDialog.show();
		}
		return number;
	}
	
	/*
	 * Update Balance Label
	 */
	private void updateUI(){
		// Make a new Bank
		Bank bank = new Bank();
		float balance = bank.getBalance(getApplicationContext());
		// Get the Bank balance as cast into a string
		String balanceStr = String.format("$%.2f",balance);
		// Find the TextView
		TextView balanceTextView = (TextView) findViewById(R.id.balanceTextView);
		// Set the TextView's text to our balance string
		balanceTextView.setText(balanceStr);
		
		//Set the TextView's color based on balance amount
		balanceTextView.setTextColor(balance > 0 ? Color.GREEN : Color.RED);
	}
	
	/*
	 * onClick Listener for depositButton
	 */
	public void depositClicked(View v){
		//Early out if the user entered zero or NaN
		if (getUserEntry() == 0)return;
		
		// Make a new Bank
		Bank bank = new Bank();
		// Deposit the amount the user entered from the bank
		bank.deposit(getApplicationContext(), getUserEntry());
		// Update UI to reflect new balance
		updateUI();
		// Show Deposit Notice
		Toast.makeText(getApplicationContext(), "Deposit Made",
				   Toast.LENGTH_SHORT).show();
	}
	/*
	 * onClick Listener for withdrawButton
	 */
	public void withdrawClicked(View v){
		//Early out if the user entered zero or NaN
		if (getUserEntry() == 0)return;
		
		// Make a new Bank
		Bank bank = new Bank();
		// Withdraw the amount the user entered from the bank
		bank.withdraw(getApplicationContext(), getUserEntry());
		// Update UI to reflect new balance
		updateUI();
		// Show Withdraw Notice
		Toast.makeText(getApplicationContext(), "Withdraw Made",
				   Toast.LENGTH_SHORT).show();
	}
	/*
	 * onClick Listener for aboutButton
	 */
	public void aboutClicked(MenuItem mi){
		AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        // Setting Dialog Title
        alertDialog.setTitle("About");
        // Setting Dialog Message
        alertDialog.setMessage("FPHSDemo v1.0.0\nMIT License\nCreated by David Benko\n\nCode Freely Available at:\nhttps://github.com/DavidBenko/FPHSDemo\n\nContact David:\nhttp://davidbenko.me\nhttp://prndl.us");
        // Setting OK Button
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog,int which) 
            {
                // close dialog
            	dialog.cancel();
            }
        });
        // Showing Alert Message
        alertDialog.show();
	}

}
