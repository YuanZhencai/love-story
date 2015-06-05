package services;

import play.libs.mailer.Email;
import play.libs.mailer.MailerPlugin;

public class MailService {


	public boolean sendEmail (Email email) {
		if (email != null) {
			MailerPlugin.send(email);
			return true;
		} else {
			return false;
		}
	}
}