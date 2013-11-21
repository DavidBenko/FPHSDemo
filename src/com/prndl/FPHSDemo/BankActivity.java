package com.prndl.fphsdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
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
	
	public void depositClicked(View v){
		Toast.makeText(getApplicationContext(), "Deposit Made",
				   Toast.LENGTH_SHORT).show();
	}
	public void withdrawClicked(View v){
		Toast.makeText(getApplicationContext(), "Withdraw Made",
				   Toast.LENGTH_SHORT).show();
	}

}
