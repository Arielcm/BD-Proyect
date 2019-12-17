package com.bd.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;


@Entity
public class Cliente {
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Long idCliente;
	    private String nombreCliente;
	    private String apellidoCliente;
	    private String telefonoCliente;
	    private String direccionCliente;
	    private String dniCuitCliente;
	    
	    //Crea Tabla intermedia Cliente-Turno
	    @ManyToMany
	    @JoinTable(name="Solicita"
	    	,joinColumns = @JoinColumn(name="Cliente_id")
	    	,inverseJoinColumns = @JoinColumn(name="Turno_id")
	    		)
	    private Set<Turno> turnos;
	    
	  //Crea Tabla intermedia Cliente-Servicio
	    @ManyToMany
	    @JoinTable(name="Contrata_Servicio"
	    	,joinColumns = @JoinColumn(name="Cliente_id")
	    	,inverseJoinColumns = @JoinColumn(name="Servicio_id")
	    		)
	    private Set<Servicio> Servicios;

	    
	    //Agregados
	    
		public Long getIdCliente() {
			return idCliente;
		}

		public void setIdCliente(Long idCliente) {
			this.idCliente = idCliente;
		}

		public String getNombreCliente() {
			return nombreCliente;
		}

		public void setNombreCliente(String nombreCliente) {
			this.nombreCliente = nombreCliente;
		}

		public String getApellidoCliente() {
			return apellidoCliente;
		}

		public void setApellidoCliente(String apellidoCliente) {
			this.apellidoCliente = apellidoCliente;
		}

		public String getTelefonoCliente() {
			return telefonoCliente;
		}

		public void setTelefonoCliente(String telefonoCliente) {
			this.telefonoCliente = telefonoCliente;
		}

		public String getDireccionCliente() {
			return direccionCliente;
		}

		public void setDireccionCliente(String direccionCliente) {
			this.direccionCliente = direccionCliente;
		}

		public String getDniCuitCliente() {
			return dniCuitCliente;
		}

		public void setDniCuitCliente(String dniCuitCliente) {
			this.dniCuitCliente = dniCuitCliente;
		}

		public Set<Turno> getTurnos() {
			return turnos;
		}

		public void setTurnos(Set<Turno> turnos) {
			this.turnos = turnos;
		}

		public Set<Servicio> getServicios() {
			return Servicios;
		}

		public void setServicios(Set<Servicio> servicios) {
			Servicios = servicios;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((Servicios == null) ? 0 : Servicios.hashCode());
			result = prime * result + ((apellidoCliente == null) ? 0 : apellidoCliente.hashCode());
			result = prime * result + ((direccionCliente == null) ? 0 : direccionCliente.hashCode());
			result = prime * result + ((dniCuitCliente == null) ? 0 : dniCuitCliente.hashCode());
			result = prime * result + ((idCliente == null) ? 0 : idCliente.hashCode());
			result = prime * result + ((nombreCliente == null) ? 0 : nombreCliente.hashCode());
			result = prime * result + ((telefonoCliente == null) ? 0 : telefonoCliente.hashCode());
			result = prime * result + ((turnos == null) ? 0 : turnos.hashCode());
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
			Cliente other = (Cliente) obj;
			if (Servicios == null) {
				if (other.Servicios != null)
					return false;
			} else if (!Servicios.equals(other.Servicios))
				return false;
			if (apellidoCliente == null) {
				if (other.apellidoCliente != null)
					return false;
			} else if (!apellidoCliente.equals(other.apellidoCliente))
				return false;
			if (direccionCliente == null) {
				if (other.direccionCliente != null)
					return false;
			} else if (!direccionCliente.equals(other.direccionCliente))
				return false;
			if (dniCuitCliente == null) {
				if (other.dniCuitCliente != null)
					return false;
			} else if (!dniCuitCliente.equals(other.dniCuitCliente))
				return false;
			if (idCliente == null) {
				if (other.idCliente != null)
					return false;
			} else if (!idCliente.equals(other.idCliente))
				return false;
			if (nombreCliente == null) {
				if (other.nombreCliente != null)
					return false;
			} else if (!nombreCliente.equals(other.nombreCliente))
				return false;
			if (telefonoCliente == null) {
				if (other.telefonoCliente != null)
					return false;
			} else if (!telefonoCliente.equals(other.telefonoCliente))
				return false;
			if (turnos == null) {
				if (other.turnos != null)
					return false;
			} else if (!turnos.equals(other.turnos))
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Cliente [idCliente=" + idCliente + ", nombreCliente=" + nombreCliente + ", apellidoCliente="
					+ apellidoCliente + ", telefonoCliente=" + telefonoCliente + ", direccionCliente="
					+ direccionCliente + ", dniCuitCliente=" + dniCuitCliente + ", turnos=" + turnos + ", Servicios="
					+ Servicios + "]";
		}
	    
		
	    
}
