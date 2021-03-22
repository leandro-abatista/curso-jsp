package model.classes.beans;

import java.io.Serializable;
import java.util.Date;

public class ProdutoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long codigo;
	private String nome;
	private Double valor;
	private Double valorCusto;
	private Integer quantidade;
	private Date dataCadastro;

	private Long codigo_cat;
	private Long codigo_unidmedida;
	private Long codigo_forn;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Double getValorCusto() {
		return valorCusto;
	}

	public void setValorCusto(Double valorCusto) {
		this.valorCusto = valorCusto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Long getCodigo_cat() {
		return codigo_cat;
	}

	public void setCodigo_cat(Long codigo_cat) {
		this.codigo_cat = codigo_cat;
	}

	public Long getCodigo_unidmedida() {
		return codigo_unidmedida;
	}

	public void setCodigo_unidmedida(Long codigo_unidmedida) {
		this.codigo_unidmedida = codigo_unidmedida;
	}

	public Long getCodigo_forn() {
		return codigo_forn;
	}

	public void setCodigo_forn(Long codigo_forn) {
		this.codigo_forn = codigo_forn;
	}

	
}
