package org.earthQuake.course.common.msg.resp;

/**
 * ������Ϣ
 * 
 * @author xuxiaoliang
 * @date 2014-01-06
 */
public class RespMusicMessage extends RespBaseMessage {
	// ����
	private Music Music;

	public Music getMusic() {
		return Music;
	}

	public void setMusic(Music music) {
		Music = music;
	}
}