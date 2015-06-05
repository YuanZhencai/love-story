package controllers;

import play.*;
import play.mvc.*;
import play.libs.mailer.Email;
import javax.inject.Inject;


import views.html.*;

public class Application extends Controller {

	@Inject
	private MailService mailService;

    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }

    public static Result accept() {
    	Email email = new Email();

		email.setSubject("Yuan's love story");
	    email.setFrom("Send FROM <http://yuanzhencai-play-java.daoapp.io/>");
	    email.addTo("zhencai.yuan@51jdj.com");
	    // adds attachment
	    //email.addAttachment("attachment.pdf", new File("/some/path/attachment.pdf"));
	    // adds inline attachment from byte array
	    //email.addAttachment("data.txt", "data".getBytes(), "text/plain", "Simple data", EmailAttachment.INLINE);
	    // sends text, HTML or both...
	    //email.setBodyText("A text message");
	    email.setBodyHtml("<html><body><p>Tao binyan accept Yuan zhencai to be the girl firend.</p></body></html>");
    	mailService.send(email);
    }

}
