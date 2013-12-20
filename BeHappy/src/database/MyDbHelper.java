package database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDbHelper extends SQLiteOpenHelper {
	public static final String MYDB_NAME = "mySqlDb";
	public static final int MYDB_VER = 1;

	public MyDbHelper(Context context) {
		super(context, MYDB_NAME, null, MYDB_VER);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String qurey = "Create Table UserTable(id integer PRIMARY KEY AUTOINCREMENT, UserName text,Password text); ";
		db.execSQL(qurey);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

	}

}
