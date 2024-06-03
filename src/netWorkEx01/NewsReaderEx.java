package netWorkEx01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class NewsReaderEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BufferedReader br = null;
		
		try {
			URL url = new URL( "https://news.daum.net/" );
			br = new BufferedReader( new InputStreamReader( url.openStream() ) );
			
			String line = null;
			
			boolean flag = false;
			while( ( line = br.readLine() ) != null ) {
				if( line.contains( "<ul class=\"list_newsissue\">" ) ) {
					flag = true;
					continue;
				}
				
				if( line.contains( "</ul>" ) ) {
					flag = false;
				}
				
				if( flag ) {
					System.out.println( line );
				}
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			System.out.println( "[에러] " + e.getMessage() );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println( "[에러] " + e.getMessage() );
		} finally {
			if( br != null ) try { br.close(); } catch( IOException e ) {} 
		}
	}
}
