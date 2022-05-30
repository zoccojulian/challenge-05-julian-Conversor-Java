package ar.com.conversor.challenge.modelo;

public class Unidad {
	
	protected String nombre;
	protected double tazaDeconversion;
	
	public Unidad (String nombre, double cambio) {
		this.nombre = nombre;
		this.tazaDeconversion = cambio;
	}
	
	
	public String getNombre() {
		
		return this.nombre;
	}
	
	
	public double getTazaDeConversion() {
		return this.tazaDeconversion;
	}
	
	public double convertirAUnidad(double monto) {
		//return monto/this.tazaDeconversion;
		return Math.round(monto/this.tazaDeconversion*100.0)/100.0;
	}
	
	public double convertirDeUnidad(double monto) {
		//return monto * this.tazaDeconversion;
		return Math.round(monto * this.tazaDeconversion*100.0)/100.0;
	}
	
	
}
