package br.tcc.unicid.photostamp.model.DAL;

import java.util.ArrayList;
import br.tcc.unicid.photostamp.model.DTO.Photo;
import br.tcc.unicid.photostamp.model.DTO.Tag;

public class PhotoDB implements IPhotoDal {
	@Override
	public Photo GetByID(int id) {
		return null;
	}

	@Override
	public ArrayList<Photo> Get(int userID) {
		return null;
	}

	@Override
	public boolean Insert(Photo photo) {
		return false;
	}

	@Override
	public boolean Delete(int id, int userID) {
		return false;
	}

	@Override
	public boolean UpdateTag(int id, Tag tag) {
		return false;
	}
}