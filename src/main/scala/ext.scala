object ext {
  trait FM[A] {
    type T
    def flatMap[B](f: A => FM[B]): FM[B]
    def map[B](f: A => B): FM[B]
    def inner(): T
  }
  import scala.language.implicitConversions
  implicit class FMOption[A](val o: Option[A]) extends FM[A] {
    type T = Option[A]
    def flatMap[B](f: A => FM[B]): FM[B] = {
      val innerO: Option[B] = o.flatMap((x: A) => {
        f.apply(x).inner().asInstanceOf[Option[B]]
      })
      FMOption(innerO)
    }
    def inner() : Option[A] = o
    def map[B](f: A => B): FM[B] = o.map(f)
  }
  def useFM[A, B](fm : FM[A], f: A => FM[B]): FM[B] = {
    fm.flatMap(f)
  }
  def useFMM[A, B](fm : FM[A], f: A => B): FM[B] = {
    fm.map(f)
  }
  def main(args: Array[String]): Unit = {
    val o:FM[Int] = Some(4)
    val mfm = useFM(o, (x:Int) => Some(x+1)).inner().asInstanceOf[Option[Int]]
    println(mfm.get)
    val mfmm = useFMM(o, (x:Int)=>x+3).inner().asInstanceOf[Option[Int]]
    println(mfmm.get)
  }

}
