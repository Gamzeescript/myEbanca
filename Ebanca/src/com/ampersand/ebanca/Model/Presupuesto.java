package com.ampersand.ebanca.Model;
// Generated Aug 21, 2020 8:50:12 PM by Hibernate Tools 5.2.12.Final

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Presupuesto generated by hbm2java
 */
@Entity
@Table(name = "presupuesto", catalog = "mibanco")
public class Presupuesto implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer idPresupuesto;
	private Area area;
	private Departamento departamento;
	private Gerencia gerencia;
	private Date fecha;
	private List<EstadoPresupuesto> estadoPresupuestos = new ArrayList<EstadoPresupuesto>(0);

	public Presupuesto() {
	}

	public Presupuesto(Area area, Departamento departamento, Gerencia gerencia) {
		this.area = area;
		this.departamento = departamento;
		this.gerencia = gerencia;
	}

	public Presupuesto(Area area, Departamento departamento, Gerencia gerencia, Date fecha,
			List<EstadoPresupuesto> estadoPresupuestos) {
		this.area = area;
		this.departamento = departamento;
		this.gerencia = gerencia;
		this.fecha = fecha;
		this.estadoPresupuestos = estadoPresupuestos;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id_presupuesto", unique = true, nullable = false)
	public Integer getIdPresupuesto() {
		return this.idPresupuesto;
	}

	public void setIdPresupuesto(Integer idPresupuesto) {
		this.idPresupuesto = idPresupuesto;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_area", nullable = false)
	public Area getArea() {
		return this.area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_departamento", nullable = false)
	public Departamento getDepartamento() {
		return this.departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_gerencia", nullable = false)
	public Gerencia getGerencia() {
		return this.gerencia;
	}

	public void setGerencia(Gerencia gerencia) {
		this.gerencia = gerencia;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha", length = 10)
	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "presupuesto")
	public List<EstadoPresupuesto> getEstadoPresupuestos() {
		return this.estadoPresupuestos;
	}

	public void setEstadoPresupuestos(List<EstadoPresupuesto> estadoPresupuestos) {
		this.estadoPresupuestos = estadoPresupuestos;
	}

}