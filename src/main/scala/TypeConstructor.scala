object TypeConstructor {
  type Flyer = { def fly(): Unit }
  def main(args: Array[String]): Unit = {
    import scala.language.reflectiveCalls
    val a: Flyer = Duck("a")
    val b: Flyer = Eagle("b")
    a.fly()
    b.fly()
  }

  trait Test[A, M[_]] {
    def map[B](f: A=>B): M[B]
  }

  class Duck[A](a: A) {
    def fly(): Unit = {
      println("Duck")
    }
  }

  class Eagle[A](a: A) {
    def fly(): Unit = {
      println("Eagle")
    }
  }
}
