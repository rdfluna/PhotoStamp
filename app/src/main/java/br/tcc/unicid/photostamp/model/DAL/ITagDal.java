package br.tcc.unicid.photostamp.model.DAL;

import java.util.ArrayList;

import br.tcc.unicid.photostamp.model.DTO.Tag;

public interface ITagDal {
	Tag GetByID(int id, int userID);

	ArrayList<Tag> Get(int userID);

	boolean Insert(Tag tag);

	boolean Update(Tag tag);

	boolean Delete(int id, int userID);
}