package br.tcc.unicid.photostamp.model.BLL;

import javax.inject.Inject;
import br.tcc.unicid.photostamp.model.DAL.IUserDal;
import br.tcc.unicid.photostamp.model.DTO.*;

public class UserBll {
	private IUserDal Dal;

	@Inject
	public UserBll(IUserDal dal) {
		this.Dal = dal;
	}

	public User Get(int id) {
		return Dal.Get(id);
	}

	public boolean Insert(User user) {
		return Dal.Insert(user);
	}

	public boolean Update(User user) {
		return Dal.Update(user);
	}

	public boolean Delete(int id, int userID) {
		return Dal.Delete(id, userID);
	}

	public boolean UpdateTheme(int id, Theme theme) {
		return Dal.UpdateTheme(id, theme);
	}

	public boolean UpdateGrid(int id, Grid grid) {
		return Dal.UpdateGrid(id, grid);
	}

	public boolean UpdateGalleryWall(int id, GalleryWall gallery) {
		return Dal.UpdateGalleryWall(id, gallery);
	}
}