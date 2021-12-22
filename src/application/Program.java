package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		List<Product> list = new ArrayList<Product>();
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();
		for (int j = 0; j < n; j++) {
			System.out.println("Product #" + (j+1) + " data:");
			sc.nextLine();
			char r;
			do {
				System.out.print("Common, used or imported (c/u/i)?");
				r = sc.next().charAt(0);
			}while(r != 'c' && r != 'u' && r != 'i');
			sc.nextLine();
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Price: ");
			double price = sc.nextDouble();
			if (r == 'c') {
				list.add(new Product(name, price));
			}else if (r == 'i') {
				System.out.print("Customs fee:");
				double customsFee = sc.nextDouble();
				list.add(new ImportedProduct(name, price, customsFee));
			}else if (r == 'u') {
				System.out.print("Manufacture date: ");
				Date date = sdf.parse(sc.next());
				list.add(new UsedProduct(name, price, date));
			}
			
		}
		
		System.out.println();
		System.out.println("PRICE TAGS: ");
		for (Product p : list) {
			System.out.println(p.priceTag());
		}
		
		
		sc.close();

	}

}
