package com.bd.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;

@Entity
public class Turno {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idTurno;

    private String estadoTurno;
	@NotBlank
    private String fechaTurno;
	@NotBlank
    private String idUsuario;
    
  //Crea Tabla intermedia Turno-Tarea
    @ManyToMany
    @JoinTable(name="Turno_tiene_Tarea"
    	,joinColumns = @JoinColumn(name="Turno_id")
    	,inverseJoinColumns = @JoinColumn(name="Tarea_id")
    		)
    private Set<Tarea> tareas;

  //Agregados
    
	public Long getIdTurno() {
		return idTurno;
	}

	public void setIdTurno(Long idTurno) {
		this.idTurno = idTurno;
	}

	public String getEstadoTurno() {
		return estadoTurno;
	}

	public void setEstadoTurno(String estadoTurno) {
		this.estadoTurno = estadoTurno;
	}

	public String getFechaTurno() {
		return fechaTurno;
	}

	public void setFechaTurno(String fechaTurno) {
		this.fechaTurno = fechaTurno;
	}

	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Set<Tarea> getTareas() {
		return tareas;
	}

	public void setTareas(Set<Tarea> tareas) {
		this.tareas = tareas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((estadoTurno == null) ? 0 : estadoTurno.hashCode());
		result = prime * result + ((fechaTurno == null) ? 0 : fechaTurno.hashCode());
		result = prime * result + ((idTurno == null) ? 0 : idTurno.hashCode());
		result = prime * result + ((idUsuario == null) ? 0 : idUsuario.hashCode());
		result = prime * result + ((tareas == null) ? 0 : tareas.hashCode());
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
		Turno other = (Turno) obj;
		if (estadoTurno == null) {
			if (other.estadoTurno != null)
				return false;
		} else if (!estadoTurno.equals(other.estadoTurno))
			return false;
		if (fechaTurno == null) {
			if (other.fechaTurno != null)
				return false;
		} else if (!fechaTurno.equals(other.fechaTurno))
			return false;
		if (idTurno == null) {
			if (other.idTurno != null)
				return false;
		} else if (!idTurno.equals(other.idTurno))
			return false;
		if (idUsuario == null) {
			if (other.idUsuario != null)
				return false;
		} else if (!idUsuario.equals(other.idUsuario))
			return false;
		if (tareas == null) {
			if (other.tareas != null)
				return false;
		} else if (!tareas.equals(other.tareas))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Turno [idTurno=" + idTurno + ", estadoTurno=" + estadoTurno + ", fechaTurno=" + fechaTurno
				+ ", idUsuario=" + idUsuario + ", tareas=" + tareas + "]";
	}
    
  
    
    
}
