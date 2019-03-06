import java.util.*

fun main() {
    val scan = Scanner(System.`in`)
    println("Hello! For communication by Diffie Hellman algorithm you need to define public simple module and the generator.")
    println("Enter the simple module please (like 17):")
    val module = scan.nextInt()
    println("Now enter the generator:")
    val generator = scan.nextInt()
    println("Choose secret power for Alice:")
    val alicePower = scan.nextInt()
    println("And secret power for Bob:")
    val bobPower = scan.nextInt()

    // calculate numbers for Bob and Alice
    val aliceNumber = Math.pow(generator.toDouble(), alicePower.toDouble()).rem(module).toInt()
    val bobNumber = Math.pow(generator.toDouble(), bobPower.toDouble()).rem(module).toInt()

    // Alice sends her number to Bob and he calculates the key
    val bobSecret = Math.pow(aliceNumber.toDouble(), bobPower.toDouble()).rem(module).toInt()

    // Bob sends his number to ALice and she calculates the key
    val aliceSecret = Math.pow(bobNumber.toDouble(), alicePower.toDouble()).rem(module).toInt()

    if (bobSecret == aliceSecret) {
        println("Bob and Alice now can communicate with each other by sharing the common key: $bobSecret")
        println("For log: aliceNumber = $aliceNumber \b bobNumber=$bobNumber")
    } else {
        println("Bob secret and Alice secret not equal: Bob=$bobSecret , Alice=$aliceSecret\nMaybe you enter bad numbers?")
    }

}