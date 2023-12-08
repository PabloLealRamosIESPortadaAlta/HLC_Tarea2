package com.example.hlc_tarea2.Ejerciciio1

import android.media.MediaPlayer
import android.os.Bundle
import android.os.CountDownTimer
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.util.LogPrinter
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog.Builder
import androidx.appcompat.app.AppCompatActivity

import com.example.hlc_tarea2.R
import com.example.hlc_tarea2.databinding.ActivityMain1Binding
import java.lang.Integer.parseInt
import java.lang.Integer.parseUnsignedInt

/**
	*     Modificar la aplicación Contador de cafés para que reproduzca un sonido cada vez que el
	*     contador de tiempo llegue a 0, además de incrementar el contador de cafés.
	*
	* Para reproducir un fichero de audio se puede usar la clase MediaPlayer.
	* MediaPlayer mp = MediaPlayer.create(this, R.raw.audio);
	* mp.start();
	* El fichero audio.mp3 tiene que estar almacenado en la carpeta /res/raw/ y se reproducirá al
	* ejecutar el método start().
	* También se limitará el número de cafés que se pueden tomar. Se debe impedir que la aplicación
	* siga funcionando cuando el contador de cafés llegue a 10. Se añadirá un botón para poner el
	* contador a 0 y permitir que vuelva a funcionar el contador.
	* Además, cuando se alcance el límite de 10 aparecerá un popup donde se mostrará el mensaje Fin!!
	* Para mostrar un popup se puede usar el siguiente código:
	* AlertDialog.Builder popup=new AlertDialog.Builder(this);
	* popup.setTitle("Titulo del mensaje");
	* popup.setMessage("Cuerpo del mensaje");
	* popup.setPositiveButton("Ok", null);
	* popup.show();
	* También se valorará la realización de otras mejoras: añadir un switch para elegir usar un
	* contador ascendente o descendente, por ejemplo.
	*
	*/
class MainActivity1 : AppCompatActivity(), View.OnClickListener  {
	 //val binding = ActivityMain1Binding.inflate(layoutInflater)
	private lateinit var binding: ActivityMain1Binding
	private lateinit var contador: Contador
	private lateinit var contadorDescendente: MyCountDownTimer
	private val PAUSA = 3

/*	var alertDialog: AlertDialog? = null*/
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		// setContentView(R.layout.activity_main)
		binding = ActivityMain1Binding.inflate(layoutInflater)
		val view: View = binding.root
		setContentView(view)

		contador = Contador(0, PAUSA)
		binding.tiempo.text = PAUSA.toString() + ":00"
		binding.botonMenos.setOnClickListener(this)
		binding.botonMas.setOnClickListener(this)
		binding.botonComenzar.setOnClickListener(this)
		binding.botonCuentaCafesACero.setOnClickListener(this)

	 val cuentaCafe = findViewById<EditText>(R.id.tv_cuentaCafes)
		var cuentaCafeEscuchado:String?=null

	/*https://www.youtube.com/watch?v=yun9IB_GIvg*/

	cuentaCafe.addTextChangedListener(object :TextWatcher{
	override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int)
	{
		cuentaCafeEscuchado=s.toString()
		//Log.i("caca", cuentaCafeEscuchado.toString())
		//Log.i("caca", s.toString())
	}

	override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int)
	{
	//	Log.i("caca", cuentaCafeEscuchado.toString())
		//Log.i("caca", s.toString())
		Log.i("caca", s.toString())
		if (s != null)
		{
		/*	if (s.matches("[0,1,2,3,4,5,6,7,8,9,10]".toRegex()))
			{
				createDialog()
			}*/
			if(Integer.parseInt(s.toString())>10 || Integer.parseInt(s.toString())<=0)
			{
				createDialog()
			}
		}
	}
	override fun afterTextChanged(s: Editable?)
	{
	//	Log.i("caca", cuentaCafeEscuchado.toString())
		cuentaCafeEscuchado=s.toString()
		Log.i("caca", s.toString())
	}
}
)

	fun cafeNumeroOk(str: String?)
	{
		if(!esNumero(cuentaCafeEscuchado.toString()))
		{
			Log.i("entraEnIf", cuentaCafeEscuchado.toString())

			val popup = Builder(this)
			popup.setTitle("Titulo del mensaje")
			popup.setMessage("Cuerpo del mensaje")
			popup.setPositiveButton("Ok", null)
			popup.show()
		}

	}


