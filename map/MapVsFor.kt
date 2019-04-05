data class Author(val firstName: String, val lastName: String)

data class Book(val title: String, val author: Author)

val books = listOf(
  Book("Microservices Architecture", Author("Chris", "Richardson")),
  Book("Kotlin in Action", Author("Dmitry", "Jemerov"))
)

fun getAuthorsWithForLoop(books: List<Book>): List<Author> {
  var authors = mutableListOf<Author>()
  for (x in books) {
    authors.add(x.author)
  }
  return authors
}

fun getAuthorsWithMap(books: List<Book>): List<Author> {
  return books.map { it.author }
}

fun main() {
  // Want to find books written by Chris Richardson.

  // for loop
  println(getAuthorsWithForLoop(books))

  // map
  println(getAuthorsWithMap(books))

  // Now, I want to get author for a specific book.
  // "Folding functions (map/filter/etc)" allow me to do this:
  println(
      books.filter { it.title == "Kotlin in Action" }
           .map { it.author }
  )
}
