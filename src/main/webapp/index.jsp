<%@ page language="java" contentType="text/html"
 pageEncoding="ISO-8859-1" import="java.util.ArrayList"%>
 <%@ page import="orders.Orders" %>
<%ArrayList orderList = (ArrayList)request.getAttribute("listOrders"); %>
<%String warning = (String)request.getAttribute("Warning");%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Non Mushroom  Pizza Company</title>
<link rel="stylesheet" href="mystyle.css">
</head>
<body>
<div class="Main"> 
<form method=get action="TestSerlvet">
  <div class="formClass">
    <div style="padding: 10px">
    <% if(orderList == null || warning == "No Values Were Entered") { %>
    <label for="Name" class="input-label">Name</label>
    <input type="text" name="Name" class="input-field" placeholder="Name">
    <% } else { %>
     <label for="Name" class="input-label">Enter Values for Next Pizza</label>
    <% } %>
  </div>
  <div style="padding: 10px;">
  <div style="padding: 10px; float:left ;width:45%">
    <label for="Name" class="input-label">Base</label> <br>
     <input type="radio" name = Base value="Thin"> Thin </br>
    <input type="radio" name = "Base" value="Plain"> Plain </br>
    <input type="radio" name = "Base" value="Thin Crust"> Thin Crust </br>
    <input type="radio" name = "Base" value="Deep Dish"> Deep Dish </br>
  </div>
  <div style="padding: 10px; float:left; width:45%">
    <label for="Name" class="input-label">Size</label> <br>
    <input type="radio" name = "Size" value="Small"> Small </br>
    <input type="radio" name = "Size" value="Medium"> Medium </br>
    <input type="radio" name = "Size" value="Large"> Large </br>
    <input type="radio" name = "Size" value="Extra Large"> Extra Large </br>
  </div>
  </div>
  <div style="padding:10px">
  <label for="Name"  class="input-label">Toppings</label><br> <br>
  <label for="Name" class="input-sublabel">Select One From Each Group</label>
  <div stlye="width:100%;">
  
  <div style="padding: 10px; float:left;">
  <label for="Name" class="input-sublabel">Vegetables/Fruit</label> <br>
    <input type="radio" name = "top1" value="Pineapple"> Pineapple </br>
    <input type="radio" name = "top1" value="Tomato"> Tomato </br>
    <input type="radio" name = "top1" value="Capsium"> Capsium </br>
    <input type="radio" name = "top1" value="Nothing"> Nothing </br>
  </div>
  <div style="padding: 10px;float:left;">
    <label for="Name" class="input-sublabel">Cheese</label> <br>
    <input type="radio" name = "top2" value="Cheese"> Cheese </br>
    <input type="radio" name = "top2" value="Extra Cheese"> Extra Cheese </br>
    <input type="radio" name = "top2" value="No Cheese"> No Cheese </br>
    <input type="radio" name = "top2" value="Nothing"> Nothing </br>
  </div>
  <div style="padding: 10px;">
 	<label for="Name" class="input-sublabel">Meat</label> <br>
    <input type="radio" name = "top3" value="Bacon"> Bacon </br>
    <input type="radio" name = "top3" value="Ham"> Ham </br>
    <input type="radio" name = "top3" value="No Meat"> No Meat </br>
    <input type="radio" name = "top3" value="Nothing"> Nothing </br>
  </div>
</div>
</div>
<div style="padding: 10px;">
 <% if(orderList == null || warning == "No Values Were Entered" ) { %>
  <label for="Name" class="input-label">Address</label>
  <input type="text" name="Address" class="input-field" placeholder="Address">
   <% } %>
</div>
   
<div style="padding: 10px;">
<input type="submit" value="Add Pizza" name="AddPizza" class="input-submit" >
</div>
</div>
</form>
<div class="Middle">
<p> Middle</p>
<% if(warning != null){ %>
<p> <%= warning %> </p>
<% } %>
</div>
<div class="Right">
<label for="Name" class="input-label">My Pizza Order</label>
<% if(orderList != null && (warning == null || warning != "No Values Were Entered" )) { %>
	<% Orders order = (Orders)orderList.get(0); %>
<p> <b>Customer Name:</b>  <%=  order.getName() %></p>
<p> <b>Deliver To: </b>  <%=  order.getAddress() %> </p>
<% for(int i = 0; i < orderList.size();i++){ %>
<% order = (Orders)orderList.get(i); %>
<p> <b>Pizza <%= (i+1) %> </b>  Pizza Base: <%= order.getBase() %> Pizza Size: <%= order.getSize() %></p>
<p> <b>Toppings:</b> </p>
<p><%= order.getTop1() %></p>
<p> <%= order.getTop2() %></p>
<p> <%= order.getTop3() %></p>
<% } %>
<% } else { %>
<p> No Pizza Has Been Ordered </p>
<% } %>
<form method=get action="TestSerlvet">
<input type="submit" value="Submit Order" name="submitOrder" class="input-submit" >
</form>
</div>
</div> 
</body>
</html>
