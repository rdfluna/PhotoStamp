package br.tcc.unicid.photostamp.model.DAL;

import br.tcc.unicid.photostamp.model.DTO.Theme;

public interface IThemeDal {
	Theme Get(int userID);
}