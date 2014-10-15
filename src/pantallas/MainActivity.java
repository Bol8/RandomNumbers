package pantallas;

import codigo.RandomNumber;
import codigo.RangoException;
import codigo.RangoMenorTamañoException;
import codigo.TamañoException;

import com.example.randomnumbers.R;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {
	EditText rango, tamaño;
	TextView resultado;
	Button boton;
	RandomNumber rand;
	RadioButton r1, r2;
	RadioGroup rg;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		rango = (EditText) findViewById(R.id.editRango);
		tamaño = (EditText) findViewById(R.id.editTamano);
		resultado = (TextView) findViewById(R.id.textResultado);
		boton = (Button) findViewById(R.id.button1);
		rg = (RadioGroup) findViewById(R.id.gruporb);
		rg.check(R.id.radioButton1);
		r1 = (RadioButton) findViewById(R.id.radioButton1);
		r2 = (RadioButton) findViewById(R.id.radioButton2);

		boton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				generaNumeros();

			}
		});

	}

	public void generaNumeros() {

		try {
			int rg = Integer.parseInt(rango.getText().toString());
			int tam = Integer.parseInt(tamaño.getText().toString());
			boolean ordenado = eleccionOrden();
			rand = new RandomNumber(rg, tam,ordenado);
			resultado.setText(rand.mostrarNúmeros());
		} catch (RangoException e) {
			String texto = e.getMessage();
			Toast.makeText(getApplicationContext(), texto, Toast.LENGTH_SHORT)
					.show();

		} catch (TamañoException e) {
			String texto = e.getMessage();
			Toast.makeText(getApplicationContext(), texto, Toast.LENGTH_SHORT)
					.show();

		} catch (RangoMenorTamañoException e) {

			String texto = e.getMessage();
			Toast.makeText(getApplicationContext(), texto, Toast.LENGTH_SHORT)
					.show();

		} catch (Exception e) {
			String texto = "No puedes dejar los campos vacios";
			Toast.makeText(getApplicationContext(), texto, Toast.LENGTH_SHORT)
					.show();

		}

	}

	private boolean eleccionOrden() {
		if (r1.isChecked() == true) {
			return true;
		} else

			return false;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
