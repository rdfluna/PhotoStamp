package br.tcc.unicid.photostamp.model.BLL;

import javax.inject.Inject;
import br.tcc.unicid.photostamp.model.DAL.IGalleryWallDal;
import br.tcc.unicid.photostamp.model.DTO.GalleryWall;

public class GalleryWallBll {
	private IGalleryWallDal Dal;

	@Inject
	public GalleryWallBll(IGalleryWallDal dal) {
		this.Dal = dal;
	}

	public GalleryWall Get() {
		return Dal.Get();
	}

	public boolean Insert(GalleryWall gallery) {
		return Dal.Insert(gallery);
	}

	public boolean Update(GalleryWall gallery) {
		return Dal.Update(gallery);
	}

	public boolean Delete(int id) {
		return Dal.Delete(id);
	}
}