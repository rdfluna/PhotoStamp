package br.tcc.unicid.photostamp.model.DAL;

import java.util.ArrayList;
import br.tcc.unicid.photostamp.model.DTO.Photo;
import br.tcc.unicid.photostamp.model.DTO.Tag;

public interface IPhotoDal {
	Photo GetByID(int id);

	ArrayList<Photo> Get(int userID);

	boolean Insert(Photo photo);

	boolean Delete(int id, int userID);

	boolean UpdateTag(int id, Tag tag);
}