package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;

public class ApplicationProgram {
	
	public static void main(String[] args) {
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		
		System.out.println("===TEST 1: seller findById ===== \n"+ sellerDao.findById(3));
		
	}

}
