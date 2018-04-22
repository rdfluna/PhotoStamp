package br.tcc.unicid.photostamp.model.BLL;

import javax.inject.Inject;
import br.tcc.unicid.photostamp.model.DAL.IGridDal;
import br.tcc.unicid.photostamp.model.DTO.Grid;

public class GridBll {
	private IGridDal Dal;

	@Inject
	public GridBll(IGridDal dal) {
		this.Dal = dal;
	}

	public Grid Get(int userID) {
		return Dal.Get(userID);
	}

	public boolean Insert(Grid grid) {
		return Dal.Insert(grid);
	}

	public boolean Update(Grid grid) {
		return Dal.Update(grid);
	}

	public boolean Delete(int id, int userID) {
		return Dal.Delete(id, userID);
	}
}