package org.earthQuake.course.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.earthQuake.course.common.MessageUtil;
import org.earthQuake.course.common.msg.resp.Article;
import org.earthQuake.course.common.msg.resp.RespNewsMessage;
import org.earthQuake.course.common.msg.resp.RespTextMessage;

/**
 * ���ķ�����
 * 
 * @author xuxiaoliang
 * @date 2014-01-06
 */
public class CoreService {
	
	/**
	 * ����΢�ŷ���������
	 * 
	 * @param request
	 * @return
	 */
	public static String processRequest(HttpServletRequest request) {
		String respMessage = null;
		HttpSession session = request.getSession();
		try {
			// Ĭ�Ϸ��ص��ı���Ϣ����
			String respContent = "�������쳣�����Ժ��ԣ�";

			// xml�������
			Map<String, String> requestMap = MessageUtil.parseXml(request);

			// ���ͷ��ʺţ�open_id��
			String fromUserName = requestMap.get("FromUserName");
			// �����ʺ�
			String toUserName = requestMap.get("ToUserName");
			// ��Ϣ����
			String msgType = requestMap.get("MsgType");

			// �ظ��ı���Ϣ
			RespTextMessage textMessage = new RespTextMessage();
			textMessage.setToUserName(fromUserName);
			textMessage.setFromUserName(toUserName);
			textMessage.setCreateTime(new Date().getTime());
			textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
			textMessage.setFuncFlag(0);

			// �ı���Ϣ
			if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {
				// �ı���Ϣ����
				String content = requestMap.get("Content");
				
				// �ж��û����͵��Ƿ��ǵ���QQ����
//				if(EarthQuakeUtil.isQqFace(content)) {
//					respContent = content;
//				}
				// ����ͼ����Ϣ
				RespNewsMessage newsMessage = new RespNewsMessage();
				newsMessage.setToUserName(fromUserName);
				newsMessage.setFromUserName(toUserName);
				newsMessage.setCreateTime(new Date().getTime());
				newsMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);
				newsMessage.setFuncFlag(0);

				List<Article> articleList = new ArrayList<Article>();
				// ��ͼ����Ϣ
				if ("1".equals(content)) {
					
					Article article1 = new Article();
					article1.setTitle("ȫ��24Сʱ�ڵĵ�����Ϣ");
					article1.setDescription("");
					article1.setPicUrl("http://qq370273662.oicp.net/EQWeiXin/images/title.jpg");
					article1.setUrl("#");

					Article article2 = new Article();
					article2.setTitle("2014-01-07 02:49:00̨���±��и�������(122.6,25.5)�𼶣�4.4�� ��ȣ�216����");
					article2.setDescription("");
					article2.setPicUrl("http://qq370273662.oicp.net/EQWeiXin/images/1.jpg");
					article2.setUrl("http://www.baidu.com");

					Article article3 = new Article();
					article3.setTitle("2014-01-07 02:49:00̨���±��и�������(122.6,25.5)�𼶣�4.4�� ��ȣ�216����");
					article3.setDescription("");
					article3.setPicUrl("http://qq370273662.oicp.net/EQWeiXin/images/2.jpg");
					article3.setUrl("http://www.baidu.com");

					Article article4 = new Article();
					article4.setTitle("2014-01-07 02:49:00̨���±��и�������(122.6,25.5)�𼶣�4.4�� ��ȣ�216����3");
					article4.setDescription("");
					article4.setPicUrl("http://qq370273662.oicp.net/EQWeiXin/images/3.jpg");
					article4.setUrl("http://www.baidu.com");

					Article article5 = new Article();
					article5.setTitle("���������Ϣ���¼www.xxxx.com");
					article5.setDescription("");
					// ��ͼƬ��Ϊ��
					article5.setPicUrl("");
					article5.setUrl("http://www.baidu.com");

					articleList.add(article1);
					articleList.add(article2);
					articleList.add(article3);
					articleList.add(article4);
					articleList.add(article5);
					newsMessage.setArticleCount(articleList.size());
					newsMessage.setArticles(articleList);
					return respMessage = MessageUtil.newsMessageToXml(newsMessage);
					
//					Article article = new Article();
//					article.setTitle("ȫ��24Сʱ�ڵĵ�����Ϣ");
//					article.setDescription("���ڲ�ѯȫ��24Сʱ�ڵĵ�����Ϣ...");
//					article.setPicUrl("http://qq370273662.oicp.net/EQWeiXin/images/title.jpg");
//					article.setUrl("http://www.baidu.com");
//					articleList.add(article);
//					// ����ͼ����Ϣ����
//					newsMessage.setArticleCount(articleList.size());
//					// ����ͼ����Ϣ������ͼ�ļ���
//					newsMessage.setArticles(articleList);
//					// ��ͼ����Ϣ����ת����xml�ַ���
//					return respMessage = MessageUtil.newsMessageToXml(newsMessage);
				}
				// ��ͼ����Ϣ---����ͼƬ
				else if ("2".equals(content)) {
					
					Article article1 = new Article();
					article1.setTitle("ȫ��48Сʱ�ڵĵ�����Ϣ");
					article1.setDescription("");
					article1.setPicUrl("http://qq370273662.oicp.net/EQWeiXin/images/title.jpg");
					article1.setUrl("#");

					Article article2 = new Article();
					article2.setTitle("2014-01-07 02:49:00̨������и�������(122.6,25.5)�𼶣�4.4�� ��ȣ�216����");
					article2.setDescription("");
					article2.setPicUrl("http://qq370273662.oicp.net/EQWeiXin/images/4.jpg");
					article2.setUrl("http://www.baidu.com");

					Article article3 = new Article();
					article3.setTitle("2014-01-07 02:49:00̨������и�������(122.6,25.5)�𼶣�4.4�� ��ȣ�216����");
					article3.setDescription("");
					article3.setPicUrl("http://qq370273662.oicp.net/EQWeiXin/images/5.jpg");
					article3.setUrl("http://www.baidu.com");

					Article article4 = new Article();
					article4.setTitle("2014-01-07 02:49:00̨������и�������(122.6,25.5)�𼶣�4.4�� ��ȣ�216����");
					article4.setDescription("");
					article4.setPicUrl("http://qq370273662.oicp.net/EQWeiXin/images/6.jpg");
					article4.setUrl("http://www.baidu.com");

					Article article5 = new Article();
					article5.setTitle("���������Ϣ���¼www.xxxx.com");
					article5.setDescription("");
					// ��ͼƬ��Ϊ��
					article5.setPicUrl("");
					article5.setUrl("http://www.baidu.com");

					articleList.add(article1);
					articleList.add(article2);
					articleList.add(article3);
					articleList.add(article4);
					articleList.add(article5);
					newsMessage.setArticleCount(articleList.size());
					newsMessage.setArticles(articleList);
					return respMessage = MessageUtil.newsMessageToXml(newsMessage);
					
//					Article article = new Article();
//					article.setTitle("ȫ��48Сʱ�ڵĵ�����Ϣ");
//					// ͼ����Ϣ�п���ʹ��QQ���顢���ű���
//					article.setDescription("������Ϣ" + emoji(0x1F6B9)
//							+ "���ڲ�ѯȫ��48Сʱ�ڵĵ�����Ϣ");
//					// ��ͼƬ��Ϊ��
//					article.setPicUrl("");
//					article.setUrl("http://www.baidu.com");
//					articleList.add(article);
//					newsMessage.setArticleCount(articleList.size());
//					newsMessage.setArticles(articleList);
//					return respMessage = MessageUtil.newsMessageToXml(newsMessage);
				}
				// ��ͼ����Ϣ---���һ����Ϣ����ͼƬ
				else if ("3".equals(content)) {
					Article article1 = new Article();
					article1.setTitle("�㽭������Ϣ");
					article1.setDescription("");
					article1.setPicUrl("http://qq370273662.oicp.net/EQWeiXin/images/title.jpg");
					article1.setUrl("#");

					Article article2 = new Article();
					article2.setTitle("2014-01-07 02:49:00����ʡ�����и�������(122.6,25.5)�𼶣�4.4�� ��ȣ�216����");
					article2.setDescription("");
					article2.setPicUrl("http://qq370273662.oicp.net/EQWeiXin/images/7.jpg");
					article2.setUrl("http://www.baidu.com");

					Article article3 = new Article();
					article3.setTitle("2014-01-07 02:49:00����ʡ�����и�������(122.6,25.5)�𼶣�4.4�� ��ȣ�216����");
					article3.setDescription("");
					article3.setPicUrl("http://qq370273662.oicp.net/EQWeiXin/images/8.jpg");
					article3.setUrl("http://www.baidu.com");

					Article article4 = new Article();
					article4.setTitle("2014-01-07 02:49:00����ʡ�����и�������(122.6,25.5)�𼶣�4.4�� ��ȣ�216����");
					article4.setDescription("");
					article4.setPicUrl("http://qq370273662.oicp.net/EQWeiXin/images/9.jpg");
					article4.setUrl("http://www.baidu.com");

					Article article5 = new Article();
					article5.setTitle("���������Ϣ���¼www.xxxx.com");
					article5.setDescription("");
					// ��ͼƬ��Ϊ��
					article5.setPicUrl("");
					article5.setUrl("http://www.baidu.com");

					articleList.add(article1);
					articleList.add(article2);
					articleList.add(article3);
					articleList.add(article4);
					articleList.add(article5);
					newsMessage.setArticleCount(articleList.size());
					newsMessage.setArticles(articleList);
					return respMessage = MessageUtil.newsMessageToXml(newsMessage);
				}
				// ����֪ʶ�ؼ��ֲ�ѯ
				else if ("4".equals(content)) {
					StringBuffer sbf = new StringBuffer();
					sbf.append("1����").append("\n");
					sbf.append("2���Ҷ�").append("\n");
					sbf.append("3������ǰ����").append("\n");
					sbf.append("4������Ӧ����ʩ").append("\n");
					sbf.append("5������֪ʶ").append("\n");
					sbf.append("�ؼ��ֲ�ѯ(��ʽ��4��ͷ�ӹؼ�����ţ����磺41),��Ҫ��ѯ���ǣ�").append("\n");
					respContent = sbf.toString();
				}
				// ����֪ʶ��ѯ
				else if ("5".equals(content)) {
					respContent = "֪ʶ��ѯ(��ʽ��5��ͷ�Ӳ�ѯ���ݣ����磺5��),��Ҫ��ѯ���ǣ�";
				}
				else if(content.equals("0")){
					respContent = session.getAttribute("menu").toString();
				}
				else if(content.substring(0,1).equals("4")){
					String keyword = content.substring(1, content.length());
					if("1".equals(keyword)){
						respContent = "���ǡ�������";
					}else if("2".equals(keyword)){
						respContent = "�Ҷ��ǡ�������";
					}else if("3".equals(keyword)){
						respContent = "����ǰ�����ǡ�������";
					}else if("4".equals(keyword)){
						respContent = "����Ӧ����ʩ�ǡ�������";
					}else if("5".equals(keyword)){
						respContent = "����֪ʶ�ǡ�������";
					}
				}
				else if(content.substring(0,1).equals("5")){
					String keyword = content.substring(1, content.length());
						respContent = keyword + "����֪ʶ��ѯ��������";
				}
				else{
					respContent = "��������������ȷ��������ȷ�Ĳ˵�ѡ�";
				}
				
//				if(content.equals("1")){
//					respContent = "���ڲ�ѯȫ��24Сʱ�ڵĵ�����Ϣ";
//				}else if(content.equals("2")){
//					respContent = "���ڲ�ѯȫ��48Сʱ�ڵĵ�����Ϣ";
//				}else if(content.equals("3")){
//					respContent = "���ڲ�ѯȫ�������Ϣ";
//				}else if(content.equals("4")){
//					respContent = "���ڲ�ѯ�й�������Ϣ";
//				}else if(content.equals("5")){
//					respContent = "���ڲ�ѯ�㽭������Ϣ";
//				}else if(content.equals("0")){
//					respContent = session.getAttribute("menu").toString();
//				}
			}
			// ͼƬ��Ϣ
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) {
				respContent = "�����͵���ͼƬ��Ϣ��";
			}
			// ����λ����Ϣ
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {
				respContent = "�����͵��ǵ���λ����Ϣ��";
			}
			// ������Ϣ
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) {
				respContent = "�����͵���������Ϣ��";
			}
			// ��Ƶ��Ϣ
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) {
				respContent = "�����͵�����Ƶ��Ϣ��";
			}
			// �¼�����
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {
				// �¼�����
				String eventType = requestMap.get("Event");
				// ����
				if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {
					respContent = session.getAttribute("menu").toString();
				}
				// ȡ������
				else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {
					// TODO ȡ�����ĺ��û����ղ������ںŷ��͵���Ϣ����˲���Ҫ�ظ���Ϣ
				}
				// �Զ���˵�����¼�
				else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {
					// TODO �Զ���˵�Ȩû�п��ţ��ݲ����������Ϣ
				}
			}

			textMessage.setContent(respContent);
			respMessage = MessageUtil.textMessageToXml(textMessage);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return respMessage;
	}
	
	/**
	 * emoji����ת��(hex -> utf-16)
	 * 
	 * @param hexEmoji
	 * @return
	 */
	public static String emoji(int hexEmoji) {
		return String.valueOf(Character.toChars(hexEmoji));
	}
}
