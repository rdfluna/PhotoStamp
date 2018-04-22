package br.tcc.unicid.photostamp.model.DAL;

import java.util.Date;
import br.tcc.unicid.photostamp.model.DTO.Event;

public interface IEventDal {
	Event Get(Date date);
}