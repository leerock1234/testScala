object MyFor {
  def main(args: Array[String]): Unit = {
    val l = List(1,2,3)
    val b = for {
      x <- l
    } yield x
    println(b)
  }

}
