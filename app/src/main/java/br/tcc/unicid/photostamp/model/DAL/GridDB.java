package br.tcc.unicid.photostamp.model.DAL;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.inject.Inject;

import br.tcc.unicid.photostamp.model.DTO.Grid;

public class GridDB implements IGridDal {
	private Database DB;
	private SQLiteDatabase connection;
	private final String TABLE = "GRID";

	@Inject
	public GridDB(Database DB){
		this.DB = DB;
	}
	@Override
	public Grid Get() {
		return null;
	}

	@Override
	public boolean Delete(int id) {
		return false;
	}

	@Override
	public boolean Update(Grid grid) {
		return false;
	}

	@Override
	public boolean Insert(Grid grid) {
		ContentValues values;
		long result;
		connection = DB.getWritableDatabase();

		values = new ContentValues();
		//values.put("NAME", grid.get());

		result = connection.insert(TABLE, null, values);
		connection.close();

		if(result == -1) {
			return  false;
		}
		else {
			return true;
		}
	}
}