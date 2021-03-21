package erp.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import erp.dao.DepartmentDao;
import erp.dao.impl.DepartmentDaoImpl;
import erp.dto.Department;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DepartmentDaoTest {

	private static DepartmentDao dao = DepartmentDaoImpl.getInstance();
	

	@Test
	public void test04SelectDepartmentByAll() {
		System.out.printf("%s()%n", "testSelectDepartmentByAll");
		List<Department> list = dao.selectDepartmentByAll();
		Assert.assertNotNull(list);
		list.stream().forEach(System.out::println);
		
	}

	@Test
	public void test05SelectDepartmentByNo() {
		System.out.printf("%s()%n", "testSelectDepartmentByNo");
		Department dept = dao.selectDepartmentByNo(new Department(3));
		Assert.assertNotNull(dept);
		System.out.println(dept);
	}

	@Test
	public void test01InsertDepartment() {
		System.out.printf("%s()%n", "testInsertDepartment");
		Department newDept = new Department(5, "인사", 15);
		int res = dao.insertDepartment(newDept);
		Assert.assertEquals(1, res);
		System.out.println(dao.selectDepartmentByNo(newDept));
	}

	@Test
	public void test02UpdateDepartment() {
			System.out.printf("%s()%n", "testUpdateDepartment");
			Department newDept = new Department(5, "연구", 10);
			int res = dao.updateDepartment(newDept);
			Assert.assertEquals(1, res);
			System.out.println(dao.selectDepartmentByNo(newDept));
	}

	@Test
	public void test03DeleteDepartment() {
		System.out.println("%s()%n, testDeleteDepartment");
		int res = dao.deleteDepartment(5);
		Assert.assertEquals(1, res);
		dao.selectDepartmentByAll().stream().forEach(System.out::println);
	}

}
