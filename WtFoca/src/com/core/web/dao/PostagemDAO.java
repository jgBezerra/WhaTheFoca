package com.core.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.core.web.beans.postagem.Postagem;

public class PostagemDAO {
	
	Connection con = Conexao.getConnection();
	
	public void setPostagem(Postagem postagem){
		
		String sql = "insert into postagem (titulo,conteudo,subtitulo,curtidas,tipo) values (?,?,?,?,?)";
		
		try {
			PreparedStatement preparador = con.prepareStatement(sql);

			preparador.setString(1,postagem.getTitulo());
			preparador.setString(2,postagem.getConteudo());
			preparador.setString(3,postagem.getSubTitulo());
			preparador.setString(4,postagem.getCurtidas());
			preparador.setString(5,postagem.getTitulo());

			
			preparador.execute();
			preparador.close();
		} catch (SQLException e) {
			System.out.println("Erro - " + e.getMessage());
		}
		
	}


}
