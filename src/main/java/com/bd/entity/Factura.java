package com.bd.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Factura {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long nroComprobatePk;
    private String fechaFactura;
    private Integer importeTotal;
    private Long idCliente;
    
    //Agregados
    
	public Long getNroComprobatePk() {
		return nroComprobatePk;
	}
	public void setNroComprobatePk(Long nroComprobatePk) {
		this.nroComprobatePk = nroComprobatePk;
	}
	public String getFechaFactura() {
		return fechaFactura;
	}
	public void setFechaFactura(String fechaFactura) {
		this.fechaFactura = fechaFactura;
	}
	public Integer getImporteTotal() {
		return importeTotal;
	}
	public void setImporteTotal(Integer importeTotal) {
		this.importeTotal = importeTotal;
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
		result = prime * result + ((fechaFactura == null) ? 0 : fechaFactura.hashCode());
		result = prime * result + ((idCliente == null) ? 0 : idCliente.hashCode());
		result = prime * result + ((importeTotal == null) ? 0 : importeTotal.hashCode());
		result = prime * result + ((nroComprobatePk == null) ? 0 : nroComprobatePk.hashCode());
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
		Factura other = (Factura) obj;
		if (fechaFactura == null) {
			if (other.fechaFactura != null)
				return false;
		} else if (!fechaFactura.equals(other.fechaFactura))
			return false;
		if (idCliente == null) {
			if (other.idCliente != null)
				return false;
		} else if (!idCliente.equals(other.idCliente))
			return false;
		if (importeTotal == null) {
			if (other.importeTotal != null)
				return false;
		} else if (!importeTotal.equals(other.importeTotal))
			return false;
		if (nroComprobatePk == null) {
			if (other.nroComprobatePk != null)
				return false;
		} else if (!nroComprobatePk.equals(other.nroComprobatePk))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Factura [nroComprobatePk=" + nroComprobatePk + ", fechaFactura=" + fechaFactura + ", importeTotal="
				+ importeTotal + ", idCliente=" + idCliente + "]";
	}
    
    
}
