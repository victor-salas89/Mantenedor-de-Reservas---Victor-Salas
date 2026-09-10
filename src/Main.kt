import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking


suspend fun consultarDisponibilidad() {
    println("Consultando disponibilidad de alojamientos...")
    delay(1000)
    println("¡Disponibilidad confirmada!")
}

fun main() = runBlocking {

    consultarDisponibilidad()

    println("--- SISTEMA DE RESERVAS DE ALOJAMIENTO ---")
}