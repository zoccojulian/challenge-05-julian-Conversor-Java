package ar.com.conversor.challenge.modelo;

public class UnidadTemperaturaFarenheit extends Unidad {

	public UnidadTemperaturaFarenheit() {
		super("Farenheit", 0);
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public double convertirDeUnidad(double monto) {
		System.out.println((monto - 32)*5/9);
		return (monto - 32)*5/9;
		
	}
	
	@Override
	public double convertirAUnidad(double monto) {
		System.out.println((monto * 9/5) + 32);
		return (monto * 9/5) + 32;
	}
	

}
