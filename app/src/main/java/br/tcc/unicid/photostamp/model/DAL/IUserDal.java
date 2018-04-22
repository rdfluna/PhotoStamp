package br.tcc.unicid.photostamp.model.DAL;


import br.tcc.unicid.photostamp.model.DTO.GalleryWall;
import br.tcc.unicid.photostamp.model.DTO.Grid;
import br.tcc.unicid.photostamp.model.DTO.Theme;
import br.tcc.unicid.photostamp.model.DTO.User;

public interface IUserDal {
	User Get(int id);

	boolean Insert(User user);

	boolean Update(User user);

	boolean Delete(int id, int userID);

	boolean UpdateTheme(int id, Theme theme);

	boolean UpdateGrid(int id, Grid grid);

	boolean UpdateGalleryWall(int id, GalleryWall gallery);
}