package com.core.web.server;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.core.web.beans.usuario.Usuario;
import com.core.web.dao.UsuarioDAO;

public class Registro extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String sEmail = request.getParameter("email");
		String sSenha = request.getParameter("senha");
		String sUltimoNome = request.getParameter("ultimoNome");
		String sPrimeiroNome = request.getParameter("primeiroNome");
		Usuario user = new Usuario();
		user.setEmail(sEmail);
		user.setSenha(sSenha);
		user.setUltimoNome(sUltimoNome);
		user.setPrimeiroNome(sPrimeiroNome);
		UsuarioDAO userDAO = new UsuarioDAO();
		userDAO.registro(user);
		System.out.println("Cadastrado com sucesso");
		request.getRequestDispatcher("focaWeb/login/login.jsp").forward(request, response);
		
	}

}
