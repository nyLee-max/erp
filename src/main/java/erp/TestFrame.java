package erp;

import java.awt.EventQueue;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import erp.service.EmployeeService;
import erp.ui.content.EmployeePanel;
import erp.ui.list.DepartmentTablePanel;
import erp.ui.list.TitleTablePanel;
import erp.ui.list.EmployeeTablePanel;

public class TestFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestFrame frame = new TestFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TestFrame() {
		initialize();
	}
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 389);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		EmployeeService service = new EmployeeService();
		EmployeePanel pEmpItem = new EmployeePanel();
		pEmpItem.setService(service);
		
		contentPane.add(pEmpItem);
		
		JPanel pBtns = new JPanel();
		contentPane.add(pBtns);
		
		JButton btnAdd = new JButton("추가");
		pBtns.add(btnAdd);
		
		JButton btnClear = new JButton("취소");
		pBtns.add(btnClear);
		
		EmployeeTablePanel panel = new EmployeeTablePanel();
		panel.setService(service);
		panel.loadData();
		contentPane.add(panel);
		
		
	}

}
