package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class ApplicationProgram2 {
	
	public static void main(String[] args) {
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		Department dep = new Department(6, "NEW-d2");
//		departmentDao.insert(dep);
//		departmentDao.update(dep);
	}

}
