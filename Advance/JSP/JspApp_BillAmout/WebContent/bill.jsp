
	<%
		String iname = request.getParameter("iname");
		float price = Float.parseFloat(request.getParameter("iprice"));
		float qty = Float.parseFloat(request.getParameter("iqty"));

		float billAmt = 0;
		billAmt = price * qty;
		if (billAmt >= 50000) {
	%>
	<jsp:forward page="discount.jsp">
		<jsp:param value="<%=billAmt%>" name="billAmt" />
	</jsp:forward>
	<%
		} else {
	%>


	item name:
	<%=iname%><br> Bill Amount:
	<%=billAmt%><br>

	<%
		}
	%>
</body>
</html>