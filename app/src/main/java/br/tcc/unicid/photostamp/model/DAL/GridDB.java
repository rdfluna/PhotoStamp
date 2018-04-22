package br.tcc.unicid.photostamp.model.DAL;

import br.tcc.unicid.photostamp.model.DTO.Grid;

public class GridDB implements IGridDal {

	@Override
	public Grid Get(int userID) {
		return null;
	}

	@Override
	public boolean Delete(int id, int userID) {
		return false;
	}

	@Override
	public boolean Update(Grid grid) {
		return false;
	}

	@Override
	public boolean Insert(Grid grid) {
		return false;
	}
}