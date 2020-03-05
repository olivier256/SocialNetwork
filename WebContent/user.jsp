<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Ne pas oublier de mettre les Apache Taglibs (ex-JSTL) JSTL, Spec et Impl dans WebContent/WEB-INF/lib -->
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Page de ${ user.firstName } ${ user.lastName }</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

</head>
<body>

<H1>${ user.firstName } ${ user.lastName }</H1>
<img src="images/${ user.picture }" align=right width=128 >
Ma vie, mon oeuvre: ${ user.bio }



<form action="UserServlet" method="POST">
	<input type="hidden" name="id" value="${ user.id }">
	<input type="text" name="textField">
	<input type="submit" value="Post!" />
</form>



<div class="w3-bar w3-black">
  <button class="w3-bar-item w3-button" onclick="openCity('friends')">Mes amis</button>
  <button class="w3-bar-item w3-button" onclick="openCity('posts')">Mes posts</button>
</div>


<div id="friends" class="w3-container city">
<h2>Mes amis sont :</h2>
<table>
<tr><th>Nom</th><th>Photo</th></tr>
<c:forEach items="${ user.friends }" var="friend">
    <tr>      
        <td><a href="UserServlet?id=${ friend.id }">${ friend.firstName } ${ friend.lastName }</a></td>
        <td><img src="images/${ friend.picture }" width=64></td>
    </tr>
</c:forEach>
</table>
</div>

 <div id="posts" class="w3-container city"  style="display:none">
<h2>Mes posts sont :</h2>
<ul>
<c:forEach items="${ user.posts }" var="post">
    <li>${ post.content }
</c:forEach>
</ul>
</div>


<script>
function openCity(cityName) {
  var i;
  var x = document.getElementsByClassName("city");
  for (i = 0; i < x.length; i++) {
    x[i].style.display = "none";  
  }
  document.getElementById(cityName).style.display = "block";  
}
</script>


</body>
</html>
