package br.tcc.unicid.photostamp.model.DAL;

import javax.inject.Inject;

import br.tcc.unicid.photostamp.model.DTO.GalleryWall;
import br.tcc.unicid.photostamp.model.DTO.Grid;
import br.tcc.unicid.photostamp.model.DTO.Theme;
import br.tcc.unicid.photostamp.model.DTO.User;

public class UserDB implements IUserDal {
	private Database DB;

	@Inject
	public UserDB(Database DB){
		this.DB = DB;
	}

	@Override
	public User Get(int id) {
		return null;
	}

	@Override
	public boolean Insert(User user) {
		return false;
	}

	@Override
	public boolean Update(User user) {
		return false;
	}

	@Override
	public boolean Delete(int id) {
        return  false;
	}

	@Override
	public boolean UpdateTheme(int id, Theme theme) {
		return false;
	}

	@Override
	public boolean UpdateGrid(int id, Grid grid) {
		return false;
	}

	@Override
	public boolean UpdateGalleryWall(int id, GalleryWall gallery) {
		return false;
	}
}