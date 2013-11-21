package com.prndl.fphsdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
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
		float number = Float.valueOf(amountTextField.getText().toString());
		return number;
	}
	
	/*
	 * Update Balance Label
	 */
	private void updateUI(){
		// Make a new Bank
		Bank bank = new Bank();
		// Get the Bank balance as cast into a string
		String balance = Float.toString(bank.getBalance(getApplicationContext()));
		// Find the TextView
		TextView balanceTextView = (TextView) findViewById(R.id.balanceTextView);
		// Set the TextView's text to our balance string
		balanceTextView.setText(balance);
	}
	
	/*
	 * onClick Listener for depositButton
	 */
	public void depositClicked(View v){
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

}
