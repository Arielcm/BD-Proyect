package com.bd.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Dispositivo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idDispositivo;
    private String nombreDispositivo;
    private String tipoDispositivo;
    private Integer costoCompra;
    
    //Agegados
    
	public Long getIdDispositivo() {
		return idDispositivo;
	}
	public void setIdDispositivo(Long idDispositivo) {
		this.idDispositivo = idDispositivo;
	}
	public String getNombreDispositivo() {
		return nombreDispositivo;
	}
	public void setNombreDispositivo(String nombreDispositivo) {
		this.nombreDispositivo = nombreDispositivo;
	}
	public String getTipoDispositivo() {
		return tipoDispositivo;
	}
	public void setTipoDispositivo(String tipoDispositivo) {
		this.tipoDispositivo = tipoDispositivo;
	}
	public Integer getCostoCompra() {
		return costoCompra;
	}
	public void setCostoCompra(Integer costoCompra) {
		this.costoCompra = costoCompra;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((costoCompra == null) ? 0 : costoCompra.hashCode());
		result = prime * result + ((idDispositivo == null) ? 0 : idDispositivo.hashCode());
		result = prime * result + ((nombreDispositivo == null) ? 0 : nombreDispositivo.hashCode());
		result = prime * result + ((tipoDispositivo == null) ? 0 : tipoDispositivo.hashCode());
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
		Dispositivo other = (Dispositivo) obj;
		if (costoCompra == null) {
			if (other.costoCompra != null)
				return false;
		} else if (!costoCompra.equals(other.costoCompra))
			return false;
		if (idDispositivo == null) {
			if (other.idDispositivo != null)
				return false;
		} else if (!idDispositivo.equals(other.idDispositivo))
			return false;
		if (nombreDispositivo == null) {
			if (other.nombreDispositivo != null)
				return false;
		} else if (!nombreDispositivo.equals(other.nombreDispositivo))
			return false;
		if (tipoDispositivo == null) {
			if (other.tipoDispositivo != null)
				return false;
		} else if (!tipoDispositivo.equals(other.tipoDispositivo))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Dispositivo [idDispositivo=" + idDispositivo + ", nombreDispositivo=" + nombreDispositivo
				+ ", tipoDispositivo=" + tipoDispositivo + ", costoCompra=" + costoCompra + "]";
	}
    
	
    
}
