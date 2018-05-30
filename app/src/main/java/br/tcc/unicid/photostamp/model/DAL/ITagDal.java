package br.tcc.unicid.photostamp.model.DAL;

import java.util.ArrayList;

import br.tcc.unicid.photostamp.model.DTO.Tag;

public interface ITagDal {
	Tag GetByID(int id);

	ArrayList<Tag> Get();

	boolean Insert(Tag tag);

	boolean Update(Tag tag);

	boolean Delete(int id);
}