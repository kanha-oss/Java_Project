<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h1 style="color:red;text-align:center">Update Customer Info </h1>
<body bgcolor="cyan">
   <form:form modelAttribute="custCmd">
         Customer Number :: <form:input path="cno" disabled="true"/> <br>
         Customer Name :: <form:input path="cname"/> <br>
         Customer Addrs :: <form:input path="cadd"/> <br>
         Customer MobileNo :: <form:input path="mobileNo"/> <br>
         Customer billAmount :: <form:input path="billAmt"/> <br>
         <input type="submit"  value="modify">
   </form:form>    
   </body>
