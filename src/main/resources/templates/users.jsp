<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<link rel="stylesheet" href="css/bootstrap.min.css">   		
		<script src="js/bootstrap.min.js"></script>       
	</head>
<title>W3.CSS</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

<style>
.center {
  text-align: center;
}

.pagination {
  display: inline-block;
}

.pagination a {
  color: black;
  float: left;
  padding: 8px 16px;
  text-decoration: none;
  transition: background-color .3s;
  border: 1px solid #ddd;
  margin: 0 4px;
}

.pagination a.active {
  background-color: #4CAF50;
  color: white;
  border: 1px solid #4CAF50;
}

.pagination a:hover:not(.active) {background-color: #ddd;}
</style>

<jsp:include page="/jsp/templates/header.jsp"></jsp:include>
	<body>

		<div class="container">
		<h2>Users</h2>
		<!-- -->
            <!--Search Form -->
            <form action="controller" method="get" id="seachUsersForm" role="form">
                <input type="hidden" id="searchAction" name="searchAction" value="searchByName">
                <div class="form-group col-xs-5">
                    <input type="text" name="userName" id="userName" class="form-control" required="true" placeholder="Type the Name or Last Name of the user"/>                    
                </div>
                <button type="submit" class="btn btn-info">
                    <span class="glyphicon glyphicon-search"></span> Search
                </button>
                <br>
            </form>

            <form action="controller" method="post" id="usersForm" role="form" >              
                <input type="hidden" id="id" name="id">
                <input type="hidden" id="command" name="command">

                <div th:if="${not #lists.isEmpty(users)}">
 				<p th:each="user : ${users}" th:text="${user.email}"></p>

				</div>

                <c:choose>                    
                    <c:when test="${not empty users}">
                        <table  class="table table-striped">
                            <thead>
                                <tr>
                                    <td>#</td>
                                    <td>E-mail</td>
                                    <td>Name</td>
                                    <td>Last name</td>
                                    <td>Role</td>
                                    <td></td>
                                </tr>
                            </thead>
                            <c:forEach var="user" items="${users}">
                                <c:set var="classSucess" value=""/>
                                <c:if test ="${id == user.id}">                        	
                                    <c:set var="classSucess" value="info"/>
                                </c:if>
                                <tr class="${classSucess}">
                                    <td>
                                        <a href="controller?userIdForUpdate=${user.id}&command=read_user">${user.id}</a>
                                    </td>                                    
                                    <td>${user.email}</td>   
                                    <td>${user.f_name}</td>
                                    <td>${user.l_name}</td>
                                    <td>${user.role_id}</td>
                                    <td><a href="#" id="delete" 
                                           onclick="document.getElementById('command').value ='delete_user';
                                           document.getElementById('id').value = '${user.id}';
                                           document.getElementById('usersForm').submit();"> 
                    	                        <span class="glyphicon glyphicon-trash"/>
                                        </a>                                                   
                                    </td>
                                </tr>
                            </c:forEach>               
                        </table>  
                    </c:when>                    
                    <c:otherwise>
                        <br>           
                        <div class="alert alert-info">
                            No users found matching your search criteria
                        </div>
                    </c:otherwise>
                </c:choose>                        
            </form>
            <form action ="jsp/new_user.jsp">            
                
                <button type="submit" class="btn btn-primary  btn-md">New user</button> 
            </form>
		</div>

		<div class="center">
		  <div class="pagination">

			<c:choose>
			     <c:when test='${selectedPage == 1}' >
			  		<a href="/optinal-course/controller?command=read_users2&page=1">&laquo</a>
			     </c:when>
			     <c:otherwise>
			  		<a href="/optinal-course/controller?command=read_users2&page=${selectedPage-1}">&laquo</a>
			     </c:otherwise>
			 </c:choose>

<!-- -->
 		  <c:forEach var = 'i' begin = '1' end = '${pages}'>
			<c:choose>
			     <c:when test='${selectedPage == i}' >
			  		<a class="active" href="/optinal-course/controller?command=read_users2&page=${i}">${i}</a>
			     </c:when>
			     <c:otherwise>
			  		<a href="/optinal-course/controller?command=read_users2&page=${i}">${i}</a>
			     </c:otherwise>
			 </c:choose>
 	      </c:forEach>

			<c:choose>
			     <c:when test='${selectedPage == pages}' >
			  		<a href="/optinal-course/controller?command=read_users2&page=${pages}">&raquo</a>
			     </c:when>
			     <c:otherwise>
			  		<a href="/optinal-course/controller?command=read_users2&page=${selectedPage+1}">&raquo</a>
			     </c:otherwise>
			 </c:choose>
		  </div>
		</div>
	</body>
</html>