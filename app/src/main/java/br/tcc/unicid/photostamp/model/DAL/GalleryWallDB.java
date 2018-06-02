package br.tcc.unicid.photostamp.model.DAL;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import javax.inject.Inject;

import br.tcc.unicid.photostamp.model.DTO.GalleryWall;

public class GalleryWallDB implements IGalleryWallDal {
	private Database DB;
	private SQLiteDatabase connection;
	private final String TABLE = "GALLERYWALL";

	@Inject
	public GalleryWallDB(Database DB){
		this.DB = DB;
	}

	@Override
	public GalleryWall Get() {
		return null;
	}

	@Override
	public boolean Insert(GalleryWall gallery) {
		return false;
	}

	@Override
	public boolean Update(GalleryWall gallery) {
		return false;
	}

	@Override
	public boolean Delete(int id) {
		return false;
	}
}