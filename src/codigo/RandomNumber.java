package codigo;

import java.util.Arrays;
import java.util.Random;

public class RandomNumber {
	private int rango;
	private int tamaño;
	private int lista[];

	public RandomNumber(int rango, int tamaño) throws RangoException,
			TamañoException {

		this.setRango(rango);
		this.setTamaño(tamaño);
		lista = new int[tamaño];
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

		if (tam < 1 || tam > 21) {
			throw new TamañoException("El número máximo permitido son 20");
		} else

			return true;
	}

	private boolean validarRango(int rg) throws RangoException {

		if (rg < 1) {
			throw new RangoException("No se admiten números menor que 1");
		} else

			return true;
	}

	private void generarAleatorios() {
		Random rand = new Random();
		int aleatorio;

		for (int i = 0; i < lista.length; i++) {
			aleatorio = rand.nextInt(rango) + 1;

			while (comprobarAleatorios(aleatorio)) {
				aleatorio = rand.nextInt(rango) + 1;
			}

			lista[i] = aleatorio;
		}

		Arrays.sort(lista);

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
