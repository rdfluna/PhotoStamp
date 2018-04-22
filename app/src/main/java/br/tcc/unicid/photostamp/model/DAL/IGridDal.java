package br.tcc.unicid.photostamp.model.DAL;

import br.tcc.unicid.photostamp.model.DTO.Grid;

public interface IGridDal {
	Grid Get(int userID);

	boolean Insert(Grid grid);

	boolean Update(Grid grid);

	boolean Delete(int id, int userID);
}