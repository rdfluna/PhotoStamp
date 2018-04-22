package br.tcc.unicid.photostamp.model.BLL;

import java.util.Date;
import javax.inject.Inject;
import br.tcc.unicid.photostamp.model.DAL.IEventDal;
import br.tcc.unicid.photostamp.model.DTO.Event;


public class EventBll {
	private IEventDal Dal;

	@Inject
	public EventBll(IEventDal dal) {
		this.Dal = dal;
	}

	public Event Get() {
		return Dal.Get(new Date());
	}
}