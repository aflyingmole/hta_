package department;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class DepartmentTableModel extends AbstractTableModel {
	private ArrayList<ArrayList<String>> values;
	
	public DepartmentTableModel() {
		// TODO Auto-generated constructor stub
		
		DepartmentDAO dao = new DepartmentDAO();
		values = dao.listDept();
	}
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return values.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return values.get(0).size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return values.get(rowIndex).get(columnIndex);
	}

}



