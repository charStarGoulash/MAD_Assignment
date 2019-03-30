package com.example.mobile_a1;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DataBaseHelper extends SQLiteOpenHelper
{
    private static final String TAG = "DataBaseHelper";

    private static final String TABLE_NAME = "orders";
    private static final String COL1 = "ID";
    private static final String COL2 = "fname";
    private static final String COL3 = "lname";
    private static final String COL4 = "hotel";
    private static final String COL5 = "check_in";
    private static final String COL6 = "check_out";
    private static final String COL7 = "num_nights";
    private static final String COL8 = "num_guests";
    private static final String COL9 = "num_rooms";
    private static final String COL10 = "price";
    private static final String COL11 = "hst";
    private static final String COL12 = "full_price";

    public DataBaseHelper(Context context)
    {
        super(context, TABLE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String createTable = "CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL2 + " TEXT, " +
                COL3 + " TEXT, " +
                COL4 + " TEXT, " +
                COL5 + " TEXT, " +
                COL6 + " TEXT, " +
                COL7 + " INTEGER, " +
                COL8 + " INTEGER, " +
                COL9 + " TEXT, " +
                COL10 + " REAL, " +
                COL11 + " REAL, " +
                COL12 + " REAL)";

        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean addData(int COL, String item)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        switch(COL){
            case 2://first name
                contentValues.put(COL2, item);
                break;
            case 3://last name
                contentValues.put(COL3, item);
                break;
            case 4://hotel
                contentValues.put(COL4, item);
                break;
            case 5://checkin
                contentValues.put(COL5, item);
                break;
            case 6://checkout
                contentValues.put(COL6, item);
                break;
            case 7://numNights
                contentValues.put(COL7, item);
                break;
            case 8://numGuests
                contentValues.put(COL8, item);
                break;
            case 9://numRooms
                contentValues.put(COL9, item);
                break;
            case 10://price
                contentValues.put(COL10, item);
                break;
            case 11://hst
                contentValues.put(COL11, item);
                break;
            case 12://fullPrice
                contentValues.put(COL12, item);
                break;
            default: //For all other cases, do this        break;
        }

        //Log.d (TAG, "addData : Adding " + item + " to " + COL + " in " + TABLE_NAME);

        long result = db.insert(TABLE_NAME, null, contentValues);

        if (result == -1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
}
