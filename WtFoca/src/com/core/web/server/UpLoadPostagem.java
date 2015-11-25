package com.core.web.server;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Random;
import java.io.InputStream;




import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.Part;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import com.core.web.dao.Conexao;

/**
 * Servlet implementation class UpLoadPostagem
 */
@WebServlet("/UpLoadPostagem")
@MultipartConfig(maxFileSize = 16177215)
public class UpLoadPostagem extends HttpServlet {

	
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
                response.setContentType("text/html;charset=UTF-8");
                PrintWriter out = response.getWriter();
        
                InputStream inputStream = null;
/*
                Random rand = new Random();
                int  n = rand.nextInt(9999) + 1;
                String idTemp=(String.valueOf(n));*/

                String sTitulo = request.getParameter("titulo");
        		String sSubTitulo = request.getParameter("subTitulo");
        		String sTipo = request.getParameter("tipo");
        		
                Part filePart = request.getPart("carregar");
                
                
                
                
                if (filePart != null) 
                {
                	
                    System.out.println(filePart.getName());
                    System.out.println(filePart.getSize());
                    System.out.println(filePart.getContentType());

                    inputStream = filePart.getInputStream();
                }
        
                try 
                {
                	Connection con = Conexao.getConnection();

                   /* Db_Connection dbconn=new Db_Connection();
                    Connection conn= dbconn.Connection();*/
                	String sql = "insert into postagem (titulo,conteudo,sub_titulo,tipo) values (?,?,?,?)";
/*                    PreparedStatement statement = conn.prepareStatement(sql);
*/                    PreparedStatement statement = con.prepareStatement(sql);
/*
					statement.setString(2,postagem.getConteudo());
					statement.setString(3,postagem.getSubTitulo());
					statement.setInt(4,postagem.getCurtidas());
					statement.setString(5,postagem.getTitulo());
					*/
                    statement.setString(1, sTitulo);
                    
             
                    if (inputStream != null) 
                    {
                        statement.setBinaryStream(2, inputStream, (int) filePart.getSize());
                    	
                        
                    }
                    statement.setString(3, sSubTitulo);
                    /*        			statement.setInt(4,sCurtidas);
                    */                    
                    statement.setString(4, sTipo);
                    int row = statement.executeUpdate();
                    if (row > 0) 
                    {
/*                        out.println("File uploaded!!!");
*/                        
                        con.close();
                        
                        RequestDispatcher rs = request.getRequestDispatcher("Main1.jsp");
                        rs.include(request, response);
                        System.out.println("upload com sucesso");
                    }
                    else
                    {
/*                        out.println("Couldn't upload your file!!!");
*/                        
                        con.close();
                        
                        /*RequestDispatcher rs = request.getRequestDispatcher("upload_form.jsp");
                        rs.include(request, response);*/
                    }    

                }catch(Exception e){e.printStackTrace(); System.out.println("Erro no UpLoadPostagem");}     
    }   

}
