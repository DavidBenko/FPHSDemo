/**
 * Bank
 * 
 * The Bank class is used to manage the amount of money the user has stored.
 * You can deposit, withdraw and view the bank amount with the Bank.
 */
package com.prndl.fphsdemo;

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
