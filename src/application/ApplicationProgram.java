package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class ApplicationProgram {
	
	public static void main(String[] args) {
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("===TEST 1: seller findById ===== \n"+ sellerDao.findById(3));
		
		List<Seller> seller = sellerDao.findByDepartment(new Department(2,null));
		System.out.println("===TEST 2: seller findByDepartment ===== \n");
		seller.forEach(System.out::println);
		
		seller = sellerDao.findAll();
		System.out.println("===TEST 3: seller findAll ===== \n");
		seller.forEach(System.out::println);
	}

}
