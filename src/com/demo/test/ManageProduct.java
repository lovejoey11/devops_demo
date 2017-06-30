package com.demo.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import com.demo.model.Product;


public class ManageProduct {
	private static SessionFactory factory;
	public static void main(String[] args) {
		try{
			factory = new AnnotationConfiguration().
					configure().addAnnotatedClass(Product.class).
					buildSessionFactory();
		}catch(Throwable ex){
			System.err.println("Fail to create sessionFactory object" + ex);
			throw new ExceptionInInitializerError(ex);
		}
		ManageProduct MP = new ManageProduct();
//		Integer prodID01 = MP.addProdcut("Iphone6","Next generation of SmartPhone", 899.99);
//		Integer prodID02 = MP.addProdcut("Iphone7","Redesigned New SmartPhone", 699.99);
//		Integer prodID03 = MP.addProdcut("Iphone8","Amazing SmartPhone", 799.99);
	
		MP.listProducts();
//		MP.updateProduct(prodID03, 999.99);
//		MP.deleteProduct(prodID02);
//		MP.listProducts();
	}
	
	public Integer addProdcut(String pName, String pDesc, double pPrice){
		Session session = factory.openSession();
		Transaction tx = null; 
		Integer productID = null;
		try{
			tx = session.beginTransaction();
			Product product = new Product(pName, pDesc, pPrice);
			productID = (Integer) session.save(product);
			tx.commit();
		}catch(HibernateException e){
			if(tx!=null) tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
		return productID;
	}
	
	
	public void listProducts(){
		Session session = factory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			List<Product> products = session.createQuery("From Product").list();
			for (Iterator iterator = 
                    products.iterator(); iterator.hasNext();){
				Product product = (Product) iterator.next();
				System.out.println("Product name: " + product.getProductName());
				System.out.println("Product Description: " + product.getProductDescption());
				System.out.println("Product Price: "+ product.getProductPrice());
			}
			tx.commit();
		}catch(HibernateException e){
			if(tx!=null) tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
	}
	
	public void updateProduct(Integer productID, double productPrice){
		Session session = factory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			Product product = (Product)session.get(Product.class, productID);
			product.setProductPrice(productPrice);
			session.update(product);
			tx.commit();
		}catch(HibernateException e){
			if(tx!=null) tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
			
		}
	}
	
	public void deleteProduct(Integer productID){
		Session session = factory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			Product product = (Product)session.get(Product.class, productID);
			session.delete(product);
			tx.commit();
		}catch(HibernateException e){
			if(tx!=null) tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
			
		}
	}
	
	

}
