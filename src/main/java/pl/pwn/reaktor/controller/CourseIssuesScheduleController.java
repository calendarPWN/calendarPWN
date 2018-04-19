package pl.pwn.reaktor.controller;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pl.pwn.reaktor.model.User;
import pl.pwn.reaktor.util.HibernateUtil;
import pl.pwn.reaktor.model.TematySzkolen;

@SuppressWarnings("deprecation")
public class CourseIssuesScheduleController {
	
	Session session = HibernateUtil.getSessionFactory().openSession();
	Transaction trx = session.beginTransaction();
	
	Query query = session.createQuery("FROM TematySzkolen");
	
	
	//List<TematySzkolen> list = query.list();
	List<TematySzkolen> listTematySzkolen = query.list();  
	
	ObservableList<TematySzkolen> courses = FXCollections.observableArrayList(listTematySzkolen);
	
		
	
	
	public void initialize() {

		cmbKurs.setItems(courses);

	}
}
