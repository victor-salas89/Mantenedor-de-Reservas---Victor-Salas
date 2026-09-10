

class ReservaAlojamiento(
    id: Int,
    nombreCliente: String,
    cantidadNoches: Int,
    val valorNoche: Double,
    val cantidadPersonas: Int,
    val tipoAlojamiento: TipoAlojamiento
) : Reserva(id, nombreCliente, cantidadNoches) {


    fun calcularTotal(): Double {
        return valorNoche * cantidadNoches
    }


    override fun obtenerDescripcion(): String {
        return "Reserva #$id | Cliente: $nombreCliente | Tipo: ${tipoAlojamiento.name} (${tipoAlojamiento.descripcion}) | Noches: $cantidadNoches | Personas: $cantidadPersonas | Valor/Noche: $$valorNoche | Total: $$${calcularTotal()}"
    }
}