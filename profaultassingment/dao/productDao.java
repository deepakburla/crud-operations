package profaultassingment.dao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import profaultassingment.dto.Product;
import profaultassingment.dto.SubProduct;

public class productDao 
{
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("product");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();
	
	// save product
	
	public Product saveProduct(Product p)
	{
		et.begin();
		em.persist(p);
		et.commit();
		return p;
	}
	
	// find product
	
	public Product findProduct(int productId) 
	{
		Product p = em.find(Product.class, productId);
		if(p!=null) {
			return p;
		}
		else 
		{
			return null;
		}
	}
	
	// delete product
	
	public Product deleteproduct(int ProductId)
	{
		Product p = em.find(Product.class, ProductId);
		if(p!=null) {
			et.begin();
			em.remove(p);
			et.commit();
			return p;
		}
		else
		{
			return null;
		}
	}
	
	// update product
	
	public Product updateProduct(Product p, int productId)
	{
		Product dbproduct = em.find(Product.class, productId);
		if(dbproduct!=null)
		{
			p.setProductId(productId);
			et.begin();
			em.merge(p);
			et.commit();
		}
		return null;
	}
	
	// list <> get all products
	
	public List<Product> getAllProducts()
	{
		Query query = em.createQuery("select P from Product P");
		List<Product> allproducts = query.getResultList();
		if(!allproducts.isEmpty()) 
		{
			return allproducts;
		}
		else 
		{
			return null;
		}
	}
	
	// save subproduct
	
	public SubProduct saveSubProduct(SubProduct p)
	{
		et.begin();
		em.persist(p);
		et.commit();
		return p;
	}
	
	// find sub product 
	
	public SubProduct findSubProduct(int subProductId)
	{
		SubProduct p = em.find(SubProduct.class, subProductId);
		if(p!=null) 
		{
			return p;
		}
		else
		{
			return null;
		}
	}
	
	// delete subproduct
	
	public SubProduct deletesubProduct(int SubProductId) 
	{
		SubProduct p = em.find(SubProduct.class, SubProductId);
		if(p!=null) 
		{
			et.begin();
			em.remove(p);
			et.commit();
			return p;
		}
		else 
		{
			return null;
		}
	}
	
	// upadte subproduct
	
	public SubProduct updateSubProduct(SubProduct p, int subProductId) 
	{
		SubProduct dbsubProduct = em.find(SubProduct.class, subProductId);
		if(dbsubProduct!=null) 
		{
			p.setSubProduductId(subProductId);
			et.begin();
			em.merge(p);
			et.commit();
		}
		return null;
	}
	
	// list<> suballproducts
	
	public List <SubProduct> getAllSubProducts()
	{
		Query query = em.createQuery("select P from SubProduct P");
		List<SubProduct> allsubProducts = query.getResultList();
		if(!allsubProducts.isEmpty()) 
		{
			return allsubProducts;
		}
		else 
		{
			return null;
		}
	}
	
	
	
}
