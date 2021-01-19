<%@page import="com.login.service.LoginService"
import="com.login.controller.Connection1"
import="java.sql.Connection"
import="java.sql.DriverManager"
import="java.sql.ResultSet"
import="java.sql.SQLException"
import="java.sql.Statement"
import="java.sql.Timestamp"
%>

<html>

<head>
<title>Welcome Screen</title>
</head>
<style>

body{
   background-color: #f7fcff;
    margin-top: 0px; 
    margin-bottom: 0px; 
    margin-left: 0px; 
    margin-right: 0px;
    padding: 0;
}

#main {
width:960px;
margin:50px auto;
font-family:raleway
}

#profile {
padding:50px;
border:1px dashed grey;
font-size:20px;
background-color:#DCE6F7
}
#logout {
float:right;
padding:5px;
border:dashed 1px gray
}
a {
text-decoration:none;
color:#6495ed
}


/*~~~~~~~~~~~~~~second Header~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
#top-text{
    background-color:#1c599a;
    border-top:5px solid #053364;
    border-bottom:28px solid #1c599a;
    margin-top: 0 auto;
    position:relative;
text-align: center;
    color: white;
}
.logo {
    width: 100px;
    height: 100px;
    content: src("https://i.ibb.co/GF5dFsS/ED.png");
}

.textheader2{
    padding-left: 250px;
}

.textheader2-1size{
    font-size: 30px;
}
.textheader2-2size{
    font-size: 20px; 
}


.floatLeft { float: left; 
margin-top: 13px;
margin-left: 50px;
margin-bottom: 20px}

.header2button {
  background-color: #053364;
  color: white;
  font-size: 12px;
    height: 30px;
    width: 100px;
    color: white;
    float: right;
}
.header2button-login{
     margin-top: 40px;
    margin-right: 20px;
}
.header2button-register{
     margin-top: 40px;
    margin-right: 120px;
}

.button {
  position: relative;
  background-color: #2bbbbb;
  border: none;
  font-size: 16px;
  color: #FFFFFF;
  padding: 20px;
    margin: 4px 2px;
  width: 200px;
  text-align: center;
  -webkit-transition-duration: 0.4s; /* Safari */
  transition-duration: 0.4s;
  text-decoration: none;
  overflow: hidden;
  cursor: pointer;
}

.button:after {
  content: "";
  background: #f1f1f1;
  display: block;
  position: absolute;
  padding-top: 300%;
  padding-left: 350%;
  margin-left: -20px !important;
  margin-top: -120%;
  opacity: 0;
  transition: all 0.8s
}

.button:active:after {
  padding: 0;
  margin: 0;
  opacity: 1;
  transition: 0s
}
.button:hover {
  box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24),0 17px 50px 0 rgba(0,0,0,0.19);
}
table {
  width:70%;
  margin-top:30px;
}
table, th, td {
  border: 2px solid black;
  border-collapse: collapse;
}
th, td {
  padding: 15px;
  text-align: left;
}
th{
background-color:#2a5a8d;
}

