package br.tcc.unicid.photostamp.model.DAL;

import java.util.ArrayList;

import br.tcc.unicid.photostamp.model.DTO.Tag;

public interface ITagDal {
	Tag GetByID(int id);

	Tag GetByName(String name);

	ArrayList<Tag> GetByPhotoID(int id);

	ArrayList<Tag> Get();

	int Insert(Tag tag);

	boolean Update(Tag tag);

	boolean Delete(int id);
}