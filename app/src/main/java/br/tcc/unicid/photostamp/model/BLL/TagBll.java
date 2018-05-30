package br.tcc.unicid.photostamp.model.BLL;

import java.util.ArrayList;
import javax.inject.Inject;
import br.tcc.unicid.photostamp.model.DAL.ITagDal;
import br.tcc.unicid.photostamp.model.DTO.Tag;

public class TagBll {
	private ITagDal Dal;

	@Inject
	public TagBll(ITagDal dal) {
		this.Dal = dal;
	}

	public Tag GetByID(int id) {
		return Dal.GetByID(id);
	}

	public ArrayList<Tag> Get() {
		return Dal.Get();
	}

	public boolean Insert(Tag tag) {
		return Dal.Insert(tag);
	}

	public boolean Update(Tag tag) {
		return Dal.Update(tag);
	}

	public boolean Delete(int id) {
		return Dal.Delete(id);
	}
}