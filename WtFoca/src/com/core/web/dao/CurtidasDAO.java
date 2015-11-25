package com.core.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.core.web.beans.postagem.Postagem;
import com.core.web.beans.usuario.Usuario;

public class CurtidasDAO {
	Connection con = Conexao.getConnection();
	
public void likes(Postagem postagem){
	
		int id=postagem.getId();
		System.out.println("id");
		String sql = " UPDATE postagem SET curtidas ='"+postagem.getCurtidas()+"' WHERE id ='"+id+"'"; 
		try {
			PreparedStatement preparador = con.prepareStatement(sql);

			
			System.out.println(postagem.getCurtidas());
			System.out.println("oii");
			preparador.execute();
			preparador.close();
		} catch (SQLException e) {
			System.out.println("Erro - " + e.getMessage());
			System.out.println("deu ruim na hora de curtir");
		}
		
	}



}
