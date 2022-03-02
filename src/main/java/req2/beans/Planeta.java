package req2.beans;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="planeta")

@XmlType(propOrder = {
	    "nombre",
	    "tipo",
	    "numeroSatelites",
	    "distanciaDelSol",
	    "datosPlanetarios"
	})
public class Planeta {
	
	private String nombre;
	private String tipo;
	private int numeroSatelites;
	private double distanciaDelSol; //años luz
	private DatosPlanetarios datosPlanetarios;
	
	public Planeta() {
		
	}

	public Planeta(String nombre, String tipo, int numeroSatelites, double distanciaDelSol) {
		super();
		this.nombre = nombre;
		this.tipo = tipo;
		this.numeroSatelites = numeroSatelites;
		this.distanciaDelSol = distanciaDelSol;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getNumeroSatelites() {
		return numeroSatelites;
	}

	public void setNumeroSatelites(int numeroSatelites) {
		this.numeroSatelites = numeroSatelites;
	}

	public double getDistanciaDelSol() {
		return distanciaDelSol;
	}

	public void setDistanciaDelSol(double distanciaDelSol) {
		this.distanciaDelSol = distanciaDelSol;
	}

	public DatosPlanetarios getDatosPlanetarios() {
		return datosPlanetarios;
	}

	public void setDatosPlanetarios(DatosPlanetarios datosPlanetarios) {
		this.datosPlanetarios = datosPlanetarios;
	}

	@Override
	public String toString() {
		return "Planeta [nombre=" + nombre + ", tipo=" + tipo + ", numeroSatelites=" + numeroSatelites
				+ ", distanciaDelSol=" + distanciaDelSol + ", datosPlanetarios=" + datosPlanetarios + "]";
	}

}
