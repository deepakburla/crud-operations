package profaultassingment.dao;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import profaultassingment.dto.Product;
import profaultassingment.dto.SubProduct;

public class Controller 
{
	Scanner sc = new Scanner(System.in);
	productDao d = new productDao();
	public void saveProduct() 
	{
		Product p = new Product();
		System.out.println("enter product category");
		p.setProductCategory(sc.next());
		System.out.println("enter product description");
		p.setProductDescription(sc.next());
		List<SubProduct> subproducts = new ArrayList<SubProduct>();
		p.setSubProducts(subproducts);
		if(d.saveProduct(p)!=null) 
		{
			System.out.println("product save successfull");
		}else 
		{
			System.out.println("No product found");
		}
	}
	public void findProduct()
	{
		System.out.println("enter the pid");
		int id = sc.nextInt();
		Product p = d.findProduct(id);
		if(p!=null) 
		{
			System.out.println(p.getProductId()+" "+p.getProductCategory()+" "+p.getProductDescription());
		}else
		{
			System.out.println("No product found");
		}	
	}
	public void deleteProduct()
	{
		System.out.println("enter the id of the product you want to delete");
		int id = sc.nextInt();
		Product p = d.findProduct(id);
		if(p!=null)
		{
			d.deleteproduct(id);
			System.out.println("product delete success");
		}else
		{
			System.out.println("No product found");
		}
	}	
	public void findAllProduct()
	{
		List<Product> allProducts = d.getAllProducts();
		for(Product p : allProducts)
		{
			System.out.println("id"+"  "+"category"+"  "+"description");
			System.out.println(p.getProductId()+"  "+p.getProductCategory()+"  "+p.getProductDescription());
		}
	}
	
	public Product updateProduct() 
	{	
		List<Product> products = d.getAllProducts();
		for(Product p : products) 
		{
			System.out.println(p.getProductId()+" "+p.getProductCategory());
		}	
		System.out.println("enter the id of the product you want to update");
		int id = sc.nextInt();
		Product p = d.findProduct(id);
		System.out.println("choose your options");
		System.out.println("1 : update category");
		System.out.println("2 : update description");
		int choice = sc.nextInt();
		if(choice==1)
		{
			System.out.println("enter the updated category");
			p.setProductCategory(sc.next());
			return d.updateProduct(p,id);
		}
		if(choice==2) 
		{
			System.out.println("enter the updated description");
			p.setProductDescription(sc.next());
			return d.updateProduct(p,id);
		}
		return p;
	}	
	public void saveSubProduct()
	{	
		List <Product> products = d.getAllProducts();
		for(Product p : products)
		{
			System.out.println(p.getProductId()+"  "+p.getProductCategory());
	    }	
		System.out.println("enter the product id to which you want to add the sub product");
		int id = sc.nextInt();
		Product p = d.findProduct(id);
		
		//sub product
		
		SubProduct sub = new SubProduct();
		System.out.println("enter the subproduct brand");
		sub.setSubProductBrand(sc.next());
		System.out.println("enter the subproduct price");
		sub.setSubProductPrice(sc.nextDouble());
		sub.setProduct(p);
		p.getSubProducts().add(sub);
		
		//product updated
		
		Product updated = d.updateProduct(p,id);
		System.out.println(updated);
		if(updated!=null)
		{
			d.saveSubProduct(sub);
		System.out.println("save sucessfully");
		}
		else
		{
		System.out.println("No product found");
		}
	}
	
	// find all sub product
	
	public void findAllSubProducts()
	{
		List<Product> products = d.getAllProducts();
		for(Product p : products) 
		{
		System.out.println(p.getProductId()+"   "+p.getProductCategory());
		}	
		System.out.println("enter the product id to display all the products");
		int id = sc.nextInt();
		Product p = d.findProduct(id);
		for(SubProduct sp : p.getSubProducts())
		{
		System.out.println(sp.getSubProduductId()+"  "+sp.getSubProductBrand()+"  "+sp.getSubProductPrice());
		}	
	}
	
	// delete sub product
	
	public void deleteSubProduct()
	{
		List<Product> products = d.getAllProducts();
		for(Product p : products) 
		{
		System.out.println(p.getProductId()+"  "+p.getProductCategory());
		}
		System.out.println("enter the product id from where you want to delete a subproduct");
		int id = sc.nextInt();
		Product p = d.findProduct(id);		
		for(SubProduct sp : p.getSubProducts())
		{
		System.out.println(sp.getSubProduductId()+"  "+sp.getSubProductBrand()+"  "+sp.getSubProductPrice());
		}
		System.out.println(" enter the sub product ID you want to delete");
		int subid = sc.nextInt();
		SubProduct subproducttobedeleted = d.findSubProduct(subid);
		p.getSubProducts().remove(subproducttobedeleted);
		subproducttobedeleted.setProduct(null);
		d.updateProduct(p, id);
		d.deletesubProduct(subid);
	}
	
	// update sub product
	
	public void updateSubProduct()
	{
		List<Product> products = d.getAllProducts();
		for(Product p : products) 
		{
		System.out.println(p.getProductId()+" "+p.getProductCategory());
		}
		System.out.println("enter the product id from where you want to delete a subproduct");
		int id = sc.nextInt();
		Product p = d.findProduct(id);
		for(SubProduct sp : p.getSubProducts()) 
		{
		System.out.println(sp.getSubProduductId()+"  "+sp.getSubProductBrand()+"  "+sp.getSubProductPrice());
		}
		System.out.println(" enter the sub product ID you want to update");
		int subid = sc.nextInt();
		SubProduct subproducttobeupdated = d.findSubProduct(subid);
		System.out.println("choose your options");
		System.out.println("1 : update brand");
		System.out.println("2 : update price");
		int choice = sc.nextInt();
		if(choice==1) 
		System.out.println("enter the updated brand");
		subproducttobeupdated.setSubProductBrand(sc.next());
		d.updateSubProduct(subproducttobeupdated,subid);
		
		if(choice==2) 
		{
		System.out.println("enter the updated price");
		subproducttobeupdated.setSubProductPrice(sc.nextDouble());
		d.updateSubProduct(subproducttobeupdated,subid);
		}
		else 
		{
		System.out.println("No product found");

		}
	}	
}
