package com.example.a5alumno.adaptadoresdatos.data;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.net.Uri;

public class MyContentProvider extends ContentProvider {

    private static final String TAG = MyContentProvider.class.getSimpleName();
    private static final String PROVIDER_AUTHORITY = "com.example.a5alumno.adaptadoresdatos.data";
    public static final Uri CONTENT_URI = Uri.parse("content://" + MyContentProvider.PROVIDER_AUTHORITY);

    private MyDBHelper myDBHelper;

    public MyContentProvider() { }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        // Implement this to handle requests to delete one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public String getType(Uri uri) {
        // TODO: Implement this to handle requests for the MIME type of the data
        // at the given URI.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        SQLiteDatabase db = this.myDBHelper.getWritableDatabase();
        long regID = db.insert(ParamsDB.TABLE_NAME, null, values);

        return ContentUris.withAppendedId(MyContentProvider.CONTENT_URI, regID);
    }

    @Override
    public boolean onCreate() {
        this.myDBHelper = new MyDBHelper(this.getContext());
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        SQLiteDatabase db = this.myDBHelper.getReadableDatabase();
        return db.query(ParamsDB.TABLE_NAME, projection, selection, selectionArgs, null, null, sortOrder);
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        // TODO: Implement this to handle requests to update one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
