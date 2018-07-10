package br.edu.iftm.SistemaExtensao.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="TB_PESSOA")
@XmlRootElement
public class Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CD_PESSOA")
	private Integer id;
	
	@Column(name="NM_PESSOA",nullable=false,length=200)
	private String nome;
	
	@OneToMany(mappedBy="autor")
	private List<Projeto> projetosAutor;
	
	@ManyToMany(mappedBy="participantes")
	private List<Projeto> participacoes;

	public Pessoa() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Projeto> getProjetosAutor() {
		return projetosAutor;
	}

	public void setProjetosAutor(List<Projeto> projetosAutor) {
		this.projetosAutor = projetosAutor;
	}

	public List<Projeto> getParticipacoes() {
		return participacoes;
	}

	public void setParticipacoes(List<Projeto> participacoes) {
		this.participacoes = participacoes;
	}
	
	
	
	
	
	
	

}
