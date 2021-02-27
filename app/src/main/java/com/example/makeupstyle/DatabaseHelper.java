package com.example.makeupstyle;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class DatabaseHelper extends SQLiteOpenHelper {
    String current;
    private static String DB_NAME = "makeup.db";
    private static String DB_PATH = "";
    private static final int DB_VERSION = 1;
    static SQLiteDatabase mDataBase;
    private final Context mContext;
    private boolean mNeedUpdate = false;

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        if (android.os.Build.VERSION.SDK_INT >= 17)
            DB_PATH = context.getApplicationInfo().dataDir + "/databases/";
        else
            DB_PATH = "/data/data/" + context.getPackageName() + "/databases/";
        this.mContext = context;

        current = mContext.getResources().getConfiguration().locale.toString();

        copyDataBase();

        this.getReadableDatabase();
    }

    public List<ModelClass> getDetails(int id) {
        List<ModelClass> arrayList = new ArrayList<>();
        mDataBase = this.getWritableDatabase();
        String query = "SELECT * FROM Photo WHERE makeup_id = ?";
        Cursor c = mDataBase.rawQuery(query, new String[]{Integer.toString(id)});

        while (c.moveToNext()) {
            arrayList.add(new ModelClass(c.getInt(0), c.getString(1)));
        }

        return arrayList;
    }

    public String[] getPersainSubName(int condition){
        Cursor c1 = mDataBase.rawQuery("SELECT * FROM SubcategoryPersain WHERE category_id = ?", new String[]{Integer.toString(condition)});
        String names[] = new String[c1.getCount()];
        int i = 0;
        while (c1.moveToNext()){
            names[i++] = c1.getString(1);
        }

        return names;
    }

    public List<ModelClass> getSubcategory(int condition) {
        List<ModelClass> arrayList = new ArrayList<>();
        mDataBase = this.getWritableDatabase();
        String query = "SELECT * FROM Sub_Category WHERE category_id = ?";
        Cursor c = mDataBase.rawQuery(query, new String[]{Integer.toString(condition)});
        while (c.moveToNext()){
            arrayList.add(new ModelClass(((current.equals("fa"))? getPersainSubName(condition)[c.getPosition()]
                    :c.getString(1)), c.getString(2), c.getInt(0)));
        }

        return arrayList;
    }
    public String[] getPersainMakeupName(int condition){
        Cursor c1 = mDataBase.rawQuery("SELECT * FROM DetailPersain WHERE subcategory_id = ?", new String[]{Integer.toString(condition)});
        String names[] = new String[c1.getCount()];
        int i = 0;
        while (c1.moveToNext()){
            names[i++] = c1.getString(1);
        }

        return names;
    }

    public String[] getPersainDetail(int condition){
        Cursor c1 = mDataBase.rawQuery("SELECT * FROM DetailPersain WHERE subcategory_id = ?", new String[]{Integer.toString(condition)});
        String detail[] = new String[c1.getCount()];
        int i = 0;
        while (c1.moveToNext()){
            detail[i++] = c1.getString(2);
        }

        return detail;
    }

    public List<ModelClass> getMakeup(int condition) {
        List<ModelClass> arrayList = new ArrayList<>();
        mDataBase = this.getWritableDatabase();
        String query = "SELECT * FROM Makeup WHERE sub_category_id = ?";
        Cursor c = mDataBase.rawQuery(query, new String[]{Integer.toString(condition)});

        while (c.moveToNext()) {
            arrayList.add(new ModelClass(c.getInt(0), ((current.equals("fa"))?
                    getPersainMakeupName(condition)[c.getPosition()]:c.getString(1)),
                    c.getString(4), ((current.equals("fa"))?
                    getPersainDetail(condition)[c.getPosition()]:c.getString(2))));
        }
        return arrayList;
    }

    public List<ModelClass> getPhotosTable() {
        List<ModelClass> arrayList = new ArrayList<>();
        mDataBase = this.getWritableDatabase();
        String query = "SELECT * FROM Makeup";
        Cursor c = mDataBase.rawQuery(query, null);

        while (c.moveToNext()) {
            arrayList.add(new ModelClass(c.getString(4), c.getInt(0)));
        }
        return arrayList;
    }


    public void updateDataBase() throws IOException {
        if (mNeedUpdate) {
            File dbFile = new File(DB_PATH + DB_NAME);
            if (dbFile.exists())
                dbFile.delete();

            copyDataBase();

            mNeedUpdate = false;
        }
    }

    public boolean checkDataBase() {
        File dbFile = new File(DB_PATH + DB_NAME);
        return dbFile.exists();
    }

    public void copyDataBase() {
        if (!checkDataBase()) {
            this.getReadableDatabase();
            this.close();
            try {
                copyDBFile();
            } catch (IOException mIOException) {
                throw new Error("ErrorCopyingDataBase");
            }
        }
    }

    private void copyDBFile() throws IOException {
        InputStream mInput = mContext.getAssets().open(DB_NAME);
        OutputStream mOutput = new FileOutputStream(DB_PATH + DB_NAME);
        byte[] mBuffer = new byte[1024];
        int mLength;
        while ((mLength = mInput.read(mBuffer)) > 0)
            mOutput.write(mBuffer, 0, mLength);
        mOutput.flush();
        mOutput.close();
        mInput.close();
    }

    public boolean openDataBase() throws SQLException {
        mDataBase = SQLiteDatabase.openDatabase(DB_PATH + DB_NAME, null, SQLiteDatabase.CREATE_IF_NECESSARY);
        return mDataBase != null;
    }


    @Override
    public synchronized void close() {
        if (mDataBase != null)
            mDataBase.close();
        super.close();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (newVersion > oldVersion)
            mNeedUpdate = true;
    }
}