<%@page import="model.User"%>
<!-- ACTION TAGS -->
<jsp:useBean id="keyUser" scope="request" class="model.User" />
<jsp:setProperty name="keyUser" property="login" param="loginForm" />
<jsp:setProperty name="keyUser" property="pwd" param="passForm" />
<jsp:forward page="hello.jsp" />
