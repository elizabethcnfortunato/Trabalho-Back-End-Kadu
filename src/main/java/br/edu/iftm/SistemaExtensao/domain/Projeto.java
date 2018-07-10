package br.edu.iftm.SistemaExtensao.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="TB_PROJETO")
public class Projeto implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CD_PROJETO")
	private Integer id;
	
	@Column(name="DS_NOME",nullable=false,length=200)
	private String nome;
	
	@Temporal(TemporalType.DATE)
	@Column(name="DT_INICIO")
	private Date dataInicio;
	
	@Temporal(TemporalType.DATE)
	@Column(name="DT_FIM")
	private Date dataFim;
	
	@Column(name="QT_HORAS",nullable=false)
	private Integer quantidadeHoras;
	
	@ManyToOne
	@JoinColumn(name="CD_AUTOR",referencedColumnName="CD_PESSOA")
	private Pessoa autor;
	
	@ManyToMany
	@JoinTable(name="TB_PARTICIPANTE_PROJETO",
    		   joinColumns= @JoinColumn(name="CD_PROJETO"),
    		   inverseJoinColumns = @JoinColumn(name="CD_PARTICIPANTE"))
	private List<Pessoa> participantes;
	

	public Projeto() {
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

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public Integer getQuantidadeHoras() {
		return quantidadeHoras;
	}

	public void setQuantidadeHoras(Integer quantidadeHoras) {
		this.quantidadeHoras = quantidadeHoras;
	}

	public Pessoa getAutor() {
		return autor;
	}

	public void setAutor(Pessoa autor) {
		this.autor = autor;
	}

	public List<Pessoa> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(List<Pessoa> participantes) {
		this.participantes = participantes;
	}
	
	
	
	

}
