package org.earthQuake.course.common.msg.req;

/**
 * ��Ƶ��Ϣ
 * 
 * @author xuxiaoliang
 * @date 2014-01-06
 */
public class ReqVoiceMessage extends ReqBaseMessage {
	// ý��ID
	private String MediaId;
	// ������ʽ
	private String Format;

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}

	public String getFormat() {
		return Format;
	}

	public void setFormat(String format) {
		Format = format;
	}
}
