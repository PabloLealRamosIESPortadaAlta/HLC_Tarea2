package com.example.hlc_tarea2.Ejerciciio1


class Contador {
	private val DESCANSO = 5
	private var cafes: String//número de cafés
	private var tiempo: Int // tiempo de la pausa en minutos
	constructor() {
		cafes = aumentarCafes()
		tiempo = DESCANSO
	}
	constructor(c: Int, t: Int) {
		cafes = c.toString()
		tiempo = t
	}
	fun aumentarTiempo(): String {
		tiempo += 1
		return tiempo.toString() + ":00"
	}
	fun disminuirTiempo(): String {
		tiempo -= 1
		if (tiempo < 1) tiempo = 1
		return tiempo.toString() + ":00"
	}
	fun obtenerTiempo(): Int {
		return tiempo
	}
	fun aumentarCafes(): String {
		cafes += 1
		return cafes.toString()
	}

	fun ponerACeroCafe(): String
	{
		cafes = 0.toString()
		return cafes.toString()

	}
}