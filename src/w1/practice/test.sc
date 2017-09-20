object test {
  val f: String => String = {case "ping" => "pong"}

  f("ping")
  //f("abc") //MatchError -> to avoid this, we can use Partialfunctions..

  val fPar: PartialFunction[String, String] = {case "ping" => "pong"}

  fPar.isDefinedAt("ping")
  fPar.isDefinedAt("abc")

  val g: PartialFunction[List[Int], String] = {
    case Nil => "one"
    case x :: rest => {
      rest match {
        case Nil => "two"
      }
    }
  }

  g.isDefinedAt(List(1,2,3)) // This will be true, but will throw a Matcherror error if we use apply -> only first layer is checked
  //g(List(1,2,3)) //Matcherror

}