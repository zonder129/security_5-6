import java.math.BigInteger

fun main() {

    val module = BigInteger("9516311845790656153499716760847001433441357")
    val publicPowerToEncode = BigInteger("65537")
    val privatePowerToDecode = BigInteger("5617843187844953170308463622230283376298685")
    val c = Charsets.UTF_8
    val plainText = "This is very important information!"
    println("PlainText : $plainText")
    val plainBlocks = plainText.chunked(4)
    println("Text blocks: $plainBlocks")
    val plainNumbers = plainBlocks.map { BigInteger(it.toByteArray(c)) }
    println("As numbers : $plainNumbers")
    val enc = mutableListOf<BigInteger>()
    plainNumbers.forEach {
        enc.add(it.modPow(publicPowerToEncode, module))
    }
    println("Encoded   : $enc")
    val dec = mutableListOf<BigInteger>()
    enc.forEach {
        dec.add(it.modPow(privatePowerToDecode, module))
    }
    println("Decoded   : $dec")

    val decText = dec.joinToString("") { it.toByteArray().toString(c) }
    println("As text   : $decText")
}