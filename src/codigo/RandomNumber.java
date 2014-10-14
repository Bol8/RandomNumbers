package codigo;

import java.util.Arrays;
import java.util.Random;

public class RandomNumber {
	private int rango;
	private int tama�o;
	private int lista[];

	public RandomNumber(int rango, int tama�o) throws RangoException,
			Tama�oException {

		this.setRango(rango);
		this.setTama�o(tama�o);
		lista = new int[tama�o];
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

	public int getTama�o() {
		return tama�o;
	}

	public void setTama�o(int tama�o) throws Tama�oException {
		if (validarTama�o(tama�o)) {
			this.tama�o = tama�o;
		}
	}

	private boolean validarTama�o(int tam) throws Tama�oException {

		if (tam < 1 || tam > 21) {
			throw new Tama�oException("El n�mero m�ximo permitido son 20");
		} else

			return true;
	}

	private boolean validarRango(int rg) throws RangoException {

		if (rg < 1) {
			throw new RangoException("No se admiten n�meros menor que 1");
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

	public String mostrarN�meros() {
		StringBuffer buffer = new StringBuffer();

		for (int i = 0; i < lista.length; i++) {
			buffer.append(" " + lista[i]);
		}

		return buffer.toString();

	}

}
