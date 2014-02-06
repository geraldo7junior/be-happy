package database;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DependenteDAO {
	
		static final String DATABASE_NAME = "login.db";
		static final int DATABASE_VERSION = 1;
		public static final int NAME_COLUMN = 1;
		static final String DATABASE_CREATE = "create table "+"DEPENDENTE"+
		                             "( " +"ID"+" integer primary key autoincrement,"+ "NAME  text); ";
	
		public  SQLiteDatabase db;
		private final Context context;
		private MyDbHelper dbHelper;
		public  DependenteDAO(Context _context) {
			context = _context;
			dbHelper = new MyDbHelper(context, DATABASE_NAME, null, DATABASE_VERSION);
		}
		public  DependenteDAO open() throws SQLException {
			db = dbHelper.getWritableDatabase();
			return this;
		}
		public void close() {
			db.close();
		}

		public  SQLiteDatabase getDatabaseInstance(){
			return db;
		}

		public void insertEntry(String nome){
			
			ContentValues newValues = new ContentValues();
			newValues.put("NAME", nome);
			db.insert("DEPENDENTE", null, newValues);
		}
		public int deleteEntry(String nome){
			
		    String where="NAME=?";
		    int numberOFEntriesDeleted= db.delete("DEPENDENTE", where, new String[]{nome}) ;
	        return numberOFEntriesDeleted;
		}	
		/*public String getSinlgeEntry(String nome){
			
			Cursor cursor=db.query("DEPENDENTE", null, " NAME=?", new String[]{nome}, null, null, null);
	        if(cursor.getCount()<1) // UserName Not Exist
	        {
	        	cursor.close();
	        	return "NOT EXIST";
	        }
		    cursor.moveToFirst();
			String nome= cursor.getString(cursor.getColumnIndex("NAME"));
			cursor.close();
			return nome;				
		}*/
		public void  updateEntry(String nome){
			
			ContentValues updatedValues = new ContentValues();
			updatedValues.put("NAME", nome);
			
	        String where="NAME = ?";
		    db.update("DEPENDENTE",updatedValues, where, new String[]{nome});			   
		}		
}


