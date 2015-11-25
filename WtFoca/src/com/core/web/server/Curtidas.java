package com.core.web.server;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.core.web.beans.postagem.Postagem;
import com.core.web.beans.usuario.Usuario;
import com.core.web.dao.Conexao;
import com.core.web.dao.CurtidasDAO;
import com.core.web.dao.UsuarioDAO;

/**
 * Servlet implementation class Curtidas
 */
@WebServlet("/Curtidas")
public class Curtidas extends HttpServlet {
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String curtidas = request.getParameter("curtidas");
		String idd = request.getParameter("id");
		int id = Integer.parseInt(idd);
		
		int likes;
		likes= (Integer.parseInt(curtidas))+1; 
	    curtidas = Integer.toString(likes);
	    
	    Postagem post = new Postagem();
		post.setCurtidas(curtidas);
		post.setId(id);
		CurtidasDAO likesDAO = new CurtidasDAO();
		likesDAO.likes(post);
		request.getRequestDispatcher("Main1.jsp").forward(request, response);
		System.out.println("Curtiu com sucesso");
		
	}

}
