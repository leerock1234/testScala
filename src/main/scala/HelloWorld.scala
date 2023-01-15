object HelloWorld {
  def main(args: Array[String]): Unit = {
    import scala.collection.immutable._

    val a = Option("1")
    val b = Option(2)
    val d = for {
      x <- a
      y <- b
    } yield x.toDouble + y.toDouble
    println(d)
    println("Hello World!")
  }

/*
  def map2[D[_], A, B, C](a: D[A], b: D[B])(f: (A, B) => C): D[C] = {
    for {
      x <- a
      y <- b
    } yield f(x, y)
  }
*/
}
