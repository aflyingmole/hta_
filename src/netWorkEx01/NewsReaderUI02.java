package netWorkEx01;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class NewsReaderUI02 extends JFrame {

	private JPanel contentPane;
	private JTextField tf01;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewsReaderUI02 frame = new NewsReaderUI02();
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
	public NewsReaderUI02() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 441);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btn00 = new JButton("실시간 뉴스보기");
		btn00.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				NewsReaderUI02 ui = new NewsReaderUI02();
				ArrayList<String> datas = ui.readNews();
				for( String data : datas ) {
					System.out.println( data );
				}
			}
		});
		btn00.setBounds(12, 10, 560, 23);
		contentPane.add(btn00);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "\uB274\uC2A4 \uBCF4\uAE30", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(6, 45, 566, 350);
		contentPane.add(panel);
		panel.setLayout(null);
		
		tf01 = new JTextField();
		tf01.setEditable(false);
		tf01.setBounds(12, 25, 404, 21);
		panel.add(tf01);
		tf01.setText("뉴스내용");
		tf01.setColumns(10);
		
		JButton btn01 = new JButton("바로가기");
		btn01.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btn01.setBounds(428, 24, 126, 23);
		panel.add(btn01);
	}
	
	public ArrayList<String> readNews() {
		BufferedReader br = null;
		
		ArrayList<String> datas = new ArrayList<String>();
		
		try {
			URL url = new URL( "https://news.daum.net/" );
			br = new BufferedReader( new InputStreamReader( url.openStream() ) );
					
			String line = null;
			
			boolean flag = false;
			while( ( line = br.readLine() ) != null ) {
				
				if( line.contains( "class=\"link_txt\" data-tiara-layer=\"article_main\"" ) ) {
					flag = true;
				}
				
				if( line.contains( "</a>" ) ) {
					flag = false;
				}
				
				if( flag ) {
					String strUrl = line.substring( line.indexOf( "href" ) + 6, line.indexOf( "class" ) - 2 );
					String strData = br.readLine().trim();
					
					String data = strUrl + ":" + strData;
					datas.add( data );
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
		
		return datas;
	}
}
