package com.example.hlc_tarea2.Ejercicio3

import android.icu.text.CaseMap.Title
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.example.hlc_tarea2.Ejercicio3.ui.theme.HLC_Tarea2Theme

/***
 * Crear una aplicación en kotlin que permita introducir 2 números y muestre los números primos
 * comprendidos entre ellos.
 *     Se utilizará Jetpack Compose.
 * Se tendrán en cuenta los errores que se pueden presentar al ejecutar la aplicación, por ejemplo:
 * algún dato introducido no es un número.
 * Si se produce algún error, se mostrará un mensaje informativo. En ningún caso se abortará la
 * ejecución de la aplicación.
 *
 */

@OptIn(ExperimentalMaterial3Api::class) class MainActivity3 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HLC_Tarea2Theme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    //Greeting("Android")
                }

                Column {
                    AppBarLayout()
                    entradaDatos()
                }
            }
        }
    }
}

/*@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}*/

@Preview(showBackground = true)
@Composable
fun GreetingPreview()
    {
        HLC_Tarea2Theme {
        //Greeting("Android")
    }
}
@ExperimentalMaterial3Api
@Composable
fun AppBarLayout()
{
    TopAppBar(title =
        { Text(text = "HLC_Tarea2_Ejercicio3") },
            Modifier.background(androidx.compose.ui.graphics.Color.Red)
        )
}

@ExperimentalMaterial3Api
@Composable
fun entradaDatos()
{

    var txPrimerNumero by remember { mutableStateOf("") }
    var txSegundoNumero by remember { mutableStateOf("") }
    var muestraPrimos by remember { mutableStateOf("") }
    var contexto = LocalContext.current


    Column {
        Modifier.fillMaxWidth()
        Alignment.CenterHorizontally
        OutlinedTextField(
            //TextoVisible
            value = txPrimerNumero,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
            label = { Text("primer numero") },

            onValueChange = { txPrimerNumero = it }
        )
    }

    OutlinedTextField(
        value = txSegundoNumero,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
        label = { Text("segundo numero numero") },

        onValueChange = { txSegundoNumero=it })

    Button(

        colors = ButtonDefaults.buttonColors(Color.Gray),

        onClick =
        {
            if (estaVacio(txPrimerNumero, txSegundoNumero))
                Toast.makeText(contexto, "no deje vacio los datos", Toast.LENGTH_LONG).show()
            //calcular los primos

            /* var primerNumeroEntero = parseaElStringdelPrimerNumero(txPrimerNumero)
													var segundoNumeroEntero= parseaElStringdelSegundoNumero(txSegundoNumero)

													if(primerNumeroEntero>segundoNumeroEntero)
																	Toast.makeText(contexto, "el primer numero debe ser menosr al segundo", Toast.LENGTH_LONG).show()*/
            muestraPrimos = primosEnRango(txPrimerNumero,txSegundoNumero).toString()
        })

    {
        Text(text = "Calcula Los primos")
    }

    Text(text = muestraPrimos)

    /*Text(text = "los numero primos en rango son:" + primosEnRango(txPrimerNumero, txSegundoNumero))*/
    /*  Text (text=
										"Los numero primos son  ${
														primosEnRango(
																		txPrimerNumero,
																		txSegundoNumero
														)
										}"
						)*/

}

fun estaVacio(primernumero: String, segundoNumero: String):Boolean{
    var estadoCaptura = false
    estadoCaptura = primernumero.isNullOrEmpty() || segundoNumero.isNullOrEmpty()
    return estadoCaptura

}

fun primosEnRango (numeroUno: String, numeroDos: String) : String
{
    var numeroUnoParseado: Int= numeroUno.toInt()
    var numeroDosParseado:Int=numeroDos.toInt()
    var aux: Int= 0
    var cantidadPrimos:String="siempre Sale esta variable"
    var cantidadPrimos1:Int=0



    //var cantidadPrimos:Int?=0


    //var cantidadPrimos1 = cantidadPrimos+1
    if(numeroUnoParseado>0&&numeroDosParseado>0)
    {

        if(numeroUnoParseado<numeroDosParseado)
        {
            var aux= numeroUnoParseado
            numeroUnoParseado=numeroDosParseado
            numeroDosParseado=aux

        }
        val i =numeroUnoParseado
        for ( i in i..numeroDosParseado )
        {
            if(esPrimo(i))
            {
                cantidadPrimos1++

                println(cantidadPrimos)


            }
        }

    }
    return (cantidadPrimos).toString()
}




fun esPrimo (numero:Int):Boolean
{
    var primo: Boolean = true
    var numeroParseado: Int = numero.toInt()
    if ((numeroParseado == 1) || (numeroParseado % 2) == 0 && numeroParseado > 2)
    {
        primo = false

    } else
    {

        val i = 2
        for (i in (i..(numeroParseado / 2)))
        {
            if (numeroParseado % i == 0)
            {
                primo = false
                break;
            }

        }
    }
    return primo
}