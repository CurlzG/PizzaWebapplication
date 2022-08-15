# PizzaWebapplication
## For the Application 
This application was builded in eclipse using the dynamic web project for starting and using the tomcat servers for the local server and mysql for the database.

## Index.jsp
For the customer experience I let them order nothing on there pizza as long they, had there name address for the delivery and base and size selcted for the order.
Another thing I made for the customer experience is that when someone is ordering more than one pizza they dont have to enter there name and address in again. 

<img src=https://user-images.githubusercontent.com/68049810/184562975-a5962f37-21fa-4e23-9c55-f9a95d62f684.png>
<br> This is the layout of the jsp

<img src=https://user-images.githubusercontent.com/68049810/184563038-90e67c61-f8b9-4934-b330-9f797f38ce5c.png>
<br> this is what it looks like when the person places an order for two pizzas

## Delivery.jsp
For the delivery driver, I made a map that was the deilveryorders object for the key and the Integer Arraylist for the value, so we could collectively match
the order number to which Name/Address they are going too, then jsp would display the map on screen using ejs <% %>
<br> 
<img src=https://user-images.githubusercontent.com/68049810/184563091-ec345f4b-7b9d-4de8-92b7-c16094ade0a6.png style="width:400px; height:400px">
<img src=https://user-images.githubusercontent.com/68049810/184564281-4cb18e34-8a1e-476a-9f79-9474e8e18cca.png style="width:400px; height:400px">


<br> This is what the delivery pages looks like with orders to be delivered. Clicking on delivered will remove the order from being visible showing that it has been delivered. 
 ## Data base
 The Databse, uses a single table (Orders inside of Pizza life) which displays like this. 


![image](https://user-images.githubusercontent.com/68049810/184561856-d1c8c24e-3170-42a1-9b64-dd52caf0bbe7.png)
<br>
Each new order would increase the order_num count, allowing for no duplicates in the order_nums, the time place shows us what time the order was placed. 
Quanity allows us to see how many pizzas were placed inside of that order. 

### Future Improvements
Dicussion on whether its important to allow the customer to be able to let the customer order nothing on the pizza, Dicussion on updating the front end of the pages
to make it look more mordern. Improving the databse, to allow for completed orders to see for history, userID logins so only certain IDs can see the delivery page
