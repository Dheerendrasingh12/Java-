
 <!-- Create or locate Bean class object -->
<jsp:useBean id="rotator"  class="com.nt.model.Rotator"  scope="application"/>
<!-- Call getNextAdd() method -->
<jsp:getProperty name="rotator" property="nextAdd" />
<!-- Enable autoRefresh on the webpage -->
<% response.setIntHeader("refresh",2); %>
<!-- Display  Add as graphical hyperlink-->
<a href="<jsp:getProperty name="rotator" property="link"/>">
    <img src="<jsp:getProperty name="rotator" property="image"/>" width="300" height="200"/>
 </a>

