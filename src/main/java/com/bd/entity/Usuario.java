package com.bd.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Usuario {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idUsuario;
	@NotBlank
    private String nombreUsuario;
	@NotBlank
    private String apellidoUsuario;
	@NotBlank
    private String telefonoUsuario;
	@NotBlank
    private String direccionUsuario;
	@NotBlank
    private String dni;

    private String esJefe;
	@NotBlank
    private String area;
    
    
  //Agregados
    
	public Long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getApellidoUsuario() {
		return apellidoUsuario;
	}
	public void setApellidoUsuario(String apellidoUsuario) {
		this.apellidoUsuario = apellidoUsuario;
	}
	public String getTelefonoUsuario() {
		return telefonoUsuario;
	}
	public void setTelefonoUsuario(String telefonoUsuario) {
		this.telefonoUsuario = telefonoUsuario;
	}
	public String getDireccionUsuario() {
		return direccionUsuario;
	}
	public void setDireccionUsuario(String direccionUsuario) {
		this.direccionUsuario = direccionUsuario;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getEsJefe() {
		return esJefe;
	}
	public void setEsJefe(String esJefe) {
		this.esJefe = esJefe;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apellidoUsuario == null) ? 0 : apellidoUsuario.hashCode());
		result = prime * result + ((area == null) ? 0 : area.hashCode());
		result = prime * result + ((direccionUsuario == null) ? 0 : direccionUsuario.hashCode());
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());

		result = prime * result + ((idUsuario == null) ? 0 : idUsuario.hashCode());
		result = prime * result + ((nombreUsuario == null) ? 0 : nombreUsuario.hashCode());
		result = prime * result + ((telefonoUsuario == null) ? 0 : telefonoUsuario.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (apellidoUsuario == null) {
			if (other.apellidoUsuario != null)
				return false;
		} else if (!apellidoUsuario.equals(other.apellidoUsuario))
			return false;
		if (area == null) {
			if (other.area != null)
				return false;
		} else if (!area.equals(other.area))
			return false;
		if (direccionUsuario == null) {
			if (other.direccionUsuario != null)
				return false;
		} else if (!direccionUsuario.equals(other.direccionUsuario))
			return false;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		if (idUsuario == null) {
			if (other.idUsuario != null)
				return false;
		} else if (!idUsuario.equals(other.idUsuario))
			return false;
		if (nombreUsuario == null) {
			if (other.nombreUsuario != null)
				return false;
		} else if (!nombreUsuario.equals(other.nombreUsuario))
			return false;
		if (telefonoUsuario == null) {
			if (other.telefonoUsuario != null)
				return false;
		} else if (!telefonoUsuario.equals(other.telefonoUsuario))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", nombreUsuario=" + nombreUsuario + ", apellidoUsuario="
				+ apellidoUsuario + ", telefonoUsuario=" + telefonoUsuario + ", direccionUsuario=" + direccionUsuario
				+ ", dni=" + dni + ", esJefe=" + esJefe + ", area=" + area + "]";
	}
	
	

    
    
}
