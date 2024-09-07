package cl.bootcamp.precioentradaparque
fun calcularPrecioEntrada(edad: Int, diaSemana: String): String {
    // Verificar si la edad está dentro del rango permitido
    if (edad < 0 || edad > 100) {
        return "Error: Edad no válida. Debe estar entre 0 y 100 años."
    }

    // Calcular el precio según la edad
    return when {
        edad < 4 -> "Entrada gratuita para niños menores de 4 años."
        edad in 4..15 -> "El precio de la entrada es de ${formatearPrecio(15000)} CLP para niños."
        edad in 16..60 -> {
            val descuento = if (diaSemana.equals("lunes", ignoreCase = true) || diaSemana.equals("martes", ignoreCase = true)) 5000 else 0
            val precio = 30000 - descuento
            "El precio de la entrada es de ${formatearPrecio(precio)} CLP para adultos."
        }
        edad > 60 -> "El precio de la entrada es de ${formatearPrecio(20000)} CLP para adultos mayores."
        else -> "Error: Condición no válida."
    }
}

// Función para formatear el precio con separador de miles y signo $
fun formatearPrecio(precio: Int): String {
    return String.format("$%,d", precio)
}

fun main() {
    println(calcularPrecioEntrada(10, "domingo"))  // Niño de 10 años
    println(calcularPrecioEntrada(65, "jueves"))   // Adulto mayor de 65 años
    println(calcularPrecioEntrada(30, "lunes"))    // Adulto de 30 años en lunes con descuento
    println(calcularPrecioEntrada(2, "miércoles")) // Niño de 2 años (entrada gratuita)
    println(calcularPrecioEntrada(101, "sábado"))  // Edad fuera del rango
    println(calcularPrecioEntrada(50,"miércoles")) // Adulto 50 años día sin descuento
}
