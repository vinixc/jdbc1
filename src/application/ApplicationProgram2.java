package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class ApplicationProgram2 {
	
	public static void main(String[] args) {
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
//		Department dep = departmentDao.findById(2);
//		System.out.println(dep);
//		departmentDao.insert(dep);
//		departmentDao.update(dep);
//		departmentDao.deleteById(6);
		
		List<Department> departments = departmentDao.findAll();
		departments.forEach(System.out::println);
	}

}
