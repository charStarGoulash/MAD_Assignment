package com.example.mobile_a1;
/*
Project:    Assignment1
Programmers: Divyangbhai, Attila, Tudor, Firas
Description: This is the third page. Primary function is to provide
              a receipt for the user

 */
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class ThirdActivity extends AppCompatActivity {
    private Button GoBackToPrevPage;
    private Button conBtn;
     DataBaseHelper theDBHelper;

    //hotel info
    private String hotel;
    private Integer price;
    private Long daysSpent;
    private String checkIn;
    private String checkout;
    private int numOfGuest;
    private int numOfRooms;

    private Double theHst;
    private Double thePriceWithTax;

    //labels
    private TextView hotelTxt;
    private TextView priceTxt;
    private TextView daysSpenttxt;
    private TextView checkInTxt;
    private TextView checkoutDatetxt;
    private TextView numOfGuesttxt;
    private TextView numberOfRoomtxt;
    private TextView hstTxt;
    private TextView priceWithTaxTxt;

    /*
    private TextView fNameTxt;
    private TextView lNameTxt;
    private TextView cNumberTxt;
    private TextView emailTxt;
    */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        theDBHelper = new DataBaseHelper (this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setTitle("Firago");
        widgets();
        readIntentInfo();
        SetPageValues();

        conBtn = (Button)findViewById(R.id.confirmBtn);

        conBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText tview = (EditText)findViewById(R.id.fName_txtBox);
                String firstName = tview.getText().toString();

                EditText tview2 = (EditText)findViewById(R.id.lName_txtBox);
                String lastName = tview2.getText().toString();

                if (firstName.length() == 0)
                {
                    tview.setError("Must Enter First Name");
                }
                else if (lastName.length() == 0)
                {
                    tview2.setError("Must Enter Last Name");
                }
                else
                {
            AddData(2, firstName );
            AddData(3, lastName );
            AddData(4, hotel );
            AddData(5, checkIn );
            AddData(6, checkout );
            AddData(7, String.valueOf(daysSpent));
            AddData(8, String.valueOf(numOfGuest));
            AddData(9, String.valueOf(numOfRooms) );
            AddData(10, String.valueOf(price) );
            AddData(11, String.valueOf(theHst) );
            AddData(12, String.valueOf(thePriceWithTax) );
           /* theDBHelper.addData(2, firstName );
            theDBHelper.addData(3, lastName );
            theDBHelper.addData(4, hotel );
            theDBHelper.addData(5, checkIn );
            theDBHelper.addData(6, checkout );
            theDBHelper.addData(7, String.valueOf(daysSpent));
            theDBHelper.addData(8, String.valueOf(numOfGuest));
            theDBHelper.addData(9, String.valueOf(numOfRooms) );
            theDBHelper.addData(10, String.valueOf(price) );
            theDBHelper.addData(11, String.valueOf(theHst) );
            theDBHelper.addData(12, String.valueOf(thePriceWithTax) );*/
                }

            }
        });
        
    }
    public void AddData (int COL, String newEntry)
    {
       boolean insertData = theDBHelper.addData(COL, newEntry);

       /*if (insertData)
       {
           Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_SHORT).show();
       }
       else
       {
           Toast.makeText(getApplicationContext(), "Fail", Toast.LENGTH_SHORT).show();
       }*/
    }

    /*
     * FUNCTION : widgets
     *
     * DESCRIPTION : Ties palette from xml to java
     *
     * PARAMETERS : None
     *
     * RETURNS : None
     */
    private void widgets()
    {
        hotelTxt= (TextView)findViewById(R.id.HotelNameValue);
        priceTxt= (TextView) findViewById(R.id.FinalPriceValue);
        daysSpenttxt= (TextView) findViewById(R.id.DaysValue);
        checkInTxt = (TextView) findViewById(R.id.checkInDate);
        checkoutDatetxt = (TextView) findViewById(R.id.checkOutDate);
        numOfGuesttxt = (TextView) findViewById(R.id.numOfGuest);
        numberOfRoomtxt = (TextView) findViewById(R.id.numOfRooms);
        hstTxt = (TextView) findViewById(R.id.hstValue);
        priceWithTaxTxt= (TextView) findViewById(R.id.priceWithTax);

    }
    /*
     * FUNCTION : readIntentInfo
     *
     * DESCRIPTION : Reads information from previous activity
     *
     * PARAMETERS : None
     *
     * RETURNS : None
     */
    private void readIntentInfo() {

        // get intent info
        Intent intent = getIntent();
        hotel = intent.getStringExtra("theHotel");
        price = intent.getIntExtra("fullPrice",0);
        daysSpent = intent.getLongExtra("numOfDays",0);
        checkIn=intent.getStringExtra("checkIn");
        checkout=intent.getStringExtra("checkOut");
        numOfGuest=intent.getIntExtra("numOfGuests", 0);
        numOfRooms= intent.getIntExtra("numOfRooms",0);

        theHst = price * .013;
        thePriceWithTax = price + theHst;



    }
    /*
     * FUNCTION : SetPageValues
     *
     * DESCRIPTION : sets text view values with values from previous activity
     *
     * PARAMETERS : None
     *
     * RETURNS : None
     */
    private void SetPageValues() {

        hotelTxt.setText(String.valueOf(hotel));
        priceTxt.setText("$ "+String.valueOf(price) );
        daysSpenttxt.setText(String.valueOf(daysSpent));
        checkInTxt.setText(String.valueOf(checkIn));
        checkoutDatetxt.setText(String.valueOf(checkout));
        numOfGuesttxt.setText(String.valueOf(numOfGuest));
        numberOfRoomtxt.setText(String.valueOf(numOfRooms));
        hstTxt.setText("$ "+ String.format("%.2f",theHst));
        priceWithTaxTxt.setText("$ "+String.format("%.2f",thePriceWithTax));

        numberOfRoomtxt.setText(String.valueOf(numOfRooms));;

    }
    public void confirmBtn_OnClick (View view)
    {
        EditText tview = (EditText)findViewById(R.id.fName_txtBox);
        String firstName = tview.getText().toString();

        EditText tview2 = (EditText)findViewById(R.id.lName_txtBox);
        String lastName = tview2.getText().toString();

        if (firstName.length() == 0)
        {
            tview.setError("Must Enter First Name");
        }
        else if (lastName.length() == 0)
        {
            tview2.setError("Must Enter Last Name");
        }
        else
        {
            /*AddData(2, firstName );
            AddData(3, lastName );
            AddData(4, hotel );
            AddData(5, checkIn );
            AddData(6, checkout );
            AddData(7, String.valueOf(daysSpent));
            AddData(8, String.valueOf(numOfGuest));
            AddData(9, String.valueOf(numOfRooms) );
            AddData(10, String.valueOf(price) );
            AddData(11, String.valueOf(theHst) );
            AddData(12, String.valueOf(thePriceWithTax) );
           /* theDBHelper.addData(2, firstName );
            theDBHelper.addData(3, lastName );
            theDBHelper.addData(4, hotel );
            theDBHelper.addData(5, checkIn );
            theDBHelper.addData(6, checkout );
            theDBHelper.addData(7, String.valueOf(daysSpent));
            theDBHelper.addData(8, String.valueOf(numOfGuest));
            theDBHelper.addData(9, String.valueOf(numOfRooms) );
            theDBHelper.addData(10, String.valueOf(price) );
            theDBHelper.addData(11, String.valueOf(theHst) );
            theDBHelper.addData(12, String.valueOf(thePriceWithTax) );*/
        }

    }

}
