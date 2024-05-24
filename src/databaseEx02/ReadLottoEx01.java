package databaseEx02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ReadLottoEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Workbook workBook = null;
		
		try {
			workBook = Workbook.getWorkbook( new FileInputStream( "./lotto(1119).xls" ) );
			
			Sheet sheet = workBook.getSheet( 0 );
            
			for( int row=sheet.getRows() ; row>=4 ; row-- ) {
				Cell turn = sheet.getCell( 2-1, row-1 );
				Cell num1 = sheet.getCell( 14-1, row-1 );
				Cell num2 = sheet.getCell( 15-1, row-1 );
				Cell num3 = sheet.getCell( 16-1, row-1 );
				Cell num4 = sheet.getCell( 17-1, row-1 );
				Cell num5 = sheet.getCell( 18-1, row-1 );
				Cell num6 = sheet.getCell( 19-1, row-1 );
				Cell num7 = sheet.getCell( 20-1, row-1 );
				Cell wdate = sheet.getCell( 3-1, row-1 );
				
				System.out.printf( "%2s회 %2s %2s %2s %2s %2s %2s %2s %s\n",
					turn.getContents(), num1.getContents(), num2.getContents(), num3.getContents(),
					num4.getContents(), num5.getContents(), num6.getContents(), num6.getContents(), wdate.getContents() );
				}
			
		} catch (BiffException e) {
			// TODO Auto-generated catch block
			System.out.println( "[에러] " + e.getMessage() );
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println( "[에러] " + e.getMessage() );
		} catch (IndexOutOfBoundsException e) {
			// TODO Auto-generated catch block
			System.out.println( "[에러] " + e.getMessage() );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println( "[에러] " + e.getMessage() );
		} finally {
			if( workBook != null ) workBook.close();
		}
	}

}
