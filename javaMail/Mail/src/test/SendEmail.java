package test;

import util.MailUtil;

public class SendEmail {
	public static void main(String[] args) {
		new Thread(new MailUtil("2624174289@qq.com", "1324")).start();
	}
}
