package org.earthQuake.course.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.earthQuake.course.common.EarthQuakeUtil;
import org.earthQuake.course.common.MessageUtil;
import org.earthQuake.course.common.bean.TabMenuDetail;
import org.earthQuake.course.common.msg.resp.RespTextMessage;
import org.earthQuake.course.dao.MenuDao;

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
				if(EarthQuakeUtil.isQqFace(content)) {
					respContent = content;
				}
				 
				
				if(content.equals("1")){
					respContent = "���ڲ�ѯȫ��24Сʱ�ڵĵ�����Ϣ";
				}else if(content.equals("2")){
					respContent = "���ڲ�ѯȫ��48Сʱ�ڵĵ�����Ϣ";
				}else if(content.equals("3")){
					respContent = "���ڲ�ѯȫ�������Ϣ";
				}else if(content.equals("4")){
					respContent = "���ڲ�ѯ�й�������Ϣ";
				}else if(content.equals("5")){
					respContent = "���ڲ�ѯ�㽭������Ϣ";
				}else if(content.equals("0")){
					respContent = session.getAttribute("menu").toString();
				}
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
}
