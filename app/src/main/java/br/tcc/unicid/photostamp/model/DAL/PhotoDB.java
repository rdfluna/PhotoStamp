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
	public int GetTotal() {
		connection = DB.getReadableDatabase();
		int total = 0;
		String selectQuery = "SELECT  COUNT(*) TOTAL FROM " + TABLE;

		Cursor cursor = connection.rawQuery(selectQuery, null);

		if (cursor != null) {
			if (cursor.moveToFirst()) {
				total = cursor.getInt(cursor.getColumnIndex("TOTAL"));
			}
		}
		connection.close();

		return total;
	}

	@Override
	public Photo GetByID(int id) {
		connection = DB.getReadableDatabase();

		String selectQuery = "SELECT  * FROM " + TABLE + " WHERE ID = " + id;

		Cursor cursor = connection.rawQuery(selectQuery, null);

		Photo photo = new Photo();
		if (cursor != null) {
			if (cursor.moveToFirst()) {
				photo.setID(id);
				photo.setExtention(cursor.getString(cursor.getColumnIndex("EXTENTION")));
				photo.setName(cursor.getString(cursor.getColumnIndex("NAME")));
				photo.setPath(cursor.getString(cursor.getColumnIndex("PATH")));
				photo.setSize(cursor.getInt(cursor.getColumnIndex("SIZE")));
				photo.setImage(cursor.getBlob(cursor.getColumnIndex("IMAGE")));
			}
		}
		connection.close();

		return photo;
	}

	@Override
	public Photo GetByPosition(int position) {
		connection = DB.getReadableDatabase();

		String selectQuery = "SELECT  * FROM " + TABLE + " LIMIT 1 OFFSET " + position;

		Cursor cursor = connection.rawQuery(selectQuery, null);

		Photo photo = new Photo();
		if (cursor != null) {
			if (cursor.moveToFirst()) {
				photo.setID(cursor.getInt(cursor.getColumnIndex("ID")));
				photo.setExtention(cursor.getString(cursor.getColumnIndex("EXTENTION")));
				photo.setName(cursor.getString(cursor.getColumnIndex("NAME")));
				photo.setPath(cursor.getString(cursor.getColumnIndex("PATH")));
				photo.setSize(cursor.getInt(cursor.getColumnIndex("SIZE")));
				photo.setImage(cursor.getBlob(cursor.getColumnIndex("IMAGE")));
			}
		}
		connection.close();

		return photo;
	}

	@Override
	public Photo GetWithoutTagByPosition(int position) {
		connection = DB.getReadableDatabase();

		String selectQuery = "SELECT P.* FROM " + TABLE + " P " +
				"LEFT JOIN PHOTOTAG PT ON P.ID = PT.PHOTOID " +
				"WHERE PT.ID IS NULL " +
				"LIMIT 1 OFFSET " + position;

		Cursor cursor = connection.rawQuery(selectQuery, null);

		Photo photo = new Photo();
		if (cursor != null) {
			if (cursor.moveToFirst()) {
				photo.setID(cursor.getInt(cursor.getColumnIndex("ID")));
				photo.setExtention(cursor.getString(cursor.getColumnIndex("EXTENTION")));
				photo.setName(cursor.getString(cursor.getColumnIndex("NAME")));
				photo.setPath(cursor.getString(cursor.getColumnIndex("PATH")));
				photo.setSize(cursor.getInt(cursor.getColumnIndex("SIZE")));
				photo.setImage(cursor.getBlob(cursor.getColumnIndex("IMAGE")));
			}
		}
		connection.close();

		return photo;
	}

	@Override
	public int GetTotalWithoutTag() {
		connection = DB.getReadableDatabase();
		int total = 0;

		String selectQuery = "SELECT COUNT(*) TOTAL FROM " + TABLE + " P " +
				"LEFT JOIN PHOTOTAG PT ON P.ID = PT.PHOTOID " +
				"WHERE PT.ID IS NULL ";

		Cursor cursor = connection.rawQuery(selectQuery, null);

		if (cursor != null) {
			if (cursor.moveToFirst()) {
				total = cursor.getInt(cursor.getColumnIndex("TOTAL"));
			}
		}
		connection.close();

		return total;
	}

	@Override
	public ArrayList<Photo> Get() {
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
				ph.setImage(cursor.getBlob(cursor.getColumnIndex("IMAGE")));

				photos.add(ph);
			} while (cursor.moveToNext());
		}
		connection.close();

		return photos;
	}

	@Override
	public int Insert(Photo photo) {
		ContentValues values;
		long result;
		connection = DB.getWritableDatabase();

		values = new ContentValues();
		values.put("NAME", photo.getName());
		values.put("SIZE", photo.getSize());
		values.put("EXTENTION", photo.getExtention());
		values.put("PATH", photo.getPath());
		values.put("IMAGE", photo.getImage());
		values.put("DATE", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));

		result = connection.insert(TABLE, null, values);

		String selectQuery = "SELECT  last_insert_rowid() ID";

		Cursor cursor = connection.rawQuery(selectQuery, null);

		if (cursor != null) {
			cursor.moveToFirst();
		}

		int id = cursor.getInt(cursor.getColumnIndex("ID"));
		connection.close();

		return  id;
	}

	@Override
	public boolean Delete(int id) {
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

	@Override
	public boolean DeleteTag(int id) {
		connection = DB.getReadableDatabase();
		int result = connection.delete("PHOTOTAG", "PHOTOID = " + id,null);
		connection.close();
		if(result != -1) {
			return  true;
		}
		else {
			return false;
		}
	}
}