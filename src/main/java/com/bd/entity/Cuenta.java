package com.bd.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cuenta {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idCuentaCliente;
    private String fechaVencimiento;
    private String fechaPago;
    private Long idCliente;
    
    //Agregados
    
	public Long getIdCuentaCliente() {
		return idCuentaCliente;
	}
	public void setIdCuentaCliente(Long idCuentaCliente) {
		this.idCuentaCliente = idCuentaCliente;
	}
	public String getFechaVencimiento() {
		return fechaVencimiento;
	}
	public void setFechaVencimiento(String fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	public String getFechaPago() {
		return fechaPago;
	}
	public void setFechaPago(String fechaPago) {
		this.fechaPago = fechaPago;
	}
	public Long getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fechaPago == null) ? 0 : fechaPago.hashCode());
		result = prime * result + ((fechaVencimiento == null) ? 0 : fechaVencimiento.hashCode());
		result = prime * result + ((idCliente == null) ? 0 : idCliente.hashCode());
		result = prime * result + ((idCuentaCliente == null) ? 0 : idCuentaCliente.hashCode());
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
		Cuenta other = (Cuenta) obj;
		if (fechaPago == null) {
			if (other.fechaPago != null)
				return false;
		} else if (!fechaPago.equals(other.fechaPago))
			return false;
		if (fechaVencimiento == null) {
			if (other.fechaVencimiento != null)
				return false;
		} else if (!fechaVencimiento.equals(other.fechaVencimiento))
			return false;
		if (idCliente == null) {
			if (other.idCliente != null)
				return false;
		} else if (!idCliente.equals(other.idCliente))
			return false;
		if (idCuentaCliente == null) {
			if (other.idCuentaCliente != null)
				return false;
		} else if (!idCuentaCliente.equals(other.idCuentaCliente))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Cuenta [idCuentaCliente=" + idCuentaCliente + ", fechaVencimiento=" + fechaVencimiento + ", fechaPago="
				+ fechaPago + ", idCliente=" + idCliente + "]";
	}
    
    
}
