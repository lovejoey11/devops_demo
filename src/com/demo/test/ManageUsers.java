package com.demo.test;

import java.util.Iterator;
import java.util.List;



import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import com.demo.model.User;

public class ManageUsers {
	private static SessionFactory factory;
	
	public static void main(String[] args) {
		try{
			factory = new AnnotationConfiguration().
					configure().addAnnotatedClass(User.class).
					buildSessionFactory();
		}catch(Throwable ex){
			System.err.println("Fail to create "
					+ "sessionFactory object" + ex);
			throw new ExceptionInInitializerError(ex);
		}
		ManageUsers MP = new ManageUsers();
		Integer userID01 = MP.addUser("bcsusssssser", "bcsusssssser", "User", "ucser1", "user1");
//		Integer userID02 = MP.addUser("alian", "Rogue", "Guest", "alian", "alian");
//		Integer userID03 = MP.addUser("Stepth", "Curry", "User", "stepth", "curry");
	
		MP.listUsers();
//		MP.updateProduct(prodID03, 999.99);
//		MP.deleteUser(155);
//		MP.deleteUser(156);
//		MP.deleteUser(154);
		
//		MP.listProducts();
	}
	
	public Integer addUser(String fname, String lname, 
			String ugroup, String uname, String passwd){
		Session session = factory.openSession();
		Transaction tx = null;
		Integer userid = null;
		try{
			tx = session.beginTransaction();
			User user = new User();
			user.setFirstname(fname);
			user.setLastname(lname);
			user.setUsergroup(ugroup);
			user.setUsername(uname);
			user.setPasswd(passwd);
			userid = (Integer) session.save(user);
			tx.commit();
		}catch(HibernateException e){
			if (tx!= null)tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();			
		}
		System.out.println("User Id is : " + userid);
		return userid;
	}
	
	public void listUsers(){
		Session session = factory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			List<User> users = session.createQuery("From User").list();
			for (Iterator<User> iterator = 
					users.iterator();iterator.hasNext();){
				User user =  (User) iterator.next();
				System.out.print("First name: " + user.getFirstname());
				System.out.println(" Last name: " + user.getLastname());
				System.out.print("User Group: " + user.getUsergroup());
				System.out.println(" User Name: " + user.getUsername());
				System.out.println("Pass word: " + user.getPasswd());
			}
			tx.commit();
		}catch(HibernateException e){
			if(tx!=null) tx.rollback();
			e.printStackTrace();
			
		}finally{
			session.close();
		}
	}
	
	public void updateUsergroup(Integer userId, String ugroup){
		Session session = factory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
		}catch(HibernateException e){
			if(tx!=null) tx.rollback();
			e.printStackTrace();
			
		}finally{
			session.close();
		}
	}
	
	public void deleteUser(Integer userId){
		Session session = factory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			User user = (User) session.get(User.class, userId);
			session.delete(user);
			tx.commit();
		}catch(HibernateException e){
			if(tx!=null) tx.rollback();
			e.printStackTrace();
			
		}finally{
			session.close();
		}
	}
	

}
