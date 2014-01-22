package org.earthQuake.course.common.msg.resp;

/**
 * 音乐消息
 * 
 * @author xuxiaoliang
 * @date 2014-01-06
 */
public class RespMusicMessage extends RespBaseMessage {
	// 音乐
	private Music Music;

	public Music getMusic() {
		return Music;
	}

	public void setMusic(Music music) {
		Music = music;
	}
}