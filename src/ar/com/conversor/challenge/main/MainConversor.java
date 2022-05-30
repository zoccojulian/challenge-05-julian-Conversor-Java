package ar.com.conversor.challenge.main;

import javax.swing.JOptionPane;
import ar.com.conversor.challenge.modelo.Conversor;
import ar.com.conversor.challenge.modelo.ListaDeConversores;
import ar.com.conversor.challenge.modelo.Unidad;
import ar.com.conversor.challenge.modelo.UnidadTemperaturaFarenheit;
import ar.com.conversor.challenge.modelo.UnidadTemperaturaKelvin;

public class MainConversor {
	public static void main(String[] args) {

		// Creaci�n de un conversor de moneda(Pesos Argentinos)
		Unidad[] monedasPesosUnidadesConversion = { new Unidad("D�lares", 118.2500), new Unidad("Euros", 120.00),
				new Unidad("Libra Esterlina", 150.2), new Unidad("Reales", 22.70) };
		Conversor conversorMonedasPesos = new Conversor("Moneda / Pesos Argentinos", monedasPesosUnidadesConversion,
				"Pesos Argentinos");
		
		//Creaci�n de un conversor de moneda(D�lares Estadounidenses)
		Unidad[] monedasDolaresUnidadesConversion = { new Unidad("Pesos Argentinos", 0.0084), new Unidad("Euros", 1.08),
				new Unidad("Libra Esterlina", 1.26), new Unidad("Reales", 0.21) };
		Conversor conversorMonedasDolares = new Conversor("Moneda / D�lares Estadounidenses", monedasDolaresUnidadesConversion,
				"D�lares Estadounidenses");
		
		// Creaci�n de conversor de medidas(unidad base Metro)
		Unidad[] medidasUnidadesConversion = { new Unidad("Milla", 1609.34), new Unidad("Yarda", 0.9144),
				new Unidad("Pie", 0.3048), new Unidad("Pulgada", 0.0254), new Unidad("Milla N�utica", 1852) };
		Conversor conversorMedidad = new Conversor("Medida", medidasUnidadesConversion, "Metro");

		// Creaci�n de conversor de temperatura(unidad base Celcius)
		Unidad[] temperaturaUnidadesConversion = { new UnidadTemperaturaFarenheit(), new UnidadTemperaturaKelvin() };
		Conversor conversorTemperatura = new Conversor("temperatura", temperaturaUnidadesConversion, "Celsius");

		// Lista de todos los convertidores
		Conversor[] conversores = { conversorMonedasPesos, conversorMonedasDolares, conversorMedidad, conversorTemperatura };
		ListaDeConversores listaDeConversores = new ListaDeConversores(conversores);

		// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		
		//variable que define si el programa termina
		boolean finDeEjecucion = false;

		
		//comienzo del programa
		do {

			boolean menuPrincipal = false;
			
			String conversorElegido = "";

			try {
				conversorElegido = JOptionPane.showInputDialog(null, "Que conversor quiere utilizar?",
						"Tipo de Conversiones", JOptionPane.QUESTION_MESSAGE, null, // null para icono defecto
						listaDeConversores.getListaConversores(), "opcion 1").toString();
			} catch (NullPointerException e) {
				JOptionPane.showMessageDialog(null, "Se cerr� el programa");
				break;

			}
			
			//Conversor elegido
			Conversor conversor = listaDeConversores.getConversor(conversorElegido);
			
			
			//Variable para almacenar el tipo de conversion
			String stringConversion="";
			
			//Elecci�n de que conversion va a realizar
			if(!menuPrincipal) try {

				stringConversion = JOptionPane.showInputDialog(null, "Que conversi�n desea realizar?",
						conversor.getNombre(), JOptionPane.QUESTION_MESSAGE, null, // null para icono defecto
						conversor.getListaConversiones(), "opcion 1").toString();
				
			}catch (NullPointerException e) {
				menuPrincipal = true;
			}
			
			//Variable para almacenar el valor ingresado
			String valorIngresado= "";
			
			//Variable para castear el valor ingresado
			float valorIngresadoFloat=0;
			
			//Ingreso del valor a convertir
			if(!menuPrincipal) try {
				
				//variable para almacenar la exception que arroja el casteo a float
				//para parar el do-while
				String error="";
				
				//Ingreso del valor con validaci�n simple.
				//La validaci�n se hace a trav�s del casteo del string a float
				//usando la exception NumberFormatException como par�metro
				//para saber si el input es o no un n�mero valido
				do {
					try {
						valorIngresado = JOptionPane.showInputDialog("Ingrese valor a convertira " + stringConversion + ":");
						valorIngresadoFloat = Float.parseFloat(valorIngresado);
						error = "";
					}catch(NumberFormatException e) {
						error = e.toString();
						JOptionPane.showMessageDialog(null, "Debe ingresar un n�mero v�lido! (xxxx.xx)");
					}
				}while(error != "");
				
				
			}catch(NullPointerException e) {
				menuPrincipal = true;
			}
			
			
			//Muestra del resultado
			//if(!menuPrincipal) JOptionPane.showMessageDialog(null, "Resultado en " + conversor.getNombreMoneda(stringConversion) + " es: "
				//	+ conversor.convertir(stringConversion, monto));
			if(!menuPrincipal) JOptionPane.showMessageDialog(null,"Resultado en " + conversor.getNombreMoneda(stringConversion) + " es: "
					+ conversor.convertir(stringConversion, valorIngresadoFloat),
					stringConversion, JOptionPane.INFORMATION_MESSAGE, null);
			
			
			
			//Pregunta si quiere realizar otra conversion
			int opcion = 0;
			if (!menuPrincipal) opcion = JOptionPane.showConfirmDialog(null, "Desea realizar otra conversi�n?");
			//opcion 0 = si => vuelve al men�
			//opcion 1 = no => cierra el programa
			//opcion 2 = cancelar => cierra el programa
			
			if(opcion == 1 || opcion == 2) {
				JOptionPane.showMessageDialog(null, "Se cerr� el programa");
				break;
			}
			
			
		} while (!finDeEjecucion);

	}
}
