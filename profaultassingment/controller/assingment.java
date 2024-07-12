package profaultassingment.controller;
import java.util.Scanner;
import profaultassingment.dao.Controller;

public class assingment 
{
	public static void main(String[] args)
	{
		boolean test = true;
		while (test)
		{
        	Scanner sc = new Scanner(System.in);
			System.out.println("<-- The Start -->");
			System.out.println("1-> create product");
			System.out.println("2-> find all product");
			System.out.println("3-> find product");
			System.out.println("4-> update product");
			System.out.println("5-> delete product");
			System.out.println("6-> create SubPRoduct");
			System.out.println("7-> find subProducts");
			System.out.println("8-> delete sub products");
			System.out.println("9-> exit the application");
			System.out.println("enter the options from above");
			int qsp = sc.nextInt();
			Controller c = new Controller();
			
			// using switch case for executing multiple conditions
			
			switch (qsp)
			{
			case 1:
				c.saveProduct();
			break;
				
			case 2:
				c.findAllProduct();
			break;
				
			case 3:
				c.findProduct();
			break;
				
			case 4:
				c.updateProduct();
			break;
				
			case 5:
				c.deleteProduct();
			break;
				
			case 6:
				c.saveSubProduct();
			break;
				
			case 7:
				c.findAllSubProducts();
			break;
				
			case 8:
				c.deleteSubProduct();
			break;
				
			case 9:
				System.out.println("<-- The End -->");
				test=false;
			break;

			default:
				System.out.println("<-- Failure -->");
			break;
			}
		}
	}
}
