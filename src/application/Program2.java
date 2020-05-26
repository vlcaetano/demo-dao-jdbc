package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) { //para testar o DepartmentDaoJDBC
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

		System.out.println("==== TEST 1: department findById ====");
		Department department = departmentDao.findById(6);		
		System.out.println(department);
		
		System.out.println("\n==== TEST 2: department findAll ====");
		List<Department> list = departmentDao.findAll();
		list.forEach(System.out::println);
		
		System.out.println("\n==== TEST 3: department insert ====");
		Department newDep = new Department(null, "Music");
		departmentDao.insert(newDep);
		System.out.println("Inserted! New id = " + newDep.getId());
		
		System.out.println("\n==== TEST 4: department update ====");
		newDep = departmentDao.findById(1);
		newDep.setName("Food");
		departmentDao.update(newDep);
		System.out.println("Update completed");
		
		System.out.println("\n==== TEST 5: department delete ====");
		departmentDao.deleteById(6);
		System.out.println("Delete completed");
		
	}

}
