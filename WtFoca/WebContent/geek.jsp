<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.logging.Logger"%>
<%@page import="java.util.logging.Level"%>
<%@page import="com.core.web.dao.Conexao"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.io.*"%>
    
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
		    <div class="col-sm-3 logo"><a href="Main1.jsp"><img src="images/logo_sub.png" alt=""/></a></div>
		    <div class="col-sm-6 nav">
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
	      <div class="slider">
	   <div class="callbacks_container">
	      <ul class="rslides" id="slider">
	        <!-- <li><img src="images/banner2.jpg" class="img-responsive" alt=""/>
	        	<div class="button">
			      <a href="#" class="hvr-shutter-out-horizontal">Clique para concorrer</a>
			    </div>
			</li>
	        <li><img src="images/banner1.jpg" class="img-responsive" alt=""/>
	        	<div class="button">
			      <a href="#" class="hvr-shutter-out-horizontal">Mais Informações</a>
			    </div>
			</li> -->
	        <li><img src="images/bigLogo.jpg" class="img-responsive" alt=""/>
	        	<!-- <div class="button">
			      <a href="#" class="hvr-shutter-out-horizontal">Assista Agora</a>
			    </div> -->
			</li>
	      </ul>
	    </div>
	    <div class="banner_desc">
			    	<div class="col-md-9">
			    		<ul class="list_1">
			    			<li>Published <span class="m_1">Feb 20, 2015</span></li>
			    			<li>Updated <span class="m_1">Feb 20 2015</span></li>
			    			<li>Rating <span class="m_1"><img src="images/rating.png" alt=""/></span></li>
			    		</ul>
			    	</div>
			    	<div class="col-md-3 grid_1">
			    		<ul class="list_1 list_2">
			    			<li><i class="icon1"> </i><p>2</p></li>
			    			<li><i class="icon2"> </i><p>3</p></li>
			    			<li><i class="icon3"> </i><p>0</p></li>
			    		</ul>
			    	</div>
			    </div>
      </div>
      
      <div class="content">
      	<div class="box_1">
      	 <h1 class="m_2">Top Semanal</h1>
      	 <img src="images/tropheu.png" alt=""/>
      	 <div class="search">
		    <form>
				<input type="text" value="Search..." onfocus="this.value='';" onblur="if (this.value == '') {this.value ='';}">
				<input type="submit" value="">
		    </form>
		</div>
		<div class="clearfix"> </div>
		</div>
		<div class="box_2">
		 <%
				 String id=(request.getParameter("id"));
		         
		         Blob file = null;
		         byte[ ] fileData = null ;
                        try
                        {
                                /* Db_Connection dbconn=new Db_Connection();
                                Connection myconnection= dbconn.Connection(); */
                                
                                Conexao dbconn =new Conexao();
                                Connection myconnection= Conexao.getConnection();

                                String sqlString = "SELECT * FROM postagem WHERE tipo ='geek'";
                                Statement myStatement = myconnection.createStatement();
                                ResultSet rs=myStatement.executeQuery(sqlString);
                                
                                if(!rs.isBeforeFirst())
                                {
                                    %>
                                    
                                        <tr>
                                        <td colspan="3"><center><%out.print("No Files!"); %></center></td>
                                        </tr>
                                    <%
                                }    
                                
                                while(rs.next())
                                {   /* file = rs.getBlob("conteudo");
                               	    fileData = file.getBytes(1,(int)file.length()); */
                            %>
									 <div class="container">
                            	
												 <div class="row">
      											<div class="col-md-7 col-md-offset-1 bootcards-list" >
												<div class="panel panel-default">
													  <div class="panel-heading clearfix "><a href="${pageContext.request.contextPath}/generate?id=<%=rs.getString("id")%>&tipoPostagem=<%=rs.getString("tipo")%>">
													        	 <h1 class="m_3 text-center"><%out.print(rs.getString("titulo"));%></h1></a>
													  </div>
													  <div class="panel-body">
													    <img src="${pageContext.request.contextPath}/imgServletpath?id=<%=rs.getString("id")%>" class="img-responsive center-block " alt="" />
<!-- 													    <img src="images/Basquete.gif" class="img-responsive center-block " alt=""/>
 -->													  </div>
													  <div class="panel-footer">
													    <p align="center"><%out.print(rs.getString("sub_titulo"));%></p>
													   </div>
													 <div class="panel-footer">
													     <ul class="list_1.1 list_2">
												    			<li><i class="icon1"> </i><p>2,548</p></li>
												    			<li><i class="icon2"> </i><p>215</p></li>
												    			<li><i class="icon3"> </i><p>546</p></li>
												    		</ul>
												    </div>
												    <div class="fb-comments" data-href="http://localhost:8080/WtFoca/first.jsp" data-width="600" data-numposts="3"></div>				 
											            <div id="fb-root"></div>
														<script>(function(d, s, id) {
														  var js, fjs = d.getElementsByTagName(s)[0];
														  if (d.getElementById(id)) return;
														  js = d.createElement(s); js.id = id;
														  js.src = "//connect.facebook.net/pt_BR/sdk.js#xfbml=1&version=v2.4";
														  fjs.parentNode.insertBefore(js, fjs);
														}(document, 'script', 'facebook-jssdk'));
														</script>
									           </div>		
												
												</div>	
												</div>
											</div>
												
                                   <%--  <tr>
                                        <td><center><%out.print(rs.getString("id")); %></center></td>
                                        <td><center><%out.print(rs.getString("titulo")); %></center></td>
                                        <td><center><%out.print(rs.getBytes("titulo")); %></center></td>
                                       
                                        <td><center><a href="view_file.jsp?id=<%out.print(rs.getString("id"));%>">View</a></center></td>
                                    </tr> --%>
                            <%
                                }
                            %>
                         
                            <%
                                rs.close();
                                myStatement.close();
                                myconnection.close();
                        }catch(Exception e){e.printStackTrace();}    
                        
                    %>
	
			
			
<!-- <div class="col-md-4 col-md-offset-1">
      cada row dessa vai ser um "widget" lateral, caso você vá usar mais de um, só criar outro
      <div class="row">
        <h4>Widget 1</h4>
        <p> Texto do seu widget ou conteudo </p>
        <hr> Tag que poe uma linha
      </div>

      <div class="row">
        <h4>Widget 2</h4>
        <p> Texto do seu widget ou conteudo </p>
        <hr> Tag que poe uma linha
      </div>

    </div> 
		 -->
			
			
		
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
					<img src="images/f_logo.png" alt=""/>
 				</div> 
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