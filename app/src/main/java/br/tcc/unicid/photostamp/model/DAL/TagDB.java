package br.tcc.unicid.photostamp.model.DAL;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.inject.Inject;

import br.tcc.unicid.photostamp.model.DTO.Photo;
import br.tcc.unicid.photostamp.model.DTO.Tag;

public class TagDB implements ITagDal {
	private Database DB;
	private SQLiteDatabase connection;
	private final String TABLE = "TAG";

	@Inject
	public TagDB(Database DB){
		this.DB = DB;
	}

	@Override
	public Tag GetByID(int id) {
		connection = DB.getReadableDatabase();

		String selectQuery = "SELECT  * FROM " + TABLE + " WHERE ID = " + id;

		Cursor cursor = connection.rawQuery(selectQuery, null);

		Tag tag = new Tag();
		if (cursor != null) {
			if (cursor.moveToFirst()) {
				tag.setID(id);
				tag.setName(cursor.getString(cursor.getColumnIndex("NAME")));
			}
		}
		connection.close();

		return tag;
	}

	@Override
	public Tag GetByName(String name) {
		connection = DB.getReadableDatabase();

		String selectQuery = "SELECT  * FROM " + TABLE + " WHERE NAME = '" + name + "'";

		Cursor cursor = connection.rawQuery(selectQuery, null);

		Tag tag = new Tag();
		if (cursor != null) {
			if (cursor.moveToFirst()) {
				tag.setID(cursor.getInt(cursor.getColumnIndex("ID")));
				tag.setName(name);
			}
		}

		connection.close();

		return tag;
	}

	@Override
	public ArrayList<Tag> GetByPhotoID(int id) {
		connection = DB.getReadableDatabase();

		String selectQuery = "SELECT T.* FROM " + TABLE + " T " +
				"INNER JOIN PHOTOTAG PT ON T.ID = PT.TAGID " +
				"WHERE PT.PHOTOID = " + id + " ";

		Cursor cursor = connection.rawQuery(selectQuery, null);

		ArrayList<Tag> tags = new ArrayList<Tag>();
		if (cursor != null && cursor.moveToFirst()) {
			do {
				Tag t = new Tag();
				t.setID(id);
				t.setName(cursor.getString(cursor.getColumnIndex("NAME")));

				tags.add(t);
			} while (cursor.moveToNext());
		}
		connection.close();

		return tags;
	}

	@Override
	public ArrayList<Tag> Get() {
		ArrayList<Tag> tags = new ArrayList<Tag>();
		String selectQuery = "SELECT  * FROM " + TABLE;

		SQLiteDatabase connection = DB.getReadableDatabase();
		Cursor cursor = connection.rawQuery(selectQuery, null);

		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {
				Tag t = new Tag();
				t.setID(cursor.getInt(cursor.getColumnIndex("ID")));
				t.setName(cursor.getString(cursor.getColumnIndex("NAME")));

				tags.add(t);
			} while (cursor.moveToNext());
		}
		connection.close();

		return tags;
	}

	@Override
	public int Insert(Tag tag) {
		ContentValues values;
		long result;
		connection = DB.getWritableDatabase();

		values = new ContentValues();
		values.put("NAME", tag.getName());
		values.put("DATE", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));

		result = connection.insert(TABLE, null, values);

		String selectQuery = "SELECT  last_insert_rowid() ID";

		Cursor cursor = connection.rawQuery(selectQuery, null);

		if (cursor != null) {
			cursor.moveToFirst();
		}

		int id = cursor.getInt(cursor.getColumnIndex("ID"));
		connection.close();

		return id;
	}

	@Override
	public boolean Update(Tag tag) {
		ContentValues values;
		long result;
		connection = DB.getWritableDatabase();

		values = new ContentValues();
		values.put("NAME", tag.getName());

		result = connection.update(TABLE, values, "ID = " + tag.getID(), null);
		connection.close();

		if(result == -1) {
			return  false;
		}
		else {
			return true;
		}
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
}