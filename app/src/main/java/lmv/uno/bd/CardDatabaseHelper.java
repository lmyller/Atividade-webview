package lmv.uno.bd;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import lmv.uno.ImageNameMapper;
import lmv.uno.modelo.Carta;
import lmv.uno.modelo.CartaComum;

public class CardDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "card_database";
    private static final int DATABASE_VERSION = 1;

    // Table name
    private static final String TABLE_CARDS = "cards";

    // Columns
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_COLOR = "color";
    private static final String COLUMN_IMAGE_RESOURCE_ID = "image_resource_id";

    private static final String COLUMN_IS_SORTED = "is_sorted";

    private static final String CREATE_TABLE_CARDS =
            "CREATE TABLE " + TABLE_CARDS + "(" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    COLUMN_COLOR + " INTEGER," +
                    COLUMN_IMAGE_RESOURCE_ID + " INTEGER," +
                    COLUMN_IS_SORTED + " INTEGER DEFAULT 0" +
                    ")";

    public CardDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_CARDS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public long addCard(int color, int imageResourceId) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_COLOR, color);
        values.put(COLUMN_IMAGE_RESOURCE_ID, imageResourceId);
        long id = db.insert(TABLE_CARDS, null, values);
        db.close();
        return id;
    }

    public void markCardAsSorted(long cardId) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_IS_SORTED, 1); // Marking the card as sorted
        String whereClause = COLUMN_ID + " = ?";
        String[] whereArgs = {String.valueOf(cardId)};
        db.update(TABLE_CARDS, values, whereClause, whereArgs);
        db.close();
    }

    public boolean isCardSorted(long cardId) {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] projection = {COLUMN_IS_SORTED};
        String selection = COLUMN_ID + " = ?";
        String[] selectionArgs = {String.valueOf(cardId)};
        Cursor cursor = db.query(TABLE_CARDS, projection, selection, selectionArgs, null, null, null);

        boolean isSorted = false;

        if (cursor.moveToFirst()) {
            isSorted = cursor.getInt(cursor.getColumnIndex(COLUMN_IS_SORTED)) == 1;
        }
        Log.d("Teste", String.valueOf(isSorted));
        cursor.close();
        return isSorted;
    }

    public Carta getCardById(long cardId) {
        if (isCardSorted(cardId))
            return null;

        SQLiteDatabase db = this.getReadableDatabase();
        String[] projection = {COLUMN_ID, COLUMN_COLOR, COLUMN_IMAGE_RESOURCE_ID};
        String selection = COLUMN_ID + " = ?";
        String[] selectionArgs = {String.valueOf(cardId)};
        Cursor cursor = db.query(TABLE_CARDS, projection, selection, selectionArgs, null, null, null);

        Carta carta = null;

        if (cursor.moveToFirst()) {
            int color = cursor.getInt(cursor.getColumnIndex(COLUMN_COLOR));
            int imageResourceId = cursor.getInt(cursor.getColumnIndex(COLUMN_IMAGE_RESOURCE_ID));

            carta = new CartaComum(color, imageResourceId, 0);
        }

        cursor.close();
        return carta;
    }

    public Cursor getAllCards() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.query(TABLE_CARDS, null, null, null, null, null, null);
    }

    public List<String> getAllSortedCardImageNames(Context context) {
        List<String> sortedCardImageNames = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String[] projection = {COLUMN_IMAGE_RESOURCE_ID};
        String selection = COLUMN_IS_SORTED + " = ?";
        String[] selectionArgs = {"1"}; // 1 means sorted
        Cursor cursor = db.query(TABLE_CARDS, projection, selection, selectionArgs, null, null, null);

        if (cursor.moveToFirst()) {
            do {
                int imageResourceId = cursor.getInt(cursor.getColumnIndex(COLUMN_IMAGE_RESOURCE_ID));
                String imageName = ImageNameMapper.getImageName(context, imageResourceId);
                sortedCardImageNames.add(imageName);
            } while (cursor.moveToNext());
        }

        cursor.close();
        return sortedCardImageNames;
    }

    public void resetIsSorted() {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_IS_SORTED, 0); // Set is sorted to 0

        db.update(TABLE_CARDS, values, null, null);
    }

}
