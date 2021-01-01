package MP3;

import java.util.ArrayList;

import javazoom.jl.player.MP3Player;


	public class MusicPlayer{			

	//노래리스트,  재생(), 랜덤재생(), 정지(), 이전곡(), 다음곡()
	private ArrayList <MusicVO>playlist = new ArrayList<MusicVO>();
	private MP3Player mp3Player;
	private int index;
	
	public MusicPlayer(ArrayList<MusicVO> playlist) {
		this.playlist = playlist;
		this.mp3Player = new MP3Player();
	}

	public ArrayList<MusicVO> getPlaylist() {
		return playlist;
	}
	
	public void indexNum(int index) {
		if(index < 0) {
			index = playlist.size()-1;
		} else if(index >= playlist.size()) {
			index = 0;
		}
		this.index = index;
	}

	public MusicVO play() {
		MusicVO m = (MusicVO) playlist.get(index);
		if(mp3Player.isPlaying()) {
			mp3Player.stop();
		}
		mp3Player.play(m.getPath());
		System.out.println("노래가 재생됨.");
		return m;
	}	
	
	public MusicVO random() {
		// 0 ~ playlist.size()-1 
		for(int i=0; i<=playlist.size()-1; i++) {
		index = (int) (Math.random()*i);
		}
		System.out.println("랜덤재생 실행.");
		return play();
	}
	
	public void stop() {
		if(mp3Player.isPlaying()) {
			mp3Player.stop();
		}
		System.out.println("노래가 정지됨.");
	}

	public MusicVO previous() {
		indexNum(index-1);		
		System.out.println("이전 곡 재생 실행.");
		return play();
	}

	public MusicVO next() {
		indexNum(index+1);
		System.out.println("다음 곡 재생 실행.");
		return play();
	}

}