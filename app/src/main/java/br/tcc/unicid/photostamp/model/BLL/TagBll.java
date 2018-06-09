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

	public Tag GetByName(String name) {
		return Dal.GetByName(name);
	}

	public String[] Get() {
		ArrayList<Tag> tags = Dal.Get();
		String[] tagsString = new String[tags.size()];

		for (int i = 0; i < tags.size(); i++) {
			tagsString[i] = tags.get(i).getName();
		}

		return new String[]{"Carro", "Coelho", "Show", "Viagem"};
		//return  tagsString;
	}

	public int Insert(Tag tag) {
		return Dal.Insert(tag);
	}

	public boolean Update(Tag tag) {
		return Dal.Update(tag);
	}

	public boolean Delete(int id) {
		return Dal.Delete(id);
	}
}