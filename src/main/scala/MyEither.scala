object MyEither {
  def main(args: Array[String]): Unit = {
    val e : Either[String, Int] = Left("fail")
    val g : Either[String, Int] = Right(1)
    println(e)
    println(g)
  }
}
