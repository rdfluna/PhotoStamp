package br.tcc.unicid.photostamp.model.DAL;

import javax.inject.Inject;

import br.tcc.unicid.photostamp.model.DTO.Theme;

public class ThemeDB implements IThemeDal {
	private Database DB;

	@Inject
	public ThemeDB(Database DB){
		this.DB = DB;
	}

	@Override
	public Theme Get(int userID) {
		return null;
	}
}