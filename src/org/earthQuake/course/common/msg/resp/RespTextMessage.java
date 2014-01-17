package org.earthQuake.course.common.msg.resp;

/**
 * 文本消息
 * 
 * @author xuxiaoliang
 * @date 2014-01-06
 */
public class RespTextMessage extends RespBaseMessage {
	// 回复的消息内容
	private String Content;

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}
}