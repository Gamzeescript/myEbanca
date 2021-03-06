package com.ampersand.ebanca.Model;
// Generated Aug 21, 2020 8:50:12 PM by Hibernate Tools 5.2.12.Final

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Gerencia generated by hbm2java
 */
@Entity
@Table(name = "gerencia", catalog = "mibanco")
public class Gerencia implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer idGerencia;
	private String nombreGerencia;
	private String jefeGerencia;
	private List<Presupuesto> presupuestos = new ArrayList<Presupuesto>(0);

	public Gerencia() {
	}

	public Gerencia(String nombreGerencia, String jefeGerencia) {
		this.nombreGerencia = nombreGerencia;
		this.jefeGerencia = jefeGerencia;
	}

	public Gerencia(String nombreGerencia, String jefeGerencia, List<Presupuesto> presupuestos) {
		this.nombreGerencia = nombreGerencia;
		this.jefeGerencia = jefeGerencia;
		this.presupuestos = presupuestos;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id_gerencia", unique = true, nullable = false)
	public Integer getIdGerencia() {
		return this.idGerencia;
	}

	public void setIdGerencia(Integer idGerencia) {
		this.idGerencia = idGerencia;
	}

	@Column(name = "nombre_gerencia", nullable = false, length = 50)
	public String getNombreGerencia() {
		return this.nombreGerencia;
	}

	public void setNombreGerencia(String nombreGerencia) {
		this.nombreGerencia = nombreGerencia;
	}

	@Column(name = "jefe_gerencia", nullable = false, length = 100)
	public String getJefeGerencia() {
		return this.jefeGerencia;
	}

	public void setJefeGerencia(String jefeGerencia) {
		this.jefeGerencia = jefeGerencia;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "gerencia")
	public List<Presupuesto> getPresupuestos() {
		return this.presupuestos;
	}

	public void setPresupuestos(List<Presupuesto> presupuestos) {
		this.presupuestos = presupuestos;
	}

}
