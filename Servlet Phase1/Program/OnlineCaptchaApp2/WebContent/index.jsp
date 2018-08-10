<%@ page import="net.tanesha.recaptcha.ReCaptcha" %>
    <%@ page import="net.tanesha.recaptcha.ReCaptchaFactory" %>

    <html>
      <body>
        <form action="verify.jsp" method="post">
        <%
          //ReCaptcha c = ReCaptchaFactory.newReCaptcha("your_public_key", "your_private_key", false);
        ReCaptcha captcha = ReCaptchaFactory.newReCaptcha("6LcFNT4UAAAAAD9_9hNDM_exVrNde1pb4dEKiPGd", "6LcFNT4UAAAAAPjhJx_QTsHIBzo-2AkKgsDp1Y-V", false);
          out.print(captcha.createRecaptchaHtml(null, null));
        %>
        <input type="submit" value="submit" />
        </form>
      </body>
    </html>
