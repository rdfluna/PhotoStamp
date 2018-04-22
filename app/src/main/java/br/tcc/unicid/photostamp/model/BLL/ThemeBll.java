package br.tcc.unicid.photostamp.model.BLL;

import javax.inject.Inject;
import br.tcc.unicid.photostamp.model.DAL.IThemeDal;
import br.tcc.unicid.photostamp.model.DTO.Theme;

public class ThemeBll {
	private IThemeDal Dal;

	@Inject
	public ThemeBll(IThemeDal dal) {
		this.Dal = dal;
	}

	public Theme Get(int userID) {
		return Dal.Get(userID);
	}
}