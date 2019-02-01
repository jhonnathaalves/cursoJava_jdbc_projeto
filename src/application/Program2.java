package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.impl.DepartmentDaoJDBC;
import model.entities.Department;
import model.entities.Seller;

public class Program2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DepartmentDao departmentDao = DaoFactory.createDerpartmentDao();
		
		System.out.println("=== TEST 1: Department findById ====");
		Department dep = departmentDao.findById(3);
		System.out.println(dep);
		System.out.println();
		
		System.out.println("=== TEST 2: Department findAll ====");
		List<Department> list = departmentDao.findAll();
		for (Department d : list) {
			System.out.println(d);
		}
		System.out.println("=== TEST 3: Department Insert ====");
		Department newDepartment = new Department(null,"Music");
		departmentDao.insert(newDepartment);
		System.out.println("inserted! New id= "+ newDepartment.getId());
		System.out.println();
		
		System.out.println("=== TEST 4: Department Update ====");
		dep = departmentDao.findById(1);
		dep.setName("Food");
		departmentDao.update(dep);
		System.out.println("Update Completed!");
		System.out.println();
		
		System.out.println("=== TEST 5: Department Delete ====");
		System.out.print("Enter id for delete teste: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete Completed!");
			
		
		sc.close();

	}

}
