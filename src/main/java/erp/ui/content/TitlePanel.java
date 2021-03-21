package erp.ui.content;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import erp.dto.Title;
import erp.ui.exception.InvalidCheckException;

public class TitlePanel extends AbstractContentPanel<Title> {
	private JTextField tfNo;
	private JTextField tfName;

	public TitlePanel() {

		initialize();
	}

	private void initialize() {
		setBorder(new TitledBorder(null, "직책정보", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new GridLayout(0, 2, 10, 10));

		JLabel lblNo = new JLabel("직책번호");
		lblNo.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblNo);

		tfNo = new JTextField();
		add(tfNo);
		tfNo.setColumns(10);

		JLabel lblName = new JLabel("직책명");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblName);

		tfName = new JTextField();
		tfName.setColumns(10);
		add(tfName);

	}

	@Override
	public void clearTf() {
		tfNo.setText("");
		tfName.setText("");

	}

	@Override
	public void setItem(Title item) {
		tfNo.setText(item.gettNo() + "");
		tfName.setText(item.gettName() + "");

		tfNo.setEditable(false);

	}

	@Override
	public Title getItem() {
		validCheck();
		int tNo = Integer.parseInt(tfNo.getText().trim());
		String tName = tfName.getText().trim();
		return new Title(tNo, tName);
	}

	@Override
	public void validCheck() {
		if (tfNo.getText().contentEquals("") || tfName.getText().equals("")) {
			throw new InvalidCheckException();
		}

	}
}
