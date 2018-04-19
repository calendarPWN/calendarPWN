package pl.pwn.reaktor.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import pl.pwn.reaktor.model.Login;
import pl.pwn.reaktor.util.HibernateUtil;

@SuppressWarnings("deprecation")
public class LoginService {
	
	public boolean login(String login, String password) throws SQLException {

//		Connection conn = DriverManager.getConnection(
//				"jdbc:mysql://serwer1884902.home.pl:3306/26932668_cal", 
//				"26932668_cal", 
//				"calendar#2018");
//		PreparedStatement pStatement = conn.prepareStatement("select login, password from login where login = ? and password = ?");
//		pStatement.setString(1, login);
//		pStatement.setString(2, password);
//		ResultSet rSet = pStatement.executeQuery();
		
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trx = session.beginTransaction();
		
		
		
		Query query = session.createQuery("FROM Login WHERE login=:login and password=:password");
		//Query query = session.createQuery("FROM Login");
		//Query query = session.createSQLQuery("SELECT l.login, l.password FROM login as l WHERE l.login=\"" + login + "\" AND l.password=\"" + password + "\";");
		
		
		query.setString("login", login);
		query.setString("password", password);
				
		List<Login> list = query.list();
		System.out.println(list.get(0).getId());
		trx.commit();
		session.close();
		Login login2 = list.get(0);
		System.out.println(login2.getLogin());
		
		if (!list.isEmpty()) {
			return true;
		}
		//if (rSet.next()) {
		//	return true;
		//}
//		Login login3 = list.get(0);
//		System.out.println(login3.getLogin());
		return false;
}
}
