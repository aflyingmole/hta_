package boxofficeEx02;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class BoxOfficeTableModel extends AbstractTableModel {

	private ArrayList<BoxOfficeTO> datas;
	
	private String[] columnNames = new String[] { "\uC601\uD654\uBA85", "\uC88C\uC11D\uC218", "\uC88C\uC11D\uC810\uC720\uC728", "\uC88C\uC11D\uD310\uB9E4\uC728", "\uC99D\uAC10\uC728" };
	private boolean[] columnEditables = new boolean[] { false, false, false, false, false };
	
	public BoxOfficeTableModel() {
		// TODO Auto-generated constructor stub
		
		/*
		BoxOfficeTO to = new BoxOfficeTO();
		to.setRnum( "1" );
		to.setRank( "1" );
		to.setRankInten( "0" );
		to.setRankOldAndNew( "OLD" );
		to.setMovieCd( "20236653" );
		to.setMovieNm( "퓨리오사: 매드맥스 사가" );
		to.setOpenDt( "2024-05-22" );
		to.setAudiCnt( "28378" );
		to.setAudiAcc( "1079407" );
		
		datas = new ArrayList<BoxOfficeTO>();
		datas.add( to );
		*/
		
		BoxOfficeDAO dao = new BoxOfficeDAO();
		datas = dao.parseXML();
	}
	
	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return columnNames[column];
	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return columnEditables[columnIndex];
	}
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return datas.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 5;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		BoxOfficeTO to = datas.get( rowIndex );
		
		String result = "";
		switch(columnIndex) {
		case 0:
			result = to.getRnum() + " " + to.getMovieNm();
			break;
		case 1:
			result = to.getOpenDt();
			break;
		case 2:
			result = to.getAudiCnt();
			break;
		case 3:
			result = to.getAudiAcc();
			break;
		case 4:
			result = to.getRankInten();
			break;
		}
		return result;
	}

}
