package com.bd.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class LineaFactura {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long nroLinea;
    private int codItem;
    private String nombreItem;
    private Integer cantidadItem;
    private Integer importeLinea;
    private Long factura;
    
    //Agregados
    
	public Long getNroLinea() {
		return nroLinea;
	}
	public void setNroLinea(Long nroLinea) {
		this.nroLinea = nroLinea;
	}
	public int getCodItem() {
		return codItem;
	}
	public void setCodItem(int codItem) {
		this.codItem = codItem;
	}
	public String getNombreItem() {
		return nombreItem;
	}
	public void setNombreItem(String nombreItem) {
		this.nombreItem = nombreItem;
	}
	public Integer getCantidadItem() {
		return cantidadItem;
	}
	public void setCantidadItem(Integer cantidadItem) {
		this.cantidadItem = cantidadItem;
	}
	public Integer getImporteLinea() {
		return importeLinea;
	}
	public void setImporteLinea(Integer importeLinea) {
		this.importeLinea = importeLinea;
	}
	public Long getFactura() {
		return factura;
	}
	public void setFactura(Long factura) {
		this.factura = factura;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cantidadItem == null) ? 0 : cantidadItem.hashCode());
		result = prime * result + codItem;
		result = prime * result + ((factura == null) ? 0 : factura.hashCode());
		result = prime * result + ((importeLinea == null) ? 0 : importeLinea.hashCode());
		result = prime * result + ((nombreItem == null) ? 0 : nombreItem.hashCode());
		result = prime * result + ((nroLinea == null) ? 0 : nroLinea.hashCode());
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
		LineaFactura other = (LineaFactura) obj;
		if (cantidadItem == null) {
			if (other.cantidadItem != null)
				return false;
		} else if (!cantidadItem.equals(other.cantidadItem))
			return false;
		if (codItem != other.codItem)
			return false;
		if (factura == null) {
			if (other.factura != null)
				return false;
		} else if (!factura.equals(other.factura))
			return false;
		if (importeLinea == null) {
			if (other.importeLinea != null)
				return false;
		} else if (!importeLinea.equals(other.importeLinea))
			return false;
		if (nombreItem == null) {
			if (other.nombreItem != null)
				return false;
		} else if (!nombreItem.equals(other.nombreItem))
			return false;
		if (nroLinea == null) {
			if (other.nroLinea != null)
				return false;
		} else if (!nroLinea.equals(other.nroLinea))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "LineaFactura [nroLinea=" + nroLinea + ", codItem=" + codItem + ", nombreItem=" + nombreItem
				+ ", cantidadItem=" + cantidadItem + ", importeLinea=" + importeLinea + ", factura=" + factura + "]";
	}
    
    
}
