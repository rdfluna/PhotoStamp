package br.tcc.unicid.photostamp.model.DAL;

import java.util.ArrayList;

import br.tcc.unicid.photostamp.model.DTO.Tag;

public class TagDB implements ITagDal {
	@Override
	public Tag GetByID(int id, int userID) {
		return null;
	}

	@Override
	public ArrayList<Tag> Get(int userID) {
		return null;
	}

	@Override
	public boolean Insert(Tag tag) {
		return false;
	}

	@Override
	public boolean Update(Tag tag) {
		return false;
	}

	@Override
	public boolean Delete(int id, int userID) {
		return false;
	}
}