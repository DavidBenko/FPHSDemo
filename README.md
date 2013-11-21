FPHSDemo
========

Demo Android application for Forest Park High School.⋅⋅
User has a bank that they can deposit and withdraw money from. 

## Instructions to Make
1. Create a blank activity project with no navigation
⋅⋅* Name your MainActivity `BankActivity`
⋅⋅* If eclipse can't find your `AndroidManifest.xml`, highlight your project folder and hit refresh (F5)
2. Add UI Elements to your `activity_bank.xml`
⋅⋅* Add a Text View and name it `balanceTextView`
⋅⋅* Add a Text Field and name it `amountTextField`
⋅⋅* Change the input type of `amountTextField` to include `number` and `numberDecimal`
⋅⋅* Add a Button and name it `depositButton`
⋅⋅* Add a Button and name it `withdrawButton`
3. Add Event Listeners to your buttons
⋅⋅* In your `activity_bank.xml` add the following code to your `<Button />` tags
⋅⋅* Add `android:onClick="depositClicked"` to the `depositButton`
⋅⋅* Add `android:onClick="withdrawClicked"` to the `withdrawButton`
⋅⋅* Example Below:
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
⋅⋅* Add the following code to your `BankActivity.java`
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
⋅⋅* Press <kbd>Cmd</kbd>+<kbd>Shift</kbd>+<kbd>O</kbd> to import libraries
⋅⋅* Build and Run - You should now see messages when you press your buttons. 

