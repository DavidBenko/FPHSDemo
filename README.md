FPHSDemo
========

Demo Android application for Forest Park High School.  
User has a bank that they can deposit and withdraw money from.  
[Google Play Link](https://play.google.com/store/apps/details?id=com.prndl.fphsdemo)

## Instructions to Make
1. Create a blank activity project with no navigation
  * Name your MainActivity `BankActivity`
  * If eclipse can't find your `AndroidManifest.xml`, highlight your project folder and hit refresh (F5)
2. Add UI Elements to your `activity_bank.xml`
  * Add a TextView and name it `balanceTextView`
  * Add an EditText and name it `amountTextField`
  * Change the input type of `amountTextField` to include `number` and `numberDecimal`
  * Add a Button and name it `depositButton`
  * Add a Button and name it `withdrawButton`
3. Add Event Listeners to your buttons
  * In your `activity_bank.xml` add the following code to your `<Button />` tags
  * Add `android:onClick="depositClicked"` to the `depositButton`
  * Add `android:onClick="withdrawClicked"` to the `withdrawButton`
  * Example Below:
  
```xml
    <Button
        android:id="@+id/depositButton"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignLeft="@+id/amountTextField"
        android:layout_below="@+id/amountTextField"
        android:layout_marginTop="15dp"
        android:onClick="depositClicked"
        android:text="Deposit" />

    <Button
        android:id="@+id/withdrawButton"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignBaseline="@+id/depositButton"
        android:layout_alignBottom="@+id/depositButton"
        android:layout_alignRight="@+id/amountTextField"
        android:onClick="withdrawClicked"
        android:text="Withdraw" />
```

  * Add the following code to your `BankActivity.java`
  
```java
	public void depositClicked(View v){
		Toast.makeText(getApplicationContext(), "Deposit Made",
				   Toast.LENGTH_SHORT).show();
	}
	public void withdrawClicked(View v){
		Toast.makeText(getApplicationContext(), "Withdraw Made",
				   Toast.LENGTH_SHORT).show();
	}
```

  * Press <kbd>Cmd</kbd>+<kbd>Shift</kbd>+<kbd>O</kbd> to import libraries
  * Build and Run - You should now see messages when you press your buttons.
4. Create a new `Class` named `Bank` and add the following code:

```java
/**
 * Bank
 * 
 * The Bank class is used to manage the amount of money the user has stored.
 * You can deposit, withdraw and view the bank amount with the Bank.
 */
import android.content.Context;
import android.content.SharedPreferences;

public class Bank {
	
	/*
	 * Set the amount of money in the bank
	 */
	private void setBalance(Context c, float balance){
		// Create an instance of the user preferences
		SharedPreferences userPreferences = c.getSharedPreferences("FPHS-Bank", Context.MODE_PRIVATE);
        // Create a preference editor
		SharedPreferences.Editor prefsEditor = userPreferences.edit();
		// Insert the balance into the user preferences
        prefsEditor.putFloat("balance", balance);
        // Save your changes
        prefsEditor.commit();
	}
	/*
	 * Get the amount of money in the bank
	 */
	public float getBalance(Context c){
		// Create an instance of the user preferences
		SharedPreferences userPreferences = c.getSharedPreferences("FPHS-Bank", Context.MODE_PRIVATE);
        // Request the balance from the user preferences. 
		// If the balance is not there give us zero instead
		float balance = userPreferences.getFloat("balance", 0.0f);
		// Return the balance
        return balance;
	}
	/*
	 * Deposit money into the bank
	 */
	public void deposit(Context c, float depositAmount){
		// Get the balance
		float balance = getBalance(c);
		// Increment the balance by the deposit amount
		balance += depositAmount;
		// Save the new balance
		setBalance(c,balance);
	}
	/*
	 * Withdraw Money from the bank
	 */
	public void withdraw(Context c, float withdrawAmount){
		// Get the balance
		float balance = getBalance(c);
		// Decrement the balance by the withdraw amount
		balance -= withdrawAmount;
		// Save the new balance
		setBalance(c,balance);
	}
}
```

5. Modify your `BankActivity.java`
  * Add two new methods:
  
```java
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
```

  * Update your button event listeners
  
```java
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
```

6. Congratulations!
  * Build and Run the final product. 
  * You should now be able to deposit and withdraw from the bank!
