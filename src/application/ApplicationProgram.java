package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class ApplicationProgram {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Department dep = new Department(2,null);
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("===TEST 1: seller findById ===== \n"+ sellerDao.findById(3));
		
		List<Seller> sellers = sellerDao.findByDepartment(dep);
		System.out.println("===TEST 2: seller findByDepartment ===== \n");
		sellers.forEach(System.out::println);
		
		sellers = sellerDao.findAll();
		System.out.println("===TEST 3: seller findAll ===== \n");
		sellers.forEach(System.out::println);
		
		System.out.println("===TEST 4: seller insert ===== \n");
		Seller newSeller = new Seller(9, "Greg", "greg@gmail.com", new Date(), 4000.0, dep);
		//sellerDao.insert(newSeller);
		System.out.println("Inserted! New id = " + newSeller.getId());
		
		System.out.println("===TEST 5: seller update ===== \n");
		Seller seller = sellerDao.findById(1);
		seller.setName("Martha Waine");
		sellerDao.update(seller);
		System.out.println("Update completed");
		
		System.out.println("===TEST 5: seller delete ===== \n");
		System.out.println("Enter id for delete test: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Delete Completed");
		sc.close();

	}

}
