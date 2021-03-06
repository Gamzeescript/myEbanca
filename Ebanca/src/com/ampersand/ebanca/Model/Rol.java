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
 * Rol generated by hbm2java
 */
@Entity
@Table(name = "rol", catalog = "mibanco")
public class Rol implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer idRol;
	private String rol;
	private List<Usuario> usuarios = new ArrayList<Usuario>(0);

	public Rol() {
	}

	public Rol(String rol) {
		this.rol = rol;
	}

	public Rol(String rol, List<Usuario> usuarios) {
		this.rol = rol;
		this.usuarios = usuarios;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id_rol", unique = true, nullable = false)
	public Integer getIdRol() {
		return this.idRol;
	}

	public void setIdRol(Integer idRol) {
		this.idRol = idRol;
	}

	@Column(name = "rol", nullable = false, length = 50)
	public String getRol() {
		return this.rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "rol")
	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}
