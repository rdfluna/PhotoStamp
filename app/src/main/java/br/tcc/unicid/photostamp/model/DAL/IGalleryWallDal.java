package br.tcc.unicid.photostamp.model.DAL;

import br.tcc.unicid.photostamp.model.DTO.GalleryWall;

public interface IGalleryWallDal {
	GalleryWall Get();

	boolean Insert(GalleryWall gallery);

	boolean Update(GalleryWall gallery);

	boolean Delete(int id);
}