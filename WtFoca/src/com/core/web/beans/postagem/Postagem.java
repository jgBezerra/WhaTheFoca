package com.core.web.beans.postagem;

import com.core.web.beans.usuario.Usuario;

public class Postagem {
	private int id;
	private String titulo;
	private String conteudo;
	private String subTitulo;
	private String curtidas;
	private String descurtidas;
	private String tipo;
	
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getConteudo() {
		return conteudo;
	}
	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
	public String getSubTitulo() {
		return subTitulo;
	}
	public void setSubTitulo(String subTitulo) {
		this.subTitulo = subTitulo;
	}
	public String getCurtidas() {
		return curtidas;
	}
	public void setCurtidas(String curtidas) {
		this.curtidas = curtidas;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescurtidas() {
		return descurtidas;
	}
	public void setDescurtidas(String descurtidas) {
		this.descurtidas = descurtidas;
	}
	
	
	
	
	
	
	
}
