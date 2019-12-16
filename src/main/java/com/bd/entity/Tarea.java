package com.bd.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tarea {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idTareaPk;
    private String tipoTarea;
    private String descripcionTarea;
    private Integer costoMo;
    private String fechaInstalacion;
    private Long dispositivo;
    
  //Agegados
	public Long getIdTareaPk() {
		return idTareaPk;
	}
	public void setIdTareaPk(Long idTareaPk) {
		this.idTareaPk = idTareaPk;
	}
	public String getTipoTarea() {
		return tipoTarea;
	}
	public void setTipoTarea(String tipoTarea) {
		this.tipoTarea = tipoTarea;
	}
	public String getDescripcionTarea() {
		return descripcionTarea;
	}
	public void setDescripcionTarea(String descripcionTarea) {
		this.descripcionTarea = descripcionTarea;
	}
	public Integer getCostoMo() {
		return costoMo;
	}
	public void setCostoMo(Integer costoMo) {
		this.costoMo = costoMo;
	}
	public String getFechaInstalacion() {
		return fechaInstalacion;
	}
	public void setFechaInstalacion(String fechaInstalacion) {
		this.fechaInstalacion = fechaInstalacion;
	}
	public Long getDispositivo() {
		return dispositivo;
	}
	public void setDispositivo(Long dispositivo) {
		this.dispositivo = dispositivo;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((costoMo == null) ? 0 : costoMo.hashCode());
		result = prime * result + ((descripcionTarea == null) ? 0 : descripcionTarea.hashCode());
		result = prime * result + ((dispositivo == null) ? 0 : dispositivo.hashCode());
		result = prime * result + ((fechaInstalacion == null) ? 0 : fechaInstalacion.hashCode());
		result = prime * result + ((idTareaPk == null) ? 0 : idTareaPk.hashCode());
		result = prime * result + ((tipoTarea == null) ? 0 : tipoTarea.hashCode());
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
		Tarea other = (Tarea) obj;
		if (costoMo == null) {
			if (other.costoMo != null)
				return false;
		} else if (!costoMo.equals(other.costoMo))
			return false;
		if (descripcionTarea == null) {
			if (other.descripcionTarea != null)
				return false;
		} else if (!descripcionTarea.equals(other.descripcionTarea))
			return false;
		if (dispositivo == null) {
			if (other.dispositivo != null)
				return false;
		} else if (!dispositivo.equals(other.dispositivo))
			return false;
		if (fechaInstalacion == null) {
			if (other.fechaInstalacion != null)
				return false;
		} else if (!fechaInstalacion.equals(other.fechaInstalacion))
			return false;
		if (idTareaPk == null) {
			if (other.idTareaPk != null)
				return false;
		} else if (!idTareaPk.equals(other.idTareaPk))
			return false;
		if (tipoTarea == null) {
			if (other.tipoTarea != null)
				return false;
		} else if (!tipoTarea.equals(other.tipoTarea))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Tarea [idTareaPk=" + idTareaPk + ", tipoTarea=" + tipoTarea + ", descripcionTarea=" + descripcionTarea
				+ ", costoMo=" + costoMo + ", fechaInstalacion=" + fechaInstalacion + ", dispositivo=" + dispositivo
				+ "]";
	}
    
    
    
    
}
