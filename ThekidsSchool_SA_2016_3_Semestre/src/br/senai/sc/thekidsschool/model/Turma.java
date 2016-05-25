package br.senai.sc.thekidsschool.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
public class Turma {
	
	@Id
	@GeneratedValue
	private Long id;
	private String nomeTurma;
	private Date inicio;
	private Date termino;
	private float valor;
	@ManyToOne
	private Usuario professor;
	@ManyToMany
	private List <Usuario> alunosTurma;
	

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNomeTurma() {
		return nomeTurma;
	}
	public void setNomeTurma(String nomeTurma) {
		this.nomeTurma = nomeTurma;
	}
	
	public Usuario getProfessor() {
		return professor;
	}
	public void setProfessor(Usuario professor) {
		this.professor = professor;
	}
	
	public Date getInicio() {
		return inicio;
	}
	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}
	
	public Date getTermino() {
		return termino;
	}
	public void setTermino(Date termino) {
		this.termino = termino;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	public List<Usuario> getAlunosTurma() {
		return alunosTurma;
	}
	
	public void setAlunosTurma(List<Usuario> alunosTurma) {
		this.alunosTurma = alunosTurma;
	}
}
