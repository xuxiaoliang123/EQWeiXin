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
 * 核心服务类
 * 
 * @author xuxiaoliang
 * @date 2014-01-06
 */
public class CoreService {
	
	/**
	 * 处理微信发来的请求
	 * 
	 * @param request
	 * @return
	 */
	public static String processRequest(HttpServletRequest request) {
		String respMessage = null;
		HttpSession session = request.getSession();
		try {
			// 默认返回的文本消息内容
			String respContent = "请求处理异常，请稍候尝试！";

			// xml请求解析
			Map<String, String> requestMap = MessageUtil.parseXml(request);

			// 发送方帐号（open_id）
			String fromUserName = requestMap.get("FromUserName");
			// 公众帐号
			String toUserName = requestMap.get("ToUserName");
			// 消息类型
			String msgType = requestMap.get("MsgType");

			// 回复文本消息
			RespTextMessage textMessage = new RespTextMessage();
			textMessage.setToUserName(fromUserName);
			textMessage.setFromUserName(toUserName);
			textMessage.setCreateTime(new Date().getTime());
			textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
			textMessage.setFuncFlag(0);

			// 文本消息
			if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {
				// 文本消息内容
				String content = requestMap.get("Content");
				
				// 判断用户发送的是否是单个QQ表情
//				if(EarthQuakeUtil.isQqFace(content)) {
//					respContent = content;
//				}
				// 创建图文消息
				RespNewsMessage newsMessage = new RespNewsMessage();
				newsMessage.setToUserName(fromUserName);
				newsMessage.setFromUserName(toUserName);
				newsMessage.setCreateTime(new Date().getTime());
				newsMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);
				newsMessage.setFuncFlag(0);

				List<Article> articleList = new ArrayList<Article>();
				// 单图文消息
				if ("1".equals(content)) {
					
					Article article1 = new Article();
					article1.setTitle("全球24小时内的地震信息");
					article1.setDescription("");
					article1.setPicUrl("http://qq370273662.oicp.net/EQWeiXin/images/title.jpg");
					article1.setUrl("#");

					Article article2 = new Article();
					article2.setTitle("2014-01-07 02:49:00台湾新北市附近海域(122.6,25.5)震级：4.4级 深度：216公里");
					article2.setDescription("");
					article2.setPicUrl("http://qq370273662.oicp.net/EQWeiXin/images/1.jpg");
					article2.setUrl("http://www.baidu.com");

					Article article3 = new Article();
					article3.setTitle("2014-01-07 02:49:00台湾新北市附近海域(122.6,25.5)震级：4.4级 深度：216公里");
					article3.setDescription("");
					article3.setPicUrl("http://qq370273662.oicp.net/EQWeiXin/images/2.jpg");
					article3.setUrl("http://www.baidu.com");

					Article article4 = new Article();
					article4.setTitle("2014-01-07 02:49:00台湾新北市附近海域(122.6,25.5)震级：4.4级 深度：216公里3");
					article4.setDescription("");
					article4.setPicUrl("http://qq370273662.oicp.net/EQWeiXin/images/3.jpg");
					article4.setUrl("http://www.baidu.com");

					Article article5 = new Article();
					article5.setTitle("更多地震信息请登录www.xxxx.com");
					article5.setDescription("");
					// 将图片置为空
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
//					article.setTitle("全球24小时内的地震信息");
//					article.setDescription("正在查询全球24小时内的地震信息...");
//					article.setPicUrl("http://qq370273662.oicp.net/EQWeiXin/images/title.jpg");
//					article.setUrl("http://www.baidu.com");
//					articleList.add(article);
//					// 设置图文消息个数
//					newsMessage.setArticleCount(articleList.size());
//					// 设置图文消息包含的图文集合
//					newsMessage.setArticles(articleList);
//					// 将图文消息对象转换成xml字符串
//					return respMessage = MessageUtil.newsMessageToXml(newsMessage);
				}
				// 单图文消息---不含图片
				else if ("2".equals(content)) {
					
					Article article1 = new Article();
					article1.setTitle("全球48小时内的地震信息");
					article1.setDescription("");
					article1.setPicUrl("http://qq370273662.oicp.net/EQWeiXin/images/title.jpg");
					article1.setUrl("#");

					Article article2 = new Article();
					article2.setTitle("2014-01-07 02:49:00台湾高雄市附近海域(122.6,25.5)震级：4.4级 深度：216公里");
					article2.setDescription("");
					article2.setPicUrl("http://qq370273662.oicp.net/EQWeiXin/images/4.jpg");
					article2.setUrl("http://www.baidu.com");

					Article article3 = new Article();
					article3.setTitle("2014-01-07 02:49:00台湾高雄市附近海域(122.6,25.5)震级：4.4级 深度：216公里");
					article3.setDescription("");
					article3.setPicUrl("http://qq370273662.oicp.net/EQWeiXin/images/5.jpg");
					article3.setUrl("http://www.baidu.com");

					Article article4 = new Article();
					article4.setTitle("2014-01-07 02:49:00台湾高雄市附近海域(122.6,25.5)震级：4.4级 深度：216公里");
					article4.setDescription("");
					article4.setPicUrl("http://qq370273662.oicp.net/EQWeiXin/images/6.jpg");
					article4.setUrl("http://www.baidu.com");

					Article article5 = new Article();
					article5.setTitle("更多地震信息请登录www.xxxx.com");
					article5.setDescription("");
					// 将图片置为空
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
//					article.setTitle("全球48小时内的地震信息");
//					// 图文消息中可以使用QQ表情、符号表情
//					article.setDescription("地震信息" + emoji(0x1F6B9)
//							+ "正在查询全球48小时内的地震信息");
//					// 将图片置为空
//					article.setPicUrl("");
//					article.setUrl("http://www.baidu.com");
//					articleList.add(article);
//					newsMessage.setArticleCount(articleList.size());
//					newsMessage.setArticles(articleList);
//					return respMessage = MessageUtil.newsMessageToXml(newsMessage);
				}
				// 多图文消息---最后一条消息不含图片
				else if ("3".equals(content)) {
					Article article1 = new Article();
					article1.setTitle("浙江地震信息");
					article1.setDescription("");
					article1.setPicUrl("http://qq370273662.oicp.net/EQWeiXin/images/title.jpg");
					article1.setUrl("#");

					Article article2 = new Article();
					article2.setTitle("2014-01-07 02:49:00福建省莆田市附近海域(122.6,25.5)震级：4.4级 深度：216公里");
					article2.setDescription("");
					article2.setPicUrl("http://qq370273662.oicp.net/EQWeiXin/images/7.jpg");
					article2.setUrl("http://www.baidu.com");

					Article article3 = new Article();
					article3.setTitle("2014-01-07 02:49:00福建省莆田市附近海域(122.6,25.5)震级：4.4级 深度：216公里");
					article3.setDescription("");
					article3.setPicUrl("http://qq370273662.oicp.net/EQWeiXin/images/8.jpg");
					article3.setUrl("http://www.baidu.com");

					Article article4 = new Article();
					article4.setTitle("2014-01-07 02:49:00福建省莆田市附近海域(122.6,25.5)震级：4.4级 深度：216公里");
					article4.setDescription("");
					article4.setPicUrl("http://qq370273662.oicp.net/EQWeiXin/images/9.jpg");
					article4.setUrl("http://www.baidu.com");

					Article article5 = new Article();
					article5.setTitle("更多地震信息请登录www.xxxx.com");
					article5.setDescription("");
					// 将图片置为空
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
				// 地震知识关键字查询
				else if ("4".equals(content)) {
					StringBuffer sbf = new StringBuffer();
					sbf.append("1、震级").append("\n");
					sbf.append("2、烈度").append("\n");
					sbf.append("3、地震前征兆").append("\n");
					sbf.append("4、地震应急措施").append("\n");
					sbf.append("5、抢救知识").append("\n");
					sbf.append("关键字查询(格式以4开头加关键字序号，例如：41),您要查询的是：").append("\n");
					respContent = sbf.toString();
				}
				// 地震知识咨询
				else if ("5".equals(content)) {
					respContent = "知识咨询(格式以5开头加查询内容，例如：5震级),您要查询的是：";
				}
				else if(content.equals("0")){
					respContent = session.getAttribute("menu").toString();
				}
				else if(content.substring(0,1).equals("4")){
					String keyword = content.substring(1, content.length());
					if("1".equals(keyword)){
						respContent = "震级是。。。。";
					}else if("2".equals(keyword)){
						respContent = "烈度是。。。。";
					}else if("3".equals(keyword)){
						respContent = "地震前征兆是。。。。";
					}else if("4".equals(keyword)){
						respContent = "地震应急措施是。。。。";
					}else if("5".equals(keyword)){
						respContent = "抢救知识是。。。。";
					}
				}
				else if(content.substring(0,1).equals("5")){
					String keyword = content.substring(1, content.length());
						respContent = keyword + "地震知识查询。。。。";
				}
				else{
					respContent = "您的输入有误，请确保输入正确的菜单选项！";
				}
				
//				if(content.equals("1")){
//					respContent = "正在查询全球24小时内的地震信息";
//				}else if(content.equals("2")){
//					respContent = "正在查询全球48小时内的地震信息";
//				}else if(content.equals("3")){
//					respContent = "正在查询全球地震信息";
//				}else if(content.equals("4")){
//					respContent = "正在查询中国地震信息";
//				}else if(content.equals("5")){
//					respContent = "正在查询浙江地震信息";
//				}else if(content.equals("0")){
//					respContent = session.getAttribute("menu").toString();
//				}
			}
			// 图片消息
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) {
				respContent = "您发送的是图片消息！";
			}
			// 地理位置消息
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {
				respContent = "您发送的是地理位置消息！";
			}
			// 链接消息
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) {
				respContent = "您发送的是链接消息！";
			}
			// 音频消息
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) {
				respContent = "您发送的是音频消息！";
			}
			// 事件推送
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {
				// 事件类型
				String eventType = requestMap.get("Event");
				// 订阅
				if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {
					respContent = session.getAttribute("menu").toString();
				}
				// 取消订阅
				else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {
					// TODO 取消订阅后用户再收不到公众号发送的消息，因此不需要回复消息
				}
				// 自定义菜单点击事件
				else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {
					// TODO 自定义菜单权没有开放，暂不处理该类消息
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
	 * emoji表情转换(hex -> utf-16)
	 * 
	 * @param hexEmoji
	 * @return
	 */
	public static String emoji(int hexEmoji) {
		return String.valueOf(Character.toChars(hexEmoji));
	}
}
