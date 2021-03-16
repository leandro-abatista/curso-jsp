package model.classes.beans;

import java.io.Serializable;

public class Telefone implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long codigo;
	private String tipo;
	private String numero;
	private Long usuario;//esse atributo refere-se a usuarioBean

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Long getUsuario() {
		return usuario;
	}

	public void setUsuario(Long usuario) {
		this.usuario = usuario;
	}

}
