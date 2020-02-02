package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class ApplicationProgram {
	
	public static void main(String[] args) {
		
		Department dep = new Department(2,null);
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("===TEST 1: seller findById ===== \n"+ sellerDao.findById(3));
		
		List<Seller> seller = sellerDao.findByDepartment(dep);
		System.out.println("===TEST 2: seller findByDepartment ===== \n");
		seller.forEach(System.out::println);
		
		seller = sellerDao.findAll();
		System.out.println("===TEST 3: seller findAll ===== \n");
		seller.forEach(System.out::println);
		
		System.out.println("===TEST 4: seller insert ===== \n");
		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, dep);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New id = " + newSeller.getId());

	}

}
