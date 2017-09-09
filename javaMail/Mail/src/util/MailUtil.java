package util;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import com.sun.mail.util.MailSSLSocketFactory;

public class MailUtil implements Runnable {
	private String email;// �ռ�������
	private String code;// ������

	public MailUtil(String email, String code) {
		this.email = email;
		this.code = code;
	}

	/*
	163����
	POP3������:pop.163.com
	SMTP������:smtp.163.com
	IMAP������:imap.163.com
	 
	QQ����
	POP3��pop.qq.com
	SMTP��smtp.qq.com
	SMTP�˿ںţ�25
	 
	yahoo����smtp������
	�ӣ�pop.mail.yahoo.com.cn
	����smtp.mail.yahoo.com
	 
	126����smtp������
	pop�� pop.126.com
	smtp�� smtp.126.com*/
	
	
	public void run() {
		// 1.�������Ӷ���javax.mail.Session
		// 2.�����ʼ����� javax.mail.Message
		// 3.����һ�⼤���ʼ�
		String from = "xfybgq@163.com";// �����˵�������
		String host = "smtp.163.com"; // ָ�������ʼ�������smtp.qq.com(QQ)|smtp.163.com(����)

		Properties properties = System.getProperties();// ��ȡϵͳ����

		properties.setProperty("mail.smtp.host", host);// �����ʼ�������
		properties.setProperty("mail.smtp.auth", "true");// ����֤

		try {
			//QQ������Ҫ������δ��룬163���䲻��Ҫ
			MailSSLSocketFactory sf = new MailSSLSocketFactory();
			sf.setTrustAllHosts(true);
			properties.put("mail.smtp.ssl.enable", "true");
			properties.put("mail.smtp.ssl.socketFactory", sf);
			
			
			// 1.��ȡĬ��session����
			Session session = Session.getDefaultInstance(properties, new Authenticator() {
				public PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("xfybgq@163.com", "byebye8812"); // �����������˺š���Ȩ��
				}
			});

			// 2.�����ʼ�����
			Message message = new MimeMessage(session);
			// 2.1���÷�����
			message.setFrom(new InternetAddress(from));
			// 2.2���ý�����
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
			// 2.3�����ʼ�����
			message.setSubject("�˺ż���");
			// 2.4�����ʼ�����
			String content = "<html><head></head><body>"
					+ "<h1 style='color:red;margin:0 auto;'>����һ�⼤���ʼ�,����������������</h1>"
					+ "<h3><a href='http://localhost:8080/RegisterDemo/ActiveServlet?code="
					+ code + "'>http://localhost:8080/RegisterDemo/ActiveServlet?code=" + code
					+ "</href></h3></body></html>";
			message.setContent(content, "text/html;charset=UTF-8");
			// 3.�����ʼ�
			Transport.send(message);
			System.out.println("�ʼ��ɹ�����!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
