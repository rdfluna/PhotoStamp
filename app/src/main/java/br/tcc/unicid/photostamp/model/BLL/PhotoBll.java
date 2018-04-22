package br.tcc.unicid.photostamp.model.BLL;

import java.util.ArrayList;
import javax.inject.Inject;
import br.tcc.unicid.photostamp.model.DAL.IPhotoDal;
import br.tcc.unicid.photostamp.model.DTO.Photo;
import br.tcc.unicid.photostamp.model.DTO.Tag;

public class PhotoBll {
	private IPhotoDal Dal;

	@Inject
	public PhotoBll(IPhotoDal dal) {
		this.Dal = dal;
	}

	public Photo GetByID(int id) {
		return Dal.GetByID(id);
	}

	public ArrayList<Photo> Get(int userID) {
		return Dal.Get(userID);
	}

	public boolean Insert(Photo photo) {
		return Dal.Insert(photo);
	}

	public boolean Delete(int id, int userID) {
		return Dal.Delete(id, userID);
	}

	public boolean UpdateTag(int id, Tag tag) {
		return Dal.UpdateTag(id, tag);
	}
}