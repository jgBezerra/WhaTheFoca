package com.core.web.dao;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.core.web.beans.usuario.Usuario;

public class UsuarioDAO {
	
	Connection con = Conexao.getConnection();
	
	public void registro(Usuario usuario){
		
		String sql = "insert into usuario (primeiro_nome,ultimo_nome,email,senha) values (?,?,?,?)";
		
		try {
			PreparedStatement preparador = con.prepareStatement(sql);

			preparador.setString(1,usuario.getPrimeiroNome());
			preparador.setString(2,usuario.getUltimoNome());
			preparador.setString(3,usuario.getEmail());
			preparador.setString(4,usuario.getSenha());

			
			preparador.execute();
			preparador.close();
		} catch (SQLException e) {
			System.out.println("Erro - " + e.getMessage());
		}
		
	}
	
	public Usuario autenticacao(Usuario usuario){
		
			Usuario userReturn = null;
			String sql = "select * from usuario where email = ? and senha = ? ";
			
			try {
				PreparedStatement preparador = con.prepareStatement(sql);
				preparador.setString(1, usuario.getEmail());
				preparador.setString(2,usuario.getSenha());

				ResultSet resultado = preparador.executeQuery();

				if(resultado.next()){
					userReturn = new Usuario();
					userReturn.setId(resultado.getInt("id"));
					userReturn.setPrimeiroNome(resultado.getString("primeiro_nome"));
					userReturn.setUltimoNome(resultado.getString("ultimo_nome"));
					System.out.println(resultado.getString("ultimo_nome"));
					userReturn.setPrimeiroNome(resultado.getString("email"));
					userReturn.setSenha(resultado.getString("senha"));
				}
				resultado.close();
                con.close();
                preparador.close();
			} catch (SQLException e) {
				System.out.println("exceptionnnnnnnnnnnnnnnnnnnnn");

				System.out.println("Erro - " + e.getMessage());
			}
			return userReturn;
			
		}
	
	

}
