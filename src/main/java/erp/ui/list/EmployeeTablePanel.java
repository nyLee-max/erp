package erp.ui.list;

import javax.swing.SwingConstants;

import erp.dto.Employee;
import erp.service.EmployeeService;
import erp.ui.exception.NotSelectedException;

@SuppressWarnings("serial")
public class EmployeeTablePanel extends AbstractCustomTablePanel<Employee> {

	private EmployeeService service;

	@Override
	protected void setAlighAndwidth() {
		// 컬럼내용 정렬
		setTableCellAlign(SwingConstants.CENTER, 0, 1, 2, 3, 4, 5);
		// 컬럼별 너비 조정
		setTableCellWidth(100, 100, 100, 100, 100, 100);
	}

	@Override
	public Object[] toArray(Employee t) {
		return new Object[] { t.getEmpNo(), t.getEmpName(),
				String.format("%s(%d)", t.getTitle().gettName(), t.getTitle().gettNo()),
				t.getManager().getEmpNo() == 0 ? ""
						: String.format("%s(%d)", t.getManager().getEmpName(), t.getManager().getEmpNo()),
				String.format("%d", t.getSalary()),
				String.format("%s(%d)", t.getDept().getDeptName(), t.getDept().getDeptno()) };

	}

	@Override
	public String[] getColumnNames() {
		return new String[] { "사원번호", "사원명", "사원직책", "직속상사", "급여", "부서" };
	}

	@Override
	public void initList() {
		list = service.showEmployee();
		System.out.println(list);
	}

	public void setService(EmployeeService service) {
		this.service = service;
	}

	@Override
	public Employee getItem() {
		int row = table.getSelectedRow();
		int empNo = (int) table.getValueAt(row, 0);

		if (row == -1) {
			throw new NotSelectedException();
		}
		return list.get(list.indexOf(new Employee(empNo)));
	}

}
