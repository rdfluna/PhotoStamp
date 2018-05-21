package br.tcc.unicid.photostamp.model.DAL;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper {
    private final String LOG = Database.class.getName();
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "PhotoStamp";
    private final String DATABASE_DELETE_THEME = "DROP TABLE IF EXISTS THEME; ";
    private final String DATABASE_DELETE_USER = "DROP TABLE IF EXISTS USER; ";
    private final String DATABASE_DELETE_PHOTO = "DROP TABLE IF EXISTS PHOTO; ";
    private final String DATABASE_DELETE_TAG = "DROP TABLE IF EXISTS TAG; ";
    private final String DATABASE_DELETE_PHOTOTAG = "DROP TABLE IF EXISTS PHOTOTAG; ";
    private final String DATABASE_DELETE_GRID = "DROP TABLE IF EXISTS GRID";

    private final String DATABASE_CREATE_THEME = "CREATE TABLE THEME (" +
            "	ID INTEGER PRIMARY KEY AUTOINCREMENT," +
            "	NAME VARCHAR(100)," +
            "	COLOR VARCHAR(100)" +
            ");";
    private final String DATABASE_CREATE_USER = "CREATE TABLE USER (" +
            "	ID INTEGER PRIMARY KEY AUTOINCREMENT," +
            "	NAME VARCHAR(100)," +
            "	EMAIL VARCHAR(100)," +
            "	PASSWORD CHAR(32)," +
            "	THEMEID INTEGER," +
            "	FOREIGN KEY(THEMEID) REFERENCES THEME(ID)" +
            ");";
    private final String DATABASE_CREATE_PHOTO = "CREATE TABLE PHOTO (" +
            "	ID INTEGER PRIMARY KEY AUTOINCREMENT," +
            "	NAME VARCHAR(100)," +
            "	PATH VARCHAR(100)," +
            "	EXTENTION VARCHAR(10)," +
            "	SIZE INTEGER," +
            "	DATE DATETIME" +
            ");";
    private final String DATABASE_CREATE_TAG = "CREATE TABLE TAG (" +
            "	ID INTEGER PRIMARY KEY AUTOINCREMENT," +
            "	NAME VARCHAR(100)," +
            "	DATE DATETIME" +
            ");";
    private final String DATABASE_CREATE_PHOTOTAG = "CREATE TABLE PHOTOTAG (" +
            "	ID INTEGER PRIMARY KEY AUTOINCREMENT," +
            "	TAGID INTEGER," +
            "	PHOTOID INTEGER," +
            "	FOREIGN KEY(TAGID) REFERENCES TAG(ID)," +
            "	FOREIGN KEY(PHOTOID) REFERENCES PHOTO(ID)" +
            ");";
    private final String DATABASE_CREATE_GRID = "CREATE TABLE GRID (" +
            "	ID INTEGER PRIMARY KEY AUTOINCREMENT," +
            "	TAGID INTEGER," +
            "	PHOTOID INTEGER," +
            "	RANK INTEGER," +
            "	FOREIGN KEY(TAGID) REFERENCES TAG(ID)," +
            "	FOREIGN KEY(PHOTOID) REFERENCES PHOTO(ID)" +
            ");";

    public Database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE_THEME);
        db.execSQL(DATABASE_CREATE_USER);
        db.execSQL(DATABASE_CREATE_PHOTO);
        db.execSQL(DATABASE_CREATE_TAG);
        db.execSQL(DATABASE_CREATE_PHOTOTAG);
        db.execSQL(DATABASE_CREATE_GRID);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DATABASE_DELETE_THEME);
        db.execSQL(DATABASE_DELETE_USER);
        db.execSQL(DATABASE_DELETE_PHOTO);
        db.execSQL(DATABASE_DELETE_TAG);
        db.execSQL(DATABASE_DELETE_PHOTOTAG);
        db.execSQL(DATABASE_DELETE_GRID);
        onCreate(db);
    }
}