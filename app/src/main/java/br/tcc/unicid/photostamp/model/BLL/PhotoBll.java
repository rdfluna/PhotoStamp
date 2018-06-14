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

	public int GetTotal() {
		return Dal.GetTotal();
	}

	public Photo GetByID(int id) {
		return Dal.GetByID(id);
	}

	public Photo GetByPosition(int position) {
		return Dal.GetByPosition(position);
	}

	public Photo GetWithoutTagByPosition(int position) {
		return Dal.GetWithoutTagByPosition(position);
	}

	public int GetTotalWithoutTag() {
		return Dal.GetTotalWithoutTag();
	}

	public ArrayList<Photo> Get() {
		return Dal.Get();
	}

	public ArrayList<Photo> Get(ArrayList<Tag> tags, boolean desc, boolean orderDate) {
		String[] tagsID = new String[tags.size()];

		for (int i = 0; i < tags.size(); i++) {
			tagsID[i] = String.valueOf(tags.get(i).getID());
		}

		return Dal.Get(tagsID, desc, orderDate);
	}

	public int Insert(Bitmap imageBitmap) {
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

	public boolean DeleteTag(int id) {
		return Dal.DeleteTag(id);
	}
}