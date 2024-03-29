package codigo;

import java.util.Arrays;
import java.util.Random;

public class RandomNumber {
	private int rango;
	private int tamaño;
	private int lista[];
	boolean orden;

	public RandomNumber(int rango, int tamaño, boolean orden)
			throws RangoException, TamañoException, RangoMenorTamañoException {

		this.setRango(rango);
		this.setTamaño(tamaño);
		lista = new int[tamaño];
		this.orden = orden;
		generarAleatorios();
	}

	public int getRango() {
		return rango;
	}

	public void setRango(int rango) throws RangoException {
		if (validarRango(rango)) {
			this.rango = rango;
		}

	}

	public int getTamaño() {
		return tamaño;
	}

	public void setTamaño(int tamaño) throws TamañoException {
		if (validarTamaño(tamaño)) {
			this.tamaño = tamaño;
		}
	}

	private boolean validarTamaño(int tam) throws TamañoException {

		if (tam < 1 || tam > 20) {
			throw new TamañoException("Debe de estar entre 1 y 20");
		} else

			return true;
	}

	private boolean validarRango(int rg) throws RangoException {

		if (rg < 1) {
			throw new RangoException("No se admiten números menor que 1");
		} else

			return true;
	}

	private void generarAleatorios() throws RangoMenorTamañoException {
		Random rand = new Random();
		int aleatorio;

		if (rango < lista.length) {
			throw new RangoMenorTamañoException(
					"El rango debe ser mayor que el total de números");
		} else {

			for (int i = 0; i < lista.length; i++) {
				aleatorio = rand.nextInt(rango) + 1;

				while (comprobarAleatorios(aleatorio)) {
					aleatorio = rand.nextInt(rango) + 1;
				}

				lista[i] = aleatorio;
			}

			if (orden) {
				Arrays.sort(lista);
			}

		}
	}

	private boolean comprobarAleatorios(int aleatorio) {

		for (int i = 0; i < lista.length; i++) {
			if (lista[i] == aleatorio) {
				return true;
			}

		}

		return false;
	}

	public String mostrarNúmeros() {
		StringBuffer buffer = new StringBuffer();

		for (int i = 0; i < lista.length; i++) {
			buffer.append(" " + lista[i]);
		}

		return buffer.toString();

	}

}