/*		cuentaCafe?.addTextChangedListener(){
text-> Log.i("CACA",cuentaCafe.toString())
			if(!esNumero(cuentaCafe.toString()))
			{
				createDialog();
				ESTO es lo pasado en la tarea
				val popup = Builder(this)
				popup.setTitle("Titulo del mensaje")
				popup.setMessage("Cuerpo del mensaje")
				popup.setPositiveButton("Ok", null)
				popup.show()
			}
		}*/
	}
	fun esNumero(str: String?): Boolean
	{
		Log.i("CCCAAAACCAAA",str.toString())

		if (str != null)
		{
			return str.matches("[0-10]{1}".toRegex())
		}

		return TODO("Provide the return value")
	}

	fun createDialog()
	{

		/*val dialog = MainActivity().apply {
			set(
				title = getString(R.string.dialog_one_style_title),
				message = getString(R.string.dialog_one_style_message),
				negativeButtonText = getString(R.string.dialog_one_style_negative_btn),
				negativeButtonListener = {
					Toast.makeText(this@MainActivity, "Negative button", Toast.LENGTH_SHORT).show()
					dismiss()
				},
				positiveButtonText = getString(R.string.dialog_one_style_positive_btn),
				positiveButtonListener = {
					Toast.makeText(this@MainActivity, "Positive button", Toast.LENGTH_SHORT).show()
					dismiss()
				}
			)
		}
		dialog.show()*/

	/* ESTO es lo pasado en la tarea*/

		val popup = Builder(this)
		popup.setTitle("Kanio! mas de 10 cafés es mucho")
		popup.setMessage("Entre 1 y 10")
		popup.setPositiveButton("Ok", null)
		popup.show()

		/*****************************************/

	/*	var binding:Dialogoej1Binding
	binding = Dialogoej1Binding.inflate(layoutInflater)
		setContentView(binding.root)

		val alertDialogBuilder = Builder(this)
		val customView = LayoutInflater.from(this).inflate(R.layout.dialogoej1, null)
		alertDialogBuilder.setView(customView)
		var alertDialog = null
		var dialog = alertDialog
		dialog.show()*/

		/*alertDialogBuilder.setTitle("Exit App")
		alertDialogBuilder.setMessage("Are you sure you want to exit?")
		alertDialogBuilder.setPositiveButton("Yes") { _: DialogInterface, _: Int ->
			finish()

			alertDialogBuilder.setNegativeButton("Cancel", { dialogInterface: DialogInterface, i: Int -> })
			alertDialog = alertDialogBuilder.create()

			 fun onBackPressed()
			{
				alertDialog?.show()
			}
		}*/
	}

	override fun onClick(view: View) {

		if (view == binding.botonMenos) binding.tiempo.text = contador.disminuirTiempo()

		if (view == binding.botonMas) binding.tiempo.text = contador.aumentarTiempo()
/** poner los cafes a 0*/
		if(view==binding.botonCuentaCafesACero)
		{

			binding.tvCuentaCafes.setText("0")

			/*ProbandoPopup
			val popup = Builder(this)
			popup.setTitle("Titulo del mensaje")
			popup.setMessage("Cuerpo del mensaje")
			popup.setPositiveButton("Ok", null)
			popup.show()

			 */
		}
/**********************************/
		if (view == binding.botonComenzar)
			{

			//* ponemos sonido cuando empieze el tiempo*//*
				/*val mp: MediaPlayer = MediaPlayer.create(this@MainActivity1, R.raw.alarma)
				mp.start()*/
			//********************************/
			contadorDescendente = MyCountDownTimer((contador.obtenerTiempo() * 60 * 1000).toLong(), 1000)
			contadorDescendente.start()
			binding.botonMenos.isEnabled = false
			binding.botonMas.isEnabled = false
			binding.botonComenzar.isEnabled = false
		}
	}
	inner class MyCountDownTimer(millisInFuture: Long, countDownInterval: Long) : CountDownTimer(millisInFuture, countDownInterval) {
		override fun onTick(millisUntilFinished: Long) {
			val minutos: Long
			val segundos: Long

			minutos = millisUntilFinished / 1000 / 60
			segundos = millisUntilFinished /1000 % 60
			binding.tiempo.text = "$minutos:$segundos"
		}

		override fun onFinish()
		{
			Toast.makeText(this@MainActivity1, "Pausa terminada", Toast.LENGTH_LONG).show()

/*			*//* ponemos sonido cuando acabe el tiempo*/
			val mp: MediaPlayer = MediaPlayer.create(this@MainActivity1, com.example.hlc_tarea2.R.raw.alarma)
mp.start()

			/********************************/
			//binding.tvCuentaCafes.text = contador.aumentarCafes()
			binding.tiempo.text = contador.obtenerTiempo().toString() + ":00"
			binding.botonMenos.isEnabled = true
			binding.botonMas.isEnabled = true
			binding.botonComenzar.isEnabled = true
		}
	}
}


