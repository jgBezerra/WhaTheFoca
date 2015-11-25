package com.core.web.server;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.core.web.beans.usuario.Usuario;
import com.core.web.dao.Conexao;
import com.core.web.dao.UsuarioDAO;
import com.mysql.jdbc.Blob;

/**
 * Servlet implementation class Generate
 */

public class Gerador extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id= request.getParameter("id") ;
		String tipoPostagem=request.getParameter("tipoPostagem") ;;
		
		

                   try{
                   	Connection con = Conexao.getConnection();
                        String sqlString = "SELECT * FROM postagem WHERE id = '"+id+"'" + "or tipo ='"+tipoPostagem+"' ";
                        
                        String sqlRelacionados = "SELECT file FROM files WHERE tipo = '"+tipoPostagem+"' ";
                        PreparedStatement statement = con.prepareStatement(sqlString);
                        
                        ResultSet rs =statement.executeQuery(sqlString);
                   	
                   	    id = request.getParameter("id");
                   	    System.out.println(tipoPostagem);
                   	 System.out.println(id);
                   	   
                   	
                   	request.getRequestDispatcher("first.jsp").forward(request, response);

                   }catch(Exception e){e.printStackTrace(); System.out.println("Erro no Generate");     
       }
	}
}
	

