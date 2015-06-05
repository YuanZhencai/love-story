package services;

import play.libs.mailer.Email;
import play.libs.mailer.MailerClient;

public class MailService {

	@Inject ]
	private MailerClient mailerClient;

	public boolean sendEmail (Email email) {
		if (email != null) {
			mailerClient.send(Email)
			return true;
		} else {
			return false;
		}
	}
}