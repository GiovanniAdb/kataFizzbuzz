
import java.math.BigDecimal

fun main() {
    //declaramos una variable con la cual se va a leer el numero a digitar
        val n = readLine()!!.toInt()
    //Comparar los limites del if, si los cumple manda a llamar el metodo fizzBuzz pero en caso contrario simplemente
    //muestra un mensaje diciendo que el limite se ha excedido
        if (n in 0..1000000) {
            //Manda a llamar al metodo fizzBuzz y si la cadena es igual a no entonces mandara un mensaje
            //en caso contrario regresa una cadena afirmando que es multiplo de 3, 5 o los dos

            if(fizzBuzz(n)!="no") {
                //Llama al metodo fizzBuzz
                println(fizzBuzz(n))
            }
            else{
                //Llama al metodo palabra que cambia de numero o numeros a palabra's
                println(palabrasMayores(n))
            }
        } else {
            //Manda un mensaje que indica sobrepaso del limite
            println("El numero que has digitado pasa del limite excedido")
        }
    }

//Metodo el cual recibe un entero y regresa cadena
fun fizzBuzz(n: Int) :String{

    //Si alguna de las cadenas se cumple entonces devuelve algo o incluso sino lo hace, tambien returna una cadena
    return when {
        n % 3 == 0 && n % 5 == 0 -> "FizzBuzz" //Sí es múltiplo de 3 y 5, deberá regresar la cadena "FizzBuzz!".
        n % 5 == 0 -> "Fizz" //Sí el número es múltiplo de 5, deberá regresar la cadena "Fizz!
        n % 3 == 0 -> "Buzz" //Sí es múltiplo de 3, deberá regresar la cadena "Buzz!"
        else -> "no" //Devuelve y no que sera comparado en una condicion
    }
}
//Meetodo para obtener la palabra millon, mil o miles y cero del numero digitado
fun palabrasMayores(n: Int) : StringBuilder {
    val result = java.lang.StringBuilder()
    val totalBigDecimal: BigDecimal = BigDecimal(n).setScale(2, BigDecimal.ROUND_DOWN)
    val parteEntera = totalBigDecimal.toBigInteger().toLong()

    val triUnidades = (parteEntera % 1000).toInt()
    val triMiles = (parteEntera / 1000 % 1000).toInt()
    val triMillones = (parteEntera / 1000000 % 1000).toInt()
    val triMilMillones = (parteEntera / 1000000000 % 1000).toInt()

    if (parteEntera == 0L) {
        result.append("Cero ")
        return result
    }

    if (triMilMillones > 0) result.append(palabras(triMilMillones).toString() + "Mil ")
    if (triMillones > 0) result.append(palabras(triMillones).toString())

    if (triMilMillones == 0 && triMillones == 1) result.append("Millón ")

    if (triMiles > 0) result.append(palabras(triMiles).toString() + "Mil ")
    if (triUnidades > 0) result.append(palabras(triUnidades).toString())

    return result
}

//Metodo el cual es llaamdo por el anterior metodo palabrasMayores, este traduce a cien, ciento, doscientos y asi.
//Ademas tiene otro switch por asi decirlo de decenas, unidades y este se guarda en un result para despues mostrarlo
//en pantalla

fun palabras(n: Int) : StringBuilder {
    val centenas = n / 100
    val decenas = n % 100 / 10
    val unidades = n % 10
    val result = StringBuilder()

    when (centenas) {
        0 -> {}
        1 -> if (decenas == 0 && unidades == 0) {
            result.append("Cien ")
            return result }
        else result.append("Ciento ")
        2 -> result.append("Doscientos ")
        3 -> result.append("Trescientos ")
        4 -> result.append("Cuatrocientos ")
        5 -> result.append("Quinientos ")
        6 -> result.append("Seiscientos ")
        7 -> result.append("Setecientos ")
        8 -> result.append("Ochocientos ")
        9 -> result.append("Novecientos ")
    }

    when (decenas) {
        0 -> {}
        1 -> if (unidades == 0) {
            result.append("Diez ")
            return result
        } else if (unidades == 1) {
            result.append("Once ")
            return result
        } else if (unidades == 2) {
            result.append("Doce ")
            return result
        } else if (unidades == 3) {
            result.append("Trece ")
            return result
        } else if (unidades == 4) {
            result.append("Catorce ")
            return result
        } else if (unidades == 5) {
            result.append("Quince ")
            return result
        } else result.append("Dieci")

        2 -> if (unidades == 0) {
            result.append("Veinte ")
            return result
        } else result.append("Veinti")

        3 -> result.append("Treinta ")
        4 -> result.append("Cuarenta ")
        5 -> result.append("Cincuenta ")
        6 -> result.append("Sesenta ")
        7 -> result.append("Setenta ")
        8 -> result.append("Ochenta ")
        9 -> result.append("Noventa ")
    }

    if (decenas > 2 && unidades > 0) result.append("y ")

    when (unidades) {
        0 -> {}
        1 -> result.append("Un ")
        2 -> result.append("Dos ")
        3 -> result.append("Tres ")
        4 -> result.append("Cuatro ")
        5 -> result.append("Cinco ")
        6 -> result.append("Seis ")
        7 -> result.append("Siete ")
        8 -> result.append("Ocho ")
        9 -> result.append("Nueve ")
    }
    return result
    }