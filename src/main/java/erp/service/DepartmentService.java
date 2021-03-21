package erp.service;

import java.util.List;

import erp.dao.DepartmentDao;
import erp.dao.EmployeeDao;
import erp.dao.impl.DepartmentDaoImpl;
import erp.dao.impl.EmployeeDaoImpl;
import erp.dto.Department;
import erp.dto.Employee;
import erp.dto.Title;

public class DepartmentService {
	private DepartmentDao dao = DepartmentDaoImpl.getInstance();
	private EmployeeDao empDao = EmployeeDaoImpl.getInstance();
	
	public List<Department> showDepartment(){
		return dao.selectDepartmentByAll();
	}
	
	public void addDepartment(Department department) {
		dao.insertDepartment(department);
	}
	public void removeDepartment(Department department) {
		dao.deleteDepartment(department);
	}
	public void modifyDepartment(Department department) {
		dao.updateDepartment(department);
	}
	public List<Employee> showEmployeeGroupByDept(Department department){
		return empDao.selectEmployeeByDept(department);
		
	}
}
