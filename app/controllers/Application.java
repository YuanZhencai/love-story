package controllers;

import com.google.inject.Inject;
import play.libs.Json;
import play.libs.mailer.Email;
import play.mvc.Controller;
import play.mvc.Result;
import services.MailService;
import views.html.index;
import views.html.loveStory;

public class Application extends Controller {

    @Inject
    private MailService mailService;

    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }

    public static Result loveStory() {
        return ok(loveStory.render());
    }

    public Result accept() {
        Email email = new Email();

        email.setSubject("Yuan's love story");
        email.setFrom("Love Story <zhencai.yuan@51jdj.com>");
        email.addTo("zhencai.yuan@51jdj.com");
        // adds attachment
        //email.addAttachment("attachment.pdf", new File("/some/path/attachment.pdf"));
        // adds inline attachment from byte array
        //email.addAttachment("data.txt", "data".getBytes(), "text/plain", "Simple data", EmailAttachment.INLINE);
        // sends text, HTML or both...
        //email.setBodyText("A text message");
        email.setBodyHtml("<html><body><p>Tang binyan accept Yuan zhencai to be the girl firend.</p></body></html>");
        mailService.sendEmail(email);
        return ok(Json.toJson(email));
    }

}
