
open class Reserva(
    val id: Int,
    val nombreCliente: String,
    val cantidadNoches: Int
) {

    open fun obtenerDescripcion(): String {
        return "Reserva #$id - Cliente: $nombreCliente ($cantidadNoches noches)"
    }
}