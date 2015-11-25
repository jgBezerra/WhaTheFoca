package com.core.web.server;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.core.web.beans.usuario.Usuario;
import com.core.web.dao.UsuarioDAO;

public class XmlServer extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String sEmail = request.getParameter("email");
		String sSenha = request.getParameter("senha");
		System.out.println(sEmail);
		System.out.println(sSenha);
		Usuario user = new Usuario();
		user.setEmail(sEmail);
		user.setSenha(sSenha);
		UsuarioDAO userDAO = new UsuarioDAO();
		Usuario userAutenticado = userDAO.autenticacao(user);
		if(userAutenticado != null){
			request.getRequestDispatcher("Main1.jsp").forward(request, response);
			
		}else{
			response.sendRedirect("registro.jsp");
		}
	}

}
