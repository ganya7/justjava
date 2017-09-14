package com.example.android.justjava;
/*
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}

/**
 * IMPORTANT: Add your package below. Package name can be found in the project's AndroidManifest.xml file.
 * This is the package name our example uses:
 *
 * package com.example.android.justjava;
 *
 */


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
//        Log.v("MainActivity","The price is",quantity);
        /*CheckBox wCream = (CheckBox) findViewById(R.id.whipcream);
        if (wCream.isChecked()) {
            displayMessage(createOrderSummary());
        }*/
       /* displayMessage(createOrderSummary());
        displayQuantity(quantity);*/
        //displayPrice(quantity * 5);
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "he");
        intent.putExtra(Intent.EXTRA_TEXT, createOrderSummary());
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.qty);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    public void increment(View view) {
        quantity++;
        displayQuantity(quantity);
    }

    public void decrement(View view) {
        quantity--;
        displayQuantity(quantity);
    }

    private void displayMessage(String message) {
        TextView messageTextView = (TextView) findViewById(R.id.price);
        messageTextView.setText(message);
    }

    private boolean hascream() {
        CheckBox wCream = (CheckBox) findViewById(R.id.whipcream);
        return wCream.isChecked();
    }

    private String getName() {
        EditText e = (EditText) findViewById(R.id.name);
        return e.getText().toString();
    }

    private boolean hasChoc() {
        CheckBox choco = (CheckBox) findViewById(R.id.choc);
        return choco.isChecked();
    }

    private String createOrderSummary() {
        String message = "Name: " + getName();
        message += "\nWhipped Cream: " + hascream();
        message += "\nChocolate: " + hasChoc();
        message += "\nQuantity: " + quantity;
        message += "\nTotal: " + NumberFormat.getCurrencyInstance().format(calcPrice(hascream(), hasChoc()));
        return message;
    }

    private int calcPrice(boolean wc, boolean choc) {
        if (wc && choc)
            return quantity * 5 + 1 + 2;
        else if (wc)
            return quantity * 5 + 1;
        else if (choc)
            return quantity * 5 + 2;
        else
            return quantity * 5;
    }
}
