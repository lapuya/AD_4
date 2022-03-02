package req2.beans;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

@XmlRootElement(name="sistema")
public class Sistema {
	
	private String galaxia;
	private String nombre;
	private List<Planeta> planetas;
	

	public Sistema() {
		planetas = new ArrayList<Planeta>();
	}


	public String getGalaxia() {
		return galaxia;
	}


	public void setGalaxia(String galaxia) {
		this.galaxia = galaxia;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@XmlElement(name="planeta")
	@XmlElementWrapper(name="planetas")
	public List<Planeta> getPlanetas() {
		return planetas;
	}


	public void setPlanetas(List<Planeta> planetas) {
		this.planetas = planetas;
	}
	
	
}
