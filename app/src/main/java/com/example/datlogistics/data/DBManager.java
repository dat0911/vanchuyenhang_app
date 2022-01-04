package com.example.datlogistics.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.media.Image;
import android.util.Log;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.example.datlogistics.model.Student;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chien on 4/8/17.
 */

public class DBManager extends SQLiteOpenHelper {
    private final String TAG = "DBManager";
    private static final String DATABASE_NAME = "logistic_manager";
    private static final String TABLE_NAME = "logistic";
    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String ADDRESS = "address";
    private static final String PHONE_NUMBER = "phone";
    private static final String EMAIL = "email";
    private static final String HINHTHUC = "hinhthuc";
    private static final String LOAIHANG ="loaihang";
    private static final String TRONGLUONG ="trongluong";
    private static final String NGAYXUATCANG ="ngayxuatcang";
    private static final String NGAYNHAPCANG ="ngaynhapcang";
    private static final String TINHTRANGKIENHANG ="tinhtrangkienhang";

    private static int VERSION = 1;


    private Context context;
    private String SQLQuery = "CREATE TABLE " + TABLE_NAME + " (" +
            ID + " integer primary key, " +
            NAME + " TEXT, " +
            EMAIL + " TEXT, " +
            PHONE_NUMBER + " TEXT, " +
            ADDRESS + " TEXT, " +
            HINHTHUC +" TEXT, " +
            LOAIHANG + " TEXT, " +
            TRONGLUONG + " TEXT, " +
            NGAYXUATCANG + " TEXT, " +
            NGAYNHAPCANG + " TEXT)"
            ;


    public DBManager(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
        this.context = context;
        Log.d(TAG, "DBManager: ");
    }

    public DBManager(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQLQuery);
        Log.d(TAG, "onCreate: ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // If you need to add a column
        if (newVersion > oldVersion) {
            db.execSQL("ALTER TABLE foo ADD COLUMN ANH Cbl DEFAULT 0");
        }
    }


    public void addStudent(Student student) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAME, student.getmName());
        values.put(ADDRESS, student.getmAddress());
        values.put(PHONE_NUMBER, student.getmPhoneNumber());
        values.put(EMAIL, student.getmEmail());
        values.put(HINHTHUC, student.getmHinhthuc());
        values.put(LOAIHANG, student.getmLoaihang());
        values.put(TRONGLUONG, student.getmTrongluong());
        values.put(NGAYXUATCANG, student.getmNgayxuatcang());
        values.put(NGAYNHAPCANG, student.getmNgaynhapcang());

        db.insert(TABLE_NAME, null, values);
        db.close();
        Log.d(TAG, "addStudent Successfuly");
    }

    public List<Student> getAllStudent() {
        List<Student> listStudent = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery,null);
        if (cursor.moveToFirst()) {
            do {
                Student student = new Student();
                student.setmID(cursor.getInt(0));
                student.setmName(cursor.getString(1)+"");
                student.setmEmail(cursor.getString(2));
                student.setmPhoneNumber(cursor.getString(3));
                student.setmAddress(cursor.getString(4));
                student.setmHinhthuc(cursor.getString(5) );
                student.setmLoaihang(cursor.getString(6) );
                student.setmTrongluong(cursor.getString(7));
                student.setmNgayxuatcang(cursor.getString(8));
                student.setmNgaynhapcang(cursor.getString(9));

                listStudent.add(student);
            } while (cursor.moveToNext());
        }
        db.close();
    return listStudent;
    }
    public int updateStudent(Student student){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME,student.getmName());
        contentValues.put(ADDRESS,student.getmAddress());
        contentValues.put(EMAIL,student.getmEmail());
        contentValues.put(PHONE_NUMBER,student.getmPhoneNumber());
        contentValues.put(HINHTHUC,student.getmHinhthuc());
        contentValues.put(LOAIHANG,student.getmLoaihang());
        contentValues.put(TRONGLUONG,student.getmTrongluong());
        contentValues.put(NGAYXUATCANG,student.getmNgayxuatcang());
        contentValues.put(NGAYNHAPCANG,student.getmNgaynhapcang());

        return db.update(TABLE_NAME,contentValues,ID+"=?",new String[]{String.valueOf(student.getmID())});
    }
    public int deleteStudent(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME,ID+"=?",new String[] {String.valueOf(id)});
    }
    public byte[] ImageView_To_Byte(ImageView h){
        BitmapDrawable drawable =(BitmapDrawable) h.getDrawable();
        Bitmap bitmap = drawable.getBitmap();

        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG,100, stream);
        byte[] byteArray = stream.toByteArray();
        return byteArray;
    }

}
