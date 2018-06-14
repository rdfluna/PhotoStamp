package br.tcc.unicid.photostamp.model.DAL;

import java.util.ArrayList;
import br.tcc.unicid.photostamp.model.DTO.Photo;
import br.tcc.unicid.photostamp.model.DTO.Tag;

public interface IPhotoDal {
	int GetTotal();

	Photo GetByID(int id);

	Photo GetByPosition(int position);

	Photo GetWithoutTagByPosition(int position);

	int GetTotalWithoutTag();

	ArrayList<Photo> Get();

	ArrayList<Photo> Get(String[] tagsID, boolean desc, boolean orderDate);

	int Insert(Photo photo);

	boolean Delete(int id);

	boolean UpdateTag(int id, Tag tag);

	boolean DeleteTag(int id);
}