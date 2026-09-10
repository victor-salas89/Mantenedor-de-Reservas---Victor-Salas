

class MantenedorReservas {

    private val reservas = mutableListOf<ReservaAlojamiento>()


    fun registrarReserva(reserva: ReservaAlojamiento): ResultadoRegistro {

        if (reserva.id <= 0) {
            return ResultadoRegistro.Error("El identificador debe ser mayor que cero.")
        }
        if (reserva.nombreCliente.isBlank()) {
            return ResultadoRegistro.Error("El nombre del cliente no puede estar vacío.")
        }
        if (reserva.cantidadNoches <= 0) {
            return ResultadoRegistro.Error("La cantidad de noches debe ser mayor que cero.")
        }
        if (reserva.valorNoche <= 0) {
            return ResultadoRegistro.Error("El valor por noche debe ser mayor que cero.")
        }
        if (reserva.cantidadPersonas <= 0) {
            return ResultadoRegistro.Error("La cantidad de personas debe ser mayor que cero.")
        }
        if (reservas.any { it.id == reserva.id }) {
            return ResultadoRegistro.Error("Ya existe una reserva registrada con el ID #${reserva.id}.")
        }


        reservas.add(reserva)
        return ResultadoRegistro.Exito(reserva)
    }


    fun obtenerReservas(): List<ReservaAlojamiento> {
        return reservas.toList()
    }
}