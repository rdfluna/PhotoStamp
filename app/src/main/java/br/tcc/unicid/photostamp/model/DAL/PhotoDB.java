package br.tcc.unicid.photostamp.model.DAL;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import br.tcc.unicid.photostamp.model.DTO.Photo;
import br.tcc.unicid.photostamp.model.DTO.Tag;

public class PhotoDB implements IPhotoDal {
	private Database DB;
	private SQLiteDatabase connection;
	private final String TABLE = "PHOTO";

	@Inject
	public PhotoDB(Database DB){
		this.DB = DB;
	}

	@Override
	public Photo GetByID(int id) {
		connection = DB.getReadableDatabase();

		String selectQuery = "SELECT  * FROM " + TABLE + " WHERE ID = " + id;

		Cursor cursor = connection.rawQuery(selectQuery, null);

		if (cursor != null) {
			cursor.moveToFirst();
		}

		Photo photo = new Photo();
		photo.setID(id);
		photo.setExtention(cursor.getString(cursor.getColumnIndex("EXTENTION")));
		photo.setName(cursor.getString(cursor.getColumnIndex("NAME")));
		photo.setPath(cursor.getString(cursor.getColumnIndex("PATH")));
		photo.setSize(cursor.getInt(cursor.getColumnIndex("SIZE")));

		return photo;
	}

	@Override
	public ArrayList<Photo> Get(int userID) {
		ArrayList<Photo> photos = new ArrayList<Photo>();
		String selectQuery = "SELECT  * FROM " + TABLE;

		SQLiteDatabase connection = DB.getReadableDatabase();
		Cursor cursor = connection.rawQuery(selectQuery, null);

		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {
				Photo ph = new Photo();
				ph.setID(cursor.getInt(cursor.getColumnIndex("ID")));
				ph.setExtention(cursor.getString(cursor.getColumnIndex("EXTENTION")));
				ph.setName(cursor.getString(cursor.getColumnIndex("NAME")));
				ph.setPath(cursor.getString(cursor.getColumnIndex("PATH")));
				ph.setSize(cursor.getInt(cursor.getColumnIndex("SIZE")));

				photos.add(ph);
			} while (cursor.moveToNext());
		}

		return photos;
	}

	@Override
	public boolean Insert(Photo photo) {
		ContentValues values;
		long result;
		connection = DB.getWritableDatabase();

		values = new ContentValues();
		values.put("NAME", photo.getName());
		values.put("SIZE", photo.getSize());
		values.put("EXTENTION", photo.getExtention());
		values.put("PATH", photo.getPath());
		values.put("DATE", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));

		result = connection.insert(TABLE, null, values);
		connection.close();

		if(result == -1) {
			return  false;
		}
		else {
			return true;
		}
	}

	@Override
	public boolean Delete(int id, int userID) {
		connection = DB.getReadableDatabase();
		int result = connection.delete(TABLE, "ID = " + id,null);
		connection.close();
		if(result != -1) {
			return  true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean UpdateTag(int id, Tag tag) {
		ContentValues values;
		long result;
		connection = DB.getWritableDatabase();

		values = new ContentValues();
		values.put("TAGID", tag.getID());
		values.put("PHOTOID", id);

		result = connection.insert("PHOTOTAG", null, values);
		connection.close();

		if(result == -1) {
			return  false;
		}
		else {
			return true;
		}
	}
}