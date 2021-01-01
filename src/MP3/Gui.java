package MP3;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Gui extends JFrame{
	// 버튼 이미지 설정 -->ImageIcon을 Image로 변환하고 Image의 사이즈 조절 후 다시 이를 ImageIcon으로 변환.)	
	ImageIcon icon1 = new ImageIcon("./images/play.png");
	ImageIcon icon2 = new ImageIcon("./images/shuffle.png");
	ImageIcon icon3 = new ImageIcon("./images/stop.png");
	ImageIcon icon4 = new ImageIcon("./images/back.png");
	ImageIcon icon5 = new ImageIcon("./images/next.png");
	
	Image img1 = icon1.getImage();
	Image img2 = icon2.getImage();
	Image img3 = icon3.getImage();
	Image img4 = icon4.getImage();
	Image img5 = icon5.getImage();
	
	Image changeImg1 = img1.getScaledInstance(60, 45, Image.SCALE_SMOOTH);
	Image changeImg2 = img2.getScaledInstance(60, 45, Image.SCALE_SMOOTH);
	Image changeImg3 = img3.getScaledInstance(60, 45, Image.SCALE_SMOOTH);
	Image changeImg4 = img4.getScaledInstance(60, 45, Image.SCALE_SMOOTH);
	Image changeImg5 = img5.getScaledInstance(60, 45, Image.SCALE_SMOOTH);
	
	ImageIcon changeIcon1 = new ImageIcon(changeImg1);
	ImageIcon changeIcon2 = new ImageIcon(changeImg2);
	ImageIcon changeIcon3 = new ImageIcon(changeImg3);
	ImageIcon changeIcon4 = new ImageIcon(changeImg4);
	ImageIcon changeIcon5 = new ImageIcon(changeImg5);
	
			
	//컴포넌트 생성
		JFrame jframe = new JFrame("MP3 Player");
		JButton btn1 = new JButton(changeIcon1);
		JButton btn2 = new JButton(changeIcon2);
		JButton btn3 = new JButton(changeIcon3);
		JButton btn4 = new JButton(changeIcon4);
		JButton btn5 = new JButton(changeIcon5);
			
		public Gui() {

			// 메뉴 출력(), 재생정보 출력()
			ArrayList <MusicVO>playlist = new ArrayList<MusicVO>();
			playlist.add(new MusicVO("Rambling Rose", "Three 1989", 300, "./music/Rambling Rose.mp3"));
			playlist.add(new MusicVO("Room","김성규",262,"./music/Room.mp3"));
			playlist.add(new MusicVO("Plastic Love", "Mariya Takeuchi",476, "./music/Plastic Love.mp3"));
			playlist.add(new MusicVO("Day Dream","Jung Hum",203,"./music/Day Dream.mp3"));	
			playlist.add(new MusicVO("여수밤바다","버스커버스커",282,"./music/여수 밤바다.mp3"));
			playlist.add(new MusicVO("Umm","BoyCold",178,"./music/Umm.mp3"));
			playlist.add(new MusicVO("Gravity","BOA",211,"./music/Gravity.mp3"));
			playlist.add(new MusicVO("잘자","Jimmy Brown",202,"./music/잘자.mp3"));
			
			MusicPlayer mp = new MusicPlayer(playlist);
			
			btn1.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					MusicVO currentMusic = mp.play();
				}
			});
			
			btn2.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {					
					MusicVO randomMusic = mp.random();
				}				
			});
			
			btn3.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {					
					mp.stop();					
				}				
			});
			
			btn4.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {					
					MusicVO previouMusic = mp.previous();
				}				
			});
			
			btn5.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {					
					MusicVO nextMusic = mp.next();		
				}				
			});		

			// 레이아웃 설정
	        jframe.getContentPane().setLayout(null);

			setTitle("MP3 Player");
			
			//버튼 위치 및 크기 설정
			btn1.setBounds(195,10,60,45);
			btn2.setBounds(125,10,50,45);
			btn3.setBounds(275,10,50,45);
			btn4.setBounds(50,10,60,45);
			btn5.setBounds(335,10,60,45);
			
			// 프레임에다가 버튼 추가
	        jframe.getContentPane().add(btn1);
	        jframe.getContentPane().add(btn2);
	        jframe.getContentPane().add(btn3);
	        jframe.getContentPane().add(btn4);
	        jframe.getContentPane().add(btn5);
	        			
			// 프레임 크기 지정
			jframe.setSize(450, 100);
			
			// 프레임 위치 지정
			jframe.setLocationRelativeTo(null);
			
			// 프레임 보이기 설정
			jframe.setVisible(true);
			
			// 프레임 컬러 설정(RGB 컬러)
			jframe.getContentPane().setBackground(new Color(240,240,240));
			
			//버튼 컬러 설정
			btn1.setBackground(new Color(240,240,240));
			btn2.setBackground(new Color(240,240,240));
			btn3.setBackground(new Color(240,240,240));
			btn4.setBackground(new Color(240,240,240));
			btn5.setBackground(new Color(240,240,240));
			
			// 버튼의 Border(외곽선)을 없애준다.
			btn1.setBorderPainted(false);
			btn2.setBorderPainted(false);
			btn3.setBorderPainted(false);
			btn4.setBorderPainted(false);
			btn5.setBorderPainted(false);

			// 버튼의 내용영역 채우기 안함
			btn1.setContentAreaFilled(false);
			btn2.setContentAreaFilled(false);
			btn3.setContentAreaFilled(false);
			btn4.setContentAreaFilled(false);
			btn5.setContentAreaFilled(false);
			
			// 버튼 컬러 투명하게.
			btn1.setOpaque(false);
			btn2.setOpaque(false);
			btn3.setOpaque(false);
			btn4.setOpaque(false);
			btn5.setOpaque(false);
			
			// 종료 버튼 설정
			jframe.setDefaultCloseOperation(Gui.EXIT_ON_CLOSE);		
		}		
}


