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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * EstadoPresupuesto generated by hbm2java
 */
@Entity
@Table(name = "estado_presupuesto", catalog = "mibanco")
public class EstadoPresupuesto implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer idEstadoPresupuesto;
	private Estado estado;
	private Presupuesto presupuesto;
	private List<Comprobante> comprobantes = new ArrayList<Comprobante>(0);

	public EstadoPresupuesto() {
	}

	public EstadoPresupuesto(Estado estado, Presupuesto presupuesto) {
		this.estado = estado;
		this.presupuesto = presupuesto;
	}

	public EstadoPresupuesto(Estado estado, Presupuesto presupuesto, List<Comprobante> comprobantes) {
		this.estado = estado;
		this.presupuesto = presupuesto;
		this.comprobantes = comprobantes;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id_estado_presupuesto", unique = true, nullable = false)
	public Integer getIdEstadoPresupuesto() {
		return this.idEstadoPresupuesto;
	}

	public void setIdEstadoPresupuesto(Integer idEstadoPresupuesto) {
		this.idEstadoPresupuesto = idEstadoPresupuesto;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_estado", nullable = false)
	public Estado getEstado() {
		return this.estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_presupuesto", nullable = false)
	public Presupuesto getPresupuesto() {
		return this.presupuesto;
	}

	public void setPresupuesto(Presupuesto presupuesto) {
		this.presupuesto = presupuesto;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "estadoPresupuesto")
	public List<Comprobante> getComprobantes() {
		return this.comprobantes;
	}

	public void setComprobantes(List<Comprobante> comprobantes) {
		this.comprobantes = comprobantes;
	}

}