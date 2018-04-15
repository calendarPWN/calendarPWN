package pl.pwn.reaktor.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import pl.pwn.reaktor.model.User;
import pl.pwn.reaktor.util.HibernateUtil;

public class UserService {
	
	public boolean login(String login, String password) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trx = session.beginTransaction();

		Query query = session.createQuery("FROM User WHERE login=:login and password=:pass");
		query.setString("login", login);
		query.setString("pass", password);

		List<User> list = query.list();
		trx.commit();
		session.close();
		
		if (list.isEmpty()) {
			return false;
		}
		User user = list.get(0);
		return true;
}
