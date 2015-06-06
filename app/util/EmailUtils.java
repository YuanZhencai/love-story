package util;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import vo.AddressDetail;
import vo.Location;

import java.text.MessageFormat;

/**
 * Created by Administrator on 2015/6/6.
 */
public class EmailUtils {
    public static String template(Location location) {
        String date = DateFormatUtils.format(location.getDate(), String.valueOf("EEE, MMM d, hh:mm aaa"));
            AddressDetail detail = location.getContent().getAddressDetail();
            String htmlTemplate = "<html xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
                "<head>\n" +
                "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n" +
                "<title>Yuan's Love Story</title>\n" +
                "</head>\n" +
                "\n" +
                "<body style=\"background-color: #7c210e;\">\n" +
                "<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n" +
                "  <tr>\n" +
                "    <td align=\"center\" valign=\"top\" bgcolor=\"#7c210e\"><br>\n" +
                "    <br>\n" +
                "    <table width=\"600\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n" +
                "     \n" +
                "      <tr>\n" +
                "        <td align=\"center\" valign=\"top\" bgcolor=\"#ffffff\" style=\"background-color:#ffffff; font-family:Arial, Helvetica, sans-serif; font-size:13px; color:#000000; padding:0px 15px 0px 15px;\">\n" +
                "          <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n" +
                "            <tr>\n" +
                "              <td align=\"left\" valign=\"top\" style=\"font-size:13px; font-family:Arial, Helvetica, sans-serif; color:#000000;\">\n" +
                "              <div style=\"font-family:Georgia, 'Times New Roman', Times, serif; font-size:72px; color:#95160a;\"><i>Yuan's Love Story</i></div>\n" +
                "              <div style=\"font-size:24px; color:#95160a;\">" + date + "</div>\n" +
                "              <div style=\"font-size:16px;\"><br>\n" +
                "                Tang binyan accept Yuan zhencai to be the girl firend .</div>\n" +
                "              \n" +
                "              <div><br>\n" +
                "              \n" +
                "\t\t\t\tLocation: " + MessageFormat.format("{0} {1}", detail.getProvince(), detail.getCity()) + "<br>\n" +
                "\t\t\t\tIp: 127.0.0.1<br>\n" +
                "<br>\n" +
                "              </div></td>\n" +
                "              <td width=\"210\" align=\"center\" valign=\"top\"></td>\n" +
                "            </tr>\n" +
                "          </table></td>\n" +
                "      </tr>\n" +
                "      \n" +
                "  </table>\n" +
                "    <br>\n" +
                "    <br></td>\n" +
                "  </tr>\n" +
                "</table>\n" +
                "</body>\n" +
                "</html>\n";
        return htmlTemplate;
    }
}
