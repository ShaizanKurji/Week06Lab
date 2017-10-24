<%-- 
    Document   : login
    Created on : Oct 24, 2017, 8:32:14 AM
    Author     : 715060
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="username"%>
<%@attribute name="remember"%>
<%@attribute name="noInput"%>
<%@attribute name="invalidLogin"%>
<%@attribute name="logoutmessage"%>

<%-- any content can be specified here e.g.: --%>
  <h1>Remember Me Login Page</h1>
        <form action="login" method ="post">
        Username: <input type="text" name ="username" value =${username}>
        <br>
        Password: <input type ="password" name ="password">
        <br>
        <input type ="submit" value ="Login">
        <br>
        <input type ="checkbox" name ="remember" ${remember}>Remember Me
        </form>
        <br>
        ${noInput}
        ${invalidLogin}
        ${logoutmessage}