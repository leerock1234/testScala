object ext1 {
  trait FM[A,T[_]] {
    def flatMap[B](f: A => T[B]): T[B];
    def map[B](f: A => B): T[B]
  }
  import scala.language.implicitConversions
  implicit class FMOption[A](val o: Option[A]) extends FM[A, Option] {
    def flatMap[B](f: A => Option[B]): Option[B] = o.flatMap(f)
    def map[B](f: A => B): Option[B] = o.map(f)
  }
  def map2[A, B, C, T[_]](a: FM[A, T], b: FM[B, T], f: (A, B) => C): T[C] = {
    for {
      x <- a
      y <- b
    } yield f(x, y)
  }
  def main(args: Array[String]): Unit = {
    val o = Some(4)
    val o2 = Some(7)
    println(map2(o, o2, _ + _))
    val o3:Option[Int] = None
    println(map2(o, o3, _ + _))
  }

}
