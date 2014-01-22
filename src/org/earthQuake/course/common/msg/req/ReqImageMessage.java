package org.earthQuake.course.common.msg.req;

/**
 * 图片消息
 * 
 * @author xuxiaoliang
 * @date 2014-01-06
 */
public class ReqImageMessage extends ReqBaseMessage {
	// 图片链接
	private String PicUrl;

	public String getPicUrl() {
		return PicUrl;
	}

	public void setPicUrl(String picUrl) {
		PicUrl = picUrl;
	}
}
