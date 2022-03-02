package req2.beans;

public class DatosPlanetarios {
	
	private double gravedad;
	private double radio;
	private String duracionDia;
	
	public double getGravedad() {
		return gravedad;
	}
	public void setGravedad(double gravedad) {
		this.gravedad = gravedad;
	}
	public double getRadio() {
		return radio;
	}
	public void setRadio(double radio) {
		this.radio = radio;
	}
	public String getDuracionDia() {
		return duracionDia;
	}
	public void setDuracionDia(String duracionDia) {
		this.duracionDia = duracionDia;
	}
	@Override
	public String toString() {
		return "DatosPlanetarios [gravedad=" + gravedad + ", radio=" + radio + ", duracionDia=" + duracionDia + "]";
	}
	
	
}
