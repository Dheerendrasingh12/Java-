<%@ page import="net.tanesha.recaptcha.ReCaptcha"%>
<%@ page import="net.tanesha.recaptcha.ReCaptchaFactory"%>

<html><H1 style="text-align: center;color: red">File Uploading with Captcha</H1>
	<body background="FileUpload.png">
		<form action="fileurl" method="POST" enctype="multipart/form-data" style="text-align: center">
		Select File1::	<input type="file" name="f1"><br>
		Select File2:: 	<input type="file" name="f2"><br>
			
		<center>	<%
			ReCaptcha captcha=ReCaptchaFactory.newReCaptcha("6LcRUT4UAAAAABHwTxtw1jFqgne5zPhssdAebenv","6LcRUT4UAAAAACJ-yioczyfCpsTfR6ry3Ol6lvqN",false);
				out.print(captcha.createRecaptchaHtml(null, null));
			 %><br>
		<input type="submit" value="submit">
		</center>
		
		
		</form>
	</body>

</html>