package com.demo.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import com.demo.model.Category;


public class ManageCategory {
	private static SessionFactory factory;
	public static void main(String[] args) {
		try{
			factory = new AnnotationConfiguration().
					configure().addAnnotatedClass(Category.class).
					buildSessionFactory();
		}catch(Throwable ex){
			System.err.println("Fail to create sessionFactory object" + ex);
			throw new ExceptionInInitializerError(ex);
		}
		ManageCategory MP = new ManageCategory();
		Integer cateID01 = MP.addCategory("Phone","Next generation of SmartPhone");
		Integer cateID02 = MP.addCategory("TV","Redesigned New SmartTV");
		Integer cateID03 = MP.addCategory("Computer","Amazing Computer");
	
		MP.listCategorys();
//		MP.updateCategory(prodID03, 999.99);
//		MP.deleteCategory(prodID02);
//		MP.listCategorys();
	}
	
	public Integer addCategory(String cName, String cDesc){
		Session session = factory.openSession();
		Transaction tx = null; 
		Integer categoryID = null;
		try{
			tx = session.beginTransaction();
			Category category = new Category(cName, cDesc);
			categoryID = (Integer) session.save(category);
			tx.commit();
		}catch(HibernateException e){
			if(tx!=null) tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
		return categoryID;
	}
	
	
	public void listCategorys(){
		Session session = factory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			List<Category> categories = session.createQuery("From Category").list();
			for (Iterator iterator = 
                    categories.iterator(); iterator.hasNext();){
				Category category = (Category) iterator.next();
				System.out.println("Category name: " + category.getCategoryName());
				System.out.println("Category Description: " + category.getCategoryDescription());
				
			}
			tx.commit();
		}catch(HibernateException e){
			if(tx!=null) tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
	}
	
//	public void updateCategory(Integer productID, double productPrice){
//		Session session = factory.openSession();
//		Transaction tx = null;
//		try{
//			tx = session.beginTransaction();
//			Category product = (Category)session.get(Category.class, productID);
//			product.setCategoryPrice(productPrice);
//			session.update(product);
//			tx.commit();
//		}catch(HibernateException e){
//			if(tx!=null) tx.rollback();
//			e.printStackTrace();
//		}finally{
//			session.close();
//			
//		}
//	}
	
//	public void deleteCategory(Integer productID){
//		Session session = factory.openSession();
//		Transaction tx = null;
//		try{
//			tx = session.beginTransaction();
//			Category product = (Category)session.get(Category.class, productID);
//			session.delete(product);
//			tx.commit();
//		}catch(HibernateException e){
//			if(tx!=null) tx.rollback();
//			e.printStackTrace();
//		}finally{
//			session.close();
//			
//		}
//	}
	
	

}
