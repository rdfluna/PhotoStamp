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

	public Grid Get() {
		return Dal.Get();
	}

	public boolean Insert(Grid grid) {
		return Dal.Insert(grid);
	}

	public boolean Update(Grid grid) {
		return Dal.Update(grid);
	}

	public boolean Delete(int id) {
		return Dal.Delete(id);
	}
}