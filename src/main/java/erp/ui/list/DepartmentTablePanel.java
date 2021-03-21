package erp.ui.list;

import javax.swing.SwingConstants;

import erp.dto.Department;
import erp.service.DepartmentService;
import erp.ui.exception.NotSelectedException;

@SuppressWarnings("serial")
public class DepartmentTablePanel extends AbstractCustomTablePanel<Department> {
	public DepartmentTablePanel() {
	}

	private DepartmentService service;
	
	@Override
	public void initList() {
		list = service.showDepartment();
		
	}

	@Override
	protected void setAlighAndwidth() {
		//컬럼내용 정렬
		setTableCellAlign(SwingConstants.CENTER, 0, 1, 2);
		//컬럼별 너비 조정
		setTableCellWidth(100, 100, 100);
		
	}

	@Override
	public Object[] toArray(Department t) {
		return new Object[] {t.getDeptno(), t.getDeptName(), t.getFloor()};
	}

	@Override
	public String[] getColumnNames() {
		return new String[] {"부서번호", "부서명", "부서위치"};
	}

	public void setService(DepartmentService service) {
		this.service = service;
	}

	@Override
	public Department getItem() {
		int row = table.getSelectedRow();
		int DeptNo = (int) table.getValueAt(row, 0);
		
		if(row == -1) {
			throw new NotSelectedException();
		}
		return list.get(list.indexOf(new Department(DeptNo)));
	}
}
