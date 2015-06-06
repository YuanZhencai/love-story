package services;

import play.Logger;
import play.libs.mailer.Email;
import play.libs.mailer.MailerPlugin;

import java.util.Date;

public class MailService {


	public boolean sendEmail (Email email) {
		if (email != null) {
			MailerPlugin.send(email);
			Logger.info("send email success " + new Date());
			return true;
		} else {
			return false;
		}
	}
}