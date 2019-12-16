package com.bd.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Servicio {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long idServicio;
    private String tipoServicio;
    private Integer costoServicio;
    
    //Agregados
    
	public Long getIdServicio() {
		return idServicio;
	}
	public void setIdServicio(Long idServicio) {
		this.idServicio = idServicio;
	}
	public String getTipoServicio() {
		return tipoServicio;
	}
	public void setTipoServicio(String tipoServicio) {
		this.tipoServicio = tipoServicio;
	}
	public Integer getCostoServicio() {
		return costoServicio;
	}
	public void setCostoServicio(Integer costoServicio) {
		this.costoServicio = costoServicio;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((costoServicio == null) ? 0 : costoServicio.hashCode());
		result = prime * result + ((idServicio == null) ? 0 : idServicio.hashCode());
		result = prime * result + ((tipoServicio == null) ? 0 : tipoServicio.hashCode());
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
		Servicio other = (Servicio) obj;
		if (costoServicio == null) {
			if (other.costoServicio != null)
				return false;
		} else if (!costoServicio.equals(other.costoServicio))
			return false;
		if (idServicio == null) {
			if (other.idServicio != null)
				return false;
		} else if (!idServicio.equals(other.idServicio))
			return false;
		if (tipoServicio == null) {
			if (other.tipoServicio != null)
				return false;
		} else if (!tipoServicio.equals(other.tipoServicio))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Servicio [idServicio=" + idServicio + ", tipoServicio=" + tipoServicio + ", costoServicio="
				+ costoServicio + "]";
	}
    
    
}
