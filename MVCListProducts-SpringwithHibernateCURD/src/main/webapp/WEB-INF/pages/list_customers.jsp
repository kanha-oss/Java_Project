<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>

<c:choose>
   <c:when test="${!empty listDTO}">
       <table  border="1" bgcolor="cyan">
           <tr><th>Cno</th><th>Cname</th><th>Cadd</th><th>mobileNo</th><th>billAmt</th><th>Operations</th> </tr>
           <c:forEach  var="dto" items="${listDTO}">
               <tr  style="color:blue">
              
                  <td>${dto.cno}</td>
                  <td>${dto.cname}</td>
                  <td>${dto.cadd}</td>
                  <td>${dto.mobileNo}</td>
                  <td>${dto.billAmt}</td>
                  <td>
                    <a href="update_customer.htm?cno=${dto.cno}"  ><img src="images/edit.jpg" width="30" height="30"/></a>
                    &nbsp;
                    <a href="delete_customer.htm?cno=${dto.cno}"  onclick="return confirm('Are u sure!! u want to delete?')"><img src="images/delete.jpg" width="30" height="30"/></a>
 
                  </td>
               </tr>
           </c:forEach>
       </table>
   </c:when>
   <c:otherwise>
             <h1 style="color:red;text-align:center">Records not found </h1>
   </c:otherwise>
</c:choose>
<br>
 <c:if test="${!empty resMsg}">
     <p style="background:yellow;text-align:center;color:red;font-size:20px">${resMsg } </p>
  </c:if> 
<br>
    <p style="text-align:center"> <a href="add_customer.htm"><img src="images/add.jpg" width="70" height="70"></a> 
    <a href="welcome.htm"><img width="70" heigth="70" src="images/home1.jpg"></a>
     </p>
       
    
