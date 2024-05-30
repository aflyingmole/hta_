package department;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class DepartmentTableModel2 extends AbstractTableModel {
	private ArrayList<DepartmentTO> values;
	
	private String[] columnNames = new String[] { "deptno", "dname", "loc"};
	
	public DepartmentTableModel2() {
		// TODO Auto-generated constructor stub
		
		DepartmentDAO dao = new DepartmentDAO();
		values = dao.listDept2();
	}
	
	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return columnNames[column];
	}
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return values.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnNames.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		
		String result = "";
		
		DepartmentTO to = values.get(rowIndex);
		switch( columnIndex ) {
		case 0 :
			result = to.getDeptno();
			break;
		case 1 :
			result = to.getDname();
			break;
		case 2 :
			result = to.getLoc();
			break;			
		}
		
		return result;
	}
}



