package org.earthQuake.course.common.msg.resp;

import java.util.List;

/**
 * �ı���Ϣ
 * 
 * @author xuxiaoliang
 * @date 2014-01-06
 */
public class RespNewsMessage extends RespBaseMessage {
	// ͼ����Ϣ����������Ϊ10������
	private int ArticleCount;
	// ����ͼ����Ϣ��Ϣ��Ĭ�ϵ�һ��itemΪ��ͼ
	private List<Article> Articles;

	public int getArticleCount() {
		return ArticleCount;
	}

	public void setArticleCount(int articleCount) {
		ArticleCount = articleCount;
	}

	public List<Article> getArticles() {
		return Articles;
	}

	public void setArticles(List<Article> articles) {
		Articles = articles;
	}
}
