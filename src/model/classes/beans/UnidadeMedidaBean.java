package model.classes.beans;

import java.io.Serializable;

public class UnidadeMedidaBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long codigo;
	private String sigla;
	private String descricao;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
