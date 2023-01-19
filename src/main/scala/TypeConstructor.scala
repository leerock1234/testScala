object TypeConstructor {
  type Flyer = { def fly(): Unit }
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
  def main(args: Array[String]): Unit = {
    import scala.language.reflectiveCalls
    val a: Flyer = new Duck("a")
    val b: Flyer = new Eagle("b")
    a.fly()
    b.fly()
  }

  trait Test[A, M[_]] {
    def map[B](f: A=>B): M[B]
  }

}
