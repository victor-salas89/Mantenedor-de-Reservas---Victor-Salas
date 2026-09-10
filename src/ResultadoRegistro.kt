
sealed class ResultadoRegistro {

    data class Exito(val reserva: ReservaAlojamiento) : ResultadoRegistro()


    data class Error(val mensaje: String) : ResultadoRegistro()
}