import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking


suspend fun consultarDisponibilidad() {
    println(">>> Consultando disponibilidad de alojamientos...")
    delay(1000)
    println(">>> ¡Disponibilidad confirmada!\n")
}

fun main() = runBlocking {

    consultarDisponibilidad()

    val mantenedor = MantenedorReservas()

    println("==================================================")
    println("        1. REGISTRO DE RESERVAS       ")
    println("==================================================")


    val intentosReserva = listOf(
        ReservaAlojamiento(1, "Ana Pérez", 3, 45000.0, 2, TipoAlojamiento.HABITACION),
        ReservaAlojamiento(2, "Carlos Gómez", 5, 80000.0, 4, TipoAlojamiento.CABANA),
        ReservaAlojamiento(3, "María Torres", 2, 120000.0, 6, TipoAlojamiento.DEPARTAMENTO),

        ReservaAlojamiento(1, "Pedro Soto", 1, 30000.0, 1, TipoAlojamiento.HABITACION),

        ReservaAlojamiento(4, "Lucía Rojas", -1, 50000.0, 2, TipoAlojamiento.CABANA)
    )


    for (reserva in intentosReserva) {
        val resultado = mantenedor.registrarReserva(reserva)
        when (resultado) {
            is ResultadoRegistro.Exito -> {
                println("[ÉXITO] Se registró la reserva #${resultado.reserva.id} para ${resultado.reserva.nombreCliente}")
            }
            is ResultadoRegistro.Error -> {
                println("[ERROR DE VALIDACIÓN] No se pudo registrar a '${reserva.nombreCliente}': ${resultado.mensaje}")
            }
        }
    }


    println("\n--- Prueba de Manejo de Excepciones (Try-Catch) ---")
    try {
        println("Intentando procesar un dato crítico...")
        val precioPrueba = "45000X".toDouble()
        println("Precio procesado: $precioPrueba")
    } catch (e: NumberFormatException) {
        println("[CONTROL DE EXCEPCIÓN] Error al convertir dato numérico: ${e.message}. El programa continúa la ejecución.")
    }

    println("\n==================================================")
    println("      2. LISTADO DE RESERVAS             ")
    println("==================================================")

    val listaReservas = mantenedor.obtenerReservas()


    listaReservas.forEach { reserva ->
        println(reserva.obtenerDescripcion())
    }

    println("\n==================================================")
    println("   3. DEMOSTRACIÓN DE POLIMORFISMO ")
    println("==================================================")


    val reservaComoGeneral: Reserva = ReservaAlojamiento(
        99, "Juan Valdés", 4, 60000.0, 3, TipoAlojamiento.CABANA
    )

    println("Invocando desde tipo 'Reserva':")
    println(reservaComoGeneral.obtenerDescripcion())

    println("\n==================================================")
    println("  4. CÁLCULOS Y CONSULTAS FUNCIONALES  ")
    println("==================================================")


    val totalGeneral = listaReservas.sumOf { it.calcularTotal() }
    println("Monto total recaudado por todas las reservas: $$totalGeneral")

   
    val reservasAltas = listaReservas.filter { it.calcularTotal() > 150000.0 }
    println("\nReservas con total superior a $150.000:")
    reservasAltas.forEach { r ->
        println(" - Cliente: ${r.nombreCliente} | Total: $$${r.calcularTotal()}")
    }


    val nombresClientes = listaReservas.map { it.nombreCliente }
    println("\nLista de clientes con reserva confirmada: $nombresClientes")
    println("==================================================")
}