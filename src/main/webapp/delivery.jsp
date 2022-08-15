<%@ page language="java" contentType="text/html"
 pageEncoding="ISO-8859-1" import="java.util.ArrayList,java.util.HashMap,java.util.Map"%>
 <%@ page import="orders.DeliveryOrder" %>
<%Map<DeliveryOrder, ArrayList<Integer>> map = (HashMap)request.getAttribute("map"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delivery</title>
<link rel="stylesheet" href="deliverstyle.css">
</head>
<body>
<div class="Main">
<div class="Delivery">
<form method=get action="DeliverySerlvet">
<% if(map == null){ %>
<input type="submit" value="Get Orders" name="getOrder" class="input-del">
<%} %>
<% if(map != null ) { %>
<%  for (Map.Entry<DeliveryOrder,ArrayList<Integer>> entry : map.entrySet()) { %>
<li class="Cards">
<p> Customer: <%= entry.getKey().name %> </p>
<p> Deliver to <%= entry.getKey().address %>  </p>
<p> Order Numbers for that customer </p>
<%for(int i = 0; i < entry.getValue().size();i++) { %>
<p> Num: <%= entry.getValue().get(i) %> </p>
<% } %>
<span class="close"> <b> Delivered </b> </span> </li>
<% } %>

<% } else { %>
<p> No Delivery Present </p>
<% } %>
</form>
</div>
</div>
</body>
<script>
var closebtns = document.getElementsByClassName("close");
var i;

for (i = 0; i < closebtns.length; i++) {
  closebtns[i].addEventListener("click", function() {
    this.parentElement.style.display = 'none';
  });
}
</script>
</html>