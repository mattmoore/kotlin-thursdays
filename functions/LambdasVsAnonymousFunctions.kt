fun main() {
  // Named function
  println(hello("Matt"))

  // Anonymous function
  println(fun(): String { return "Hello, World" }())

  // Anonymous function with parameter
  println(fun(name: String): String { return "Hello, $name" }("Matt"))

  // Lambda syntax
  println({ name: String -> "Hello, $name" }("Matt"))

  // Lambda syntax with parameter
  println({ "Hello, Matt" }())
}

fun hello(name: String): String {
  return "Hello, $name"
}
