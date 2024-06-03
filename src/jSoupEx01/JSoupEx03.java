package jSoupEx01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JSoupEx03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = null;
		StringBuilder sbHtml = new StringBuilder();
		
		try {
			URLConnection conn = new URL( "https://news.daum.net/" ).openConnection();
			br = new BufferedReader( new InputStreamReader( conn.getInputStream() ) );
			
			String line = null;
			while( (line = br.readLine() ) != null ) {
				sbHtml.append( line + System.lineSeparator() );
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if( br != null ) try { br.close(); } catch( IOException e ) {}
		}
		
		System.out.println( sbHtml.toString() );
		// => Document
		
		Document doc = Jsoup.parse( sbHtml.toString() );
		
		Elements lists = doc.getElementsByClass( "link_txt" );
		for( Element list : lists ) {
			System.out.println( list.text() );
		}

	}

}
