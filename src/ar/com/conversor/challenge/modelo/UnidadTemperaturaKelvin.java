package ar.com.conversor.challenge.modelo;

public class UnidadTemperaturaKelvin extends Unidad {

	public UnidadTemperaturaKelvin() {
		super("kelvin", 0);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public double convertirDeUnidad(double monto) {
		return monto - 273.15;
	}
	
	@Override
	public double convertirAUnidad(double monto) {
		return monto + 273.15;
	}
	

}
