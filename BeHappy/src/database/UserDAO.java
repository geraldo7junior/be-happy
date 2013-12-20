package database;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class UserDAO {

	Context context;
	MyDbHelper dbHelper;
	SQLiteDatabase database;

	public UserDAO(Context context) {
		this.context = context;
		dbHelper = new MyDbHelper(context);
	}

	/**
	 * open a database that will be used for reading and writing.
	 */
	public void openDB() {
		database = dbHelper.getWritableDatabase();
	}

	/**
	 * to close Database
	 */
	public void closeDB() {
		dbHelper.close();
		database.close();
	}

	public void insertUser(String username, String password) {
		openDB();
		ContentValues contentValues = new ContentValues();
		contentValues.put("UserName", username);
		contentValues.put("Password", password);
		database.insert("UserTable", null, contentValues);
		closeDB();
	}

	public void deleteUser(int id) {
		openDB();
		database.delete("UserTable", "id " + " = " + id, null);
		closeDB();

	}

	public String getUser(int id) {
		openDB();
		Cursor cursor = database.query("UserTable", null, "id " + " = " + id,
				null, null, null, null);
		String name = null;
		cursor.moveToFirst();
		name = cursor.getString(1);

		closeDB();
		return name;
	}

	public ArrayList<String> getAllUser() {

		openDB();
		Cursor cursor = database.query("UserTable", null, null, null, null,
				null, null);
		ArrayList<String> userArrayList = new ArrayList<String>();
		cursor.moveToFirst();
		while (cursor.moveToNext()) {
			userArrayList.add(cursor.getString(1));
		}
		closeDB();

		return userArrayList;
	}

}
