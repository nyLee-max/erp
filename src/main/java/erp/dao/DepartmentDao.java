package erp.dao;

import java.util.List;

import erp.dto.Department;
import erp.dto.Title;

public interface DepartmentDao {
	List<Department> selectDepartmentByAll();
	Department selectDepartmentByNo(Department department);
	
	int insertDepartment(Department department);
	int updateDepartment(Department department);
	int deleteDepartment(Department department);
	
	List<Department> selectDepartmentByTitle(Title title);
}
