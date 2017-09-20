object books {
  case class Book(title: String, authors: List[String])

  val books = Set(
    Book(
      title = "Struncture and I",
      authors = List("Abelson, Harald", "Sussmann")
    ),
    Book(
      title = "Introduction to Functional",
      authors = List("Bird, Richard", "Wadler, P")
    ),
    Book(
      title = "Effective Java",
      authors = List("Bloch, Jashua")
    ),
    Book(
      title = "Effective Java 2",
      authors = List("Bloch, Jashua")
    ),
    Book(
      title = "Java Puzzlers",
      authors = List("Bloch, Jashua", "Gafter, Neal")
    ),
    Book(
      title = "Programming in Scala",
      authors = List("Odersky, Martin", "Spoon, Lex", "Venners, Bill")
    )
  )

  for (b <- books; a <- b.authors if a startsWith "Bloch,")
    yield b.title

  for {
    b1 <- books
    b2 <- books
    if b1.title < b2.title
    a1 <- b1.authors
    a2 <- b2.authors
    if a1 == a2
  } yield a1



}