package pl.pwn.reaktor.service;

import java.util.List;
import java.util.Objects;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import pl.pwn.reaktor.model.Calendar;
import pl.pwn.reaktor.model.CalendarFilter;
import pl.pwn.reaktor.util.HibernateUtil;

public class CalendarService {

	@SuppressWarnings("unchecked")
	public List<Calendar> getAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trx = session.beginTransaction();

		Query query = session.createQuery("SELECT p FROM plan p");
		List<Calendar> calendar = query.list();
		trx.commit();
		session.close();
		return calendar;
	}
	
	public List<Calendar> filter(CalendarFilter filter) {

		Session session = HibernateUtil.getSessionFactory().openSession();

		Criteria criteria = session.createCriteria(Calendar.class);

		if (Objects.nonNull(filter.getTermin()) && !"Select".equals(filter.getTermin())) {
			criteria.add(Restrictions.eq("termin", filter.getTermin()));
		}
		if (Objects.nonNull(filter.getTematyka()) && !filter.getTematyka().isEmpty()) {
			criteria.add(Restrictions.eq("tematyka", filter.getTematyka()));
		}
		if (Objects.nonNull(filter.getTrener()) && !"Select".equals(filter.getTrener())
				&& !filter.getTrener().isEmpty()) {
			criteria.add(Restrictions.eq("trener", filter.getTrener()));
		}
		if (Objects.nonNull(filter.getWeekend()) && !"Select".equals(filter.getWeekend())
				&& !filter.getTrener().isEmpty()) {
			criteria.add(Restrictions.eq("weekend", filter.getWeekend()));
		}
		if (Objects.nonNull(filter.getGrupa()) && !"Select".equals(filter.getGrupa())
				&& !filter.getGrupa().isEmpty()) {
			criteria.add(Restrictions.eq("grupa", filter.getGrupa()));
		}
		List<Calendar> calendar = criteria.list();

		session.close();
		return calendar;
	}
}
