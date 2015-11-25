<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>

<!DOCTYPE HTML>
<html>
<head>
<title>WhaTheFoca</title>
<link rel="shortcut icon" type="image/png" href="images/foca-fav.png"/>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Movie_store Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<!-- start plugins -->
<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
<link href='http://fonts.googleapis.com/css?family=Roboto+Condensed:100,200,300,400,500,600,700,800,900' rel='stylesheet' type='text/css'>
<script src="js/responsiveslides.min.js"></script>
<script>
    $(function () {
      $("#slider").responsiveSlides({
      	auto: true,
      	nav: true,
      	speed: 500,
        namespace: "callbacks",
        pager: true,
      });
    });
</script>
</head>
<body>

<div class="container">
	<div class="container_wrap">
		<div class="header_top">
		    <div class="col-sm-3 logo"><a href="Main1.jsp"><img src="images/logo_sub2.png" alt=""/></a></div>
		    <div class="col-sm-6 nav ">
			 <ul>
				 <li> <span class="simptip-position-bottom simptip-movable" data-tooltip="tirinhas"><a href="tirinhas.jsp"> </a></span></li>
				 <li><span class="simptip-position-bottom simptip-movable" data-tooltip="gifs"><a href="gifs.jsp"> </a> </span></li>
				 <li><span class="simptip-position-bottom simptip-movable" data-tooltip="videos"><a href="videos.jsp"> </a></span></li>
				 <li><span class="simptip-position-bottom simptip-movable" data-tooltip="geek"><a href="geek.jsp"> </a></span></li>
				 <li><span class="simptip-position-bottom simptip-movable" data-tooltip="Rank"><a href="rank.jsp"> </a></span></li>
				 <li><span class="simptip-position-bottom simptip-movable" data-tooltip="Adicionar Risadas"><a href="add.jsp"> </a></span></li>
			 </ul>
			</div>
			<div class="col-sm-3 header_right">
			   <ul class="header_right_box">
				 <li><img src="images/p1.jpg" alt=""/></li>
				 <li><p><a href="login.html">João Gabriel</a></p></li>
				 <li class="last"><i class="edit"> </i></li>
				 <div class="clearfix"> </div>
			   </ul>
			</div>
			<div class="clearfix"> </div>
	      </div>
      
      <div class="content">
      	
		<div class="box_2">
			<div class="container">
	<div class="container_wrap">
      	     <div class="box_1">
		      	 <h1 class="m_3">Nova Risada</h1></a><!-- 
		      	 <img src="images/tropheu.png" alt=""/> -->
		      	 
				<div class="clearfix"> </div>
			</div>
			  <form action="upLoadPostagempath" method="post" enctype="multipart/form-data" >
				 <div class="register-top-grid">
					 <div>
						<span>Titulo<label>*</label></span>
						<input type="text" name="titulo"> 
					 </div>
					 <div>
						<span>Legenda<label>*</label></span>
						<input type="text" name="subTitulo"> 
					 </div>
					  
					  <div>
						<span>Tag<label>*</label></span>
						 <select name="tipo">
						 <option value="tirinhas">Tirinhas</option>
						  <option value="gif">Gif</option>
						  <option value="videos">Videos</option>
						  <option value="geek">Geek</option>
						</select>  
						<div>
					 
					 	<input type="file" name="carregar">
					 
					 </div>
					 	<div class="register-but">
					   <input type="submit" value="Enviar">
					   <div class="clearfix"> </div>
				</div>
					 
					 </div>
					 <!-- <div class="clearfix"> </div>
					   <a class="news-letter" href="#">
						 <label class="checkbox"><input type="checkbox" name="checkbox" checked=""><i> </i>Visível para só amigos</label>
					   </a>
					 </div>
					  -->
				     
				</form>
				
    </div>
</div>
      </div>
   </div>
   </div>
 </div>
 
<div class="container"> 
 <footer id="footer">
 	<div id="footer-3d">
		<div class="gp-container">
			<span class="first-widget-bend"></span>
		</div>		
	</div>
    <div id="footer-widgets" class="gp-footer-larger-first-col">
		<div class="gp-container">
            <div class="footer-widget footer-1">
            	<div class="wpb_wrapper">
<!-- 					<img src="images/f_logo.png" alt=""/>
 -->				</div> 
	          <br>
	          <img src="images/foca-spin.gif" class="img-responsive" alt=""/>
			 </div>
			 <div class="footer_box">
			  <div class="col_1_of_3 span_1_of_3">
					<h3>Categorias</h3>
					<ul class="first">
						<li><a href="#">Tirinhas</a></li>
						<li><a href="#">Gifs</a></li>
						<li><a href="#">Vídeos</a></li>
					</ul>
		     </div>
		     <div class="col_1_of_3 span_1_of_3">
					<h3>Rank</h3>
					<ul class="first">
						<li><a href="#">Top Semanal</a></li>
						<li><a href="#">Top Usuários</a></li>
						<li><a href="#">Top Smilled</a></li>
					</ul>
		     </div>
		     <div class="col_1_of_3 span_1_of_3">
					<h3>Siga-nos</h3>
					<ul class="first">
						<li><a href="#">Facebook</a></li>
						<li><a href="#">Twitter</a></li>
						<li><a href="#">Youtube</a></li>
					</ul>
					<div class="copy">
<!-- 				      <p>&copy; 2015 Template by <a href="http://w3layouts.com" target="_blank"> w3layouts</a></p>
 -->			        </div>
		     </div>
		    <div class="clearfix"> </div>
	        </div>
	        <div class="clearfix"> </div>
		</div>
	</div>
  </footer>
</div>		
</body>
</html>