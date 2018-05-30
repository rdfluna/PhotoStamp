package br.tcc.unicid.photostamp.model.BLL;

import android.app.Activity;
import android.graphics.Bitmap;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import javax.inject.Inject;
import br.tcc.unicid.photostamp.model.DAL.IPhotoDal;
import br.tcc.unicid.photostamp.model.DTO.Photo;
import br.tcc.unicid.photostamp.model.DTO.Tag;

public class PhotoBll {
	private IPhotoDal Dal;

	@Inject
	public PhotoBll(IPhotoDal dal) {
		this.Dal = dal;
	}

	public Photo GetByID(int id) {
		return Dal.GetByID(id);
	}

	public ArrayList<Photo> Get() {
		return Dal.Get();
	}


	public boolean Insert(Bitmap imageBitmap) {
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		imageBitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
		byte imagemBytes[] = stream.toByteArray();

		Photo photo = new Photo();
		photo.setName("Teste");
		photo.setExtention(".JPG");
		photo.setImage(imagemBytes);
		photo.setSize(4);
		photo.setPath("/");

		return Dal.Insert(photo);
	}

	public boolean Delete(int id) {
		return Dal.Delete(id);
	}

	public boolean UpdateTag(int id, Tag tag) {
		return Dal.UpdateTag(id, tag);
	}
}