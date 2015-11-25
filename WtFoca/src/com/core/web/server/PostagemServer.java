package com.core.web.server;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.core.web.beans.postagem.Postagem;
import com.core.web.dao.PostagemDAO;

/**
 * Servlet implementation class PostagemServer
 */
public class PostagemServer extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String sTitulo = request.getParameter("titulo");
		String sConteudo = request.getParameter("carregar");
		String sSubTitulo = request.getParameter("subTitulo");
		String sTipo = request.getParameter("tipo");
		
		


		Postagem post = new Postagem();
		post.setTitulo(sTitulo);
		post.setConteudo(sConteudo);
		post.setSubTitulo(sSubTitulo);
		post.setTipo(sTipo);

		PostagemDAO postDAO = new PostagemDAO();
		postDAO.setPostagem(post);
	}

}
