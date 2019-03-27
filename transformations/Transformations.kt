val greet = { name: String -> "Hello, $name" }

val punctuate = { text: String -> "$text." }

val applyTransformations = { value: String, transformations: List<(String) -> String> ->
  transformations.fold(value) { agg: String, f -> f(agg) }
}

inline infix fun <IP, R, P1> ((IP) -> R).compose(crossinline f: (P1) -> IP): (P1) -> R = { p1: P1 -> this(f(p1)) }
fun adder(x: Int): Int { return x + 1 }

fun main(args: Array<String>) {
  val transformations = listOf(greet, punctuate)
  val result = applyTransformations("Matt", transformations)
  println(result)
  println((::adder compose ::adder compose ::adder)(1))
}