/*~~~~~~~~~~~~~~~~~~~~~~~~~ADD MEMBER FORM~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/


.form-style-8{
	font-family: 'Open Sans Condensed', arial, sans;
	width: 500px;
	padding: 30px;
	background: #FFFFFF;
	margin: 50px auto;
	box-shadow: 0px 0px 15px rgba(0, 0, 0, 0.22);
	-moz-box-shadow: 0px 0px 15px rgba(0, 0, 0, 0.22);
	-webkit-box-shadow:  0px 0px 15px rgba(0, 0, 0, 0.22);

}
.form-style-8 h2{
	background: #4D4D4D;
	text-transform: uppercase;
	font-family: 'Open Sans Condensed', sans-serif;
	color: #797979;
	font-size: 18px;
	font-weight: 100;
	padding: 20px;
	margin: -30px -30px 30px -30px;
}
.form-style-8 input[type="text"],
.form-style-8 input[type="date"],
.form-style-8 input[type="datetime"],
.form-style-8 input[type="email"],
.form-style-8 input[type="number"],
.form-style-8 input[type="search"],
.form-style-8 input[type="time"],
.form-style-8 input[type="url"],
.form-style-8 input[type="password"],
.form-style-8 select 
{
	box-sizing: border-box;
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	outline: none;
	display: block;
	width: 100%;
	padding: 7px;
	border: none;
	border-bottom: 1px solid #ddd;
	background: transparent;
	margin-bottom: 10px;
	font: 16px Arial, Helvetica, sans-serif;
	height: 45px;
}

.span_class{
    font: 14px Arial, Helvetica, sans-serif;
}

.form-style-8 textarea{
    box-sizing: border-box;
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	outline: none;
	display: block;
	width: 100%;
	padding: 7px;
	border: none;
	border-bottom: 1px solid #ddd;
	background: transparent;
	margin-bottom: 10px;
	font: 16px Arial, Helvetica, sans-serif;
	height: 90px;
}

.form-style-8 input[type="file"],
.form-style-8 input[type="button"], 
.form-style-8 input[type="submit"]{
	-moz-box-shadow: inset 0px 1px 0px 0px #45D6D6;
	-webkit-box-shadow: inset 0px 1px 0px 0px #45D6D6;
	box-shadow: inset 0px 1px 0px 0px #45D6D6;
	background-color: #2CBBBB;
	border: 1px solid #27A0A0;
	display: inline-block;
	cursor: pointer;
	color: #FFFFFF;
	font-family: 'Open Sans Condensed', sans-serif;
	font-size: 14px;
	padding: 8px 18px;
	text-decoration: none;
	text-transform: uppercase;
}
.form-style-8 input[type="button"]:hover, 
.form-style-8 input[type="submit"]:hover {
	background:linear-gradient(to bottom, #34CACA 5%, #30C9C9 100%);
	background-color:#34CACA;
}
</style>
<body>
   <!--~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~SECOND HEADER~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~  -->
  <div id="top-text">
    <!-- <img src="https://i.ibb.co/GF5dFsS/ED.png" class="floatLeft" alt="ED" width="100px" height="100px">
       -->
    <h1 class="textheader2 textheader2-1size" style="text-align:left">Bus Reservation System</h1>
   <!--  <h2 class="textheader2 textheader2-2size" style="text-align:left">Network Based Brainstorming</h2> -->
    </div>
<!-- ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-->
 
 
 <button style="margin-right:30px; margin-top:30px; float:left" class="button" onClick="parent.location='http://localhost:8080/welcome'">Back to HomePage</button>
   
    <button style="margin-right:30px; margin-top:30px; float:right" class="button" onClick="parent.location='http://localhost:8080/login'">Logout</button>
    
  
  <table>



<%
Connection conn = Connection1.conn();

String name = LoginService.getName();
int total = 0;
String des = null;
int num_pass = 0;
int num_passdiss = 0;
String ret = "Select * from tickets where name = '"+name+"';";

Statement stmt = conn.createStatement();
ResultSet rs = stmt.executeQuery(ret);

while (rs.next()) {
	des = rs.getString("des");
	num_pass = rs.getInt("num_pass");
	num_passdiss = rs.getInt("num_passdiss");
	total = rs.getInt("total");
	%>
	   
  <tr><th>PASSENGER'S NAME:</th><td><%= name%></td></tr>
 <tr><th>PASSENGER'S DESTINATION :</th><td><%= des%></td></tr>
 <tr><th>NO. OF PASSENGERS:</th><td><%= num_pass%></td></tr>
 <tr><th>NO. OF PASSENGERS WITH DISCOUNT:</th><td><%= num_passdiss%></td></tr>
 <tr><th>PASSENGER'S TOTAL FARE IN</th><td><%= total%></td></tr>
	<% } %>
</table>
  
<div class="form-style-8">
  <h2>Enter the Following Details</h2>
  <form method="post">

<input type="hidden" id="total" name="total" value="<%= total%>">
    <input type="number" id="amount" name="amount" placeholder="PASSENGER'S TOTAL FARE" value="<%= total%>" required/>
     <input name="submit" type="submit" value="Add" />
<br><br>

             <font color="red">${errorMessage}</font>
  </form>
</div>
</body>
</html>