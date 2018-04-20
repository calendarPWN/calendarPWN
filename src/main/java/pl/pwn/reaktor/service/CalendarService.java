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

		//Query query = session.createQuery("SELECT p from Plan p");
		Query query = session.createQuery("FROM Calendar");
		
		/*"SELECT \r\n" + 
				"    g.akronim AS grupa,\r\n" + 
				"    p.dzien_szkol AS dzien_szkolenia,\r\n" + 
				"    td.db_date AS termin,\r\n" + 
				"    CONCAT(t.Imie, ' ', t.Nazwisko) AS trener,\r\n" + 
				"    ts.temat AS tematyka\r\n" + 
				"FROM\r\n" + 
				"    Grupa AS g" + 
				"        LEFT JOIN" + 
				"    Plan AS p ON g.idGrupa = p.idGrupa" + 
				"        LEFT JOIN" + 
				"    Time_dimension AS td ON td.day = (p.dzien_szkol + (SELECT " + 
				"            td.day" + 
				"        FROM" + 
				"            time_dimension AS td" + 
				"                LEFT JOIN" + 
				"            grupa AS g ON td.db_date = g.data_start))" + 
				"        LEFT JOIN" + 
				"    Trener AS t ON p.trener_idtrener = idtrener" + 
				"        LEFT JOIN" + 
				"    Tematy_szkolen AS ts ON ts.idtematy_szkolen = p.tematy_szkolen_idtematy_szkolen");*/
		List<Calendar> calendar = query.list();
		trx.commit();
		session.close();
		return calendar;
	}
	
	public List<Calendar> filter(CalendarFilter filter) {

		Session session = HibernateUtil.getSessionFactory().openSession();

		Criteria criteria = session.createCriteria(Calendar.class);

		if (Objects.nonNull(filter.getTematyka()) && !filter.getTematyka().isEmpty()) {
			criteria.add(Restrictions.eq("tematyka", filter.getTematyka()));
		}
		if (Objects.nonNull(filter.getTrener()) && !"Select".equals(filter.getTrener())
				&& !filter.getTrener().isEmpty()) {
			criteria.add(Restrictions.eq("trener", filter.getTrener()));
		}
		if (Objects.nonNull(filter.getDzienSzkolenia()) && !"Select".equals(filter.getDzienSzkolenia())
				&& !filter.getTrener().isEmpty()) {
			criteria.add(Restrictions.eq("weekend", filter.getDzienSzkolenia()));
		}
		if (Objects.nonNull(filter.getGrupa()) && !"Select".equals(filter.getGrupa())
				&& !filter.getGrupa().isEmpty()) {
			criteria.add(Restrictions.eq("grupa", filter.getGrupa()));
		}
		List<Calendar> calendar = criteria.list();

		session.close();
		return calendar;
	}
	
	/*public void update(Calendar selectedItem) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();

		session.saveOrUpdate(selectedItem);
		transaction.commit();
		session.close();
}
	public void delete(long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trx = session.beginTransaction();

		Query query = session.createQuery("DELETE FROM Calendar c WHERE id=:id");
		query.setLong("id", id);
		query.executeUpdate();

		trx.commit();
		session.close();
	}*/
}
