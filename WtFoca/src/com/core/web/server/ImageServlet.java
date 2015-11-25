package com.core.web.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.core.web.dao.Conexao;
import com.mysql.jdbc.Blob;
import com.mysql.jdbc.Statement;

public class ImageServlet extends HttpServlet {
       String id = null;
       
       protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           
   		String id=null;
   		Blob file = null;
           byte[ ] fileData = null ;

                   try{
                   	Connection con = Conexao.getConnection();
                    id = request.getParameter("id");
                        String sqlString = "SELECT * FROM postagem WHERE id = '"+id+"'";
                        PreparedStatement statement = con.prepareStatement(sqlString);
                 	   System.out.println("oixxxxx");

                        
                        ResultSet rs=statement.executeQuery(sqlString);
                        
                        if(!rs.isBeforeFirst())
                        {
                        	System.out.println("tem nada");
                        }	
                   	
                   	
                        while(rs.next())
                        {
                           file = (Blob) rs.getBlob("conteudo");
                   	    fileData = file.getBytes(1,(int)file.length()); 
                   	
                      	OutputStream output = response.getOutputStream();
                   	response.setContentType("image/gif");
                   	
   		                	                                response.setContentLength(fileData.length);
   		                	                                  output.write(fileData);
   		                	                                  
   		                	                                  output.flush(); 
   		                	                                  
   		                	                                  rs.close();
                        }
/*   		                	                                  myStatement.close();
   		                	                                  myconnection.close();
*/
                   }catch(Exception e){e.printStackTrace(); System.out.println("Erro no iMAGEM");     
       }
   		
   	}
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
           System.out.println("oixx");
           
		String id=null;
		Blob file = null;
        byte[ ] fileData = null ;

                try{
                	Connection con = Conexao.getConnection();
                     String sqlString = "SELECT file FROM files WHERE id = '"+id+"'";
                     PreparedStatement statement = con.prepareStatement(sqlString);
                     
                     
                     ResultSet rs=statement.executeQuery(sqlString);
                	
                	
                	    id = request.getParameter("id");
                        file = (Blob) rs.getBlob("conteudo");
                	    fileData = file.getBytes(1,(int)file.length()); 
                	
                   	OutputStream output = response.getOutputStream();
                	response.setContentType("image/gif");
                	
System.out.println("oixx");		                	                                   response.setHeader("Content-Disposition", "inline");
		                	                                response.setContentLength(fileData.length);
		                	                                  output.write(fileData);
		                	                                  
		                	                                  output.flush(); 
		                	                                  
		                	                                  rs.close();/*
		                	                                  myStatement.close();
		                	                                  myconnection.close();*/

                }catch(Exception e){e.printStackTrace(); System.out.println("Erro no UpLoadPostagem");     
    }
    }

}
