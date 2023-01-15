object PlayType {
  def main(args: Array[String]): Unit = {

  }

}

trait MP {
  type T
  def bigger(t2: T): Boolean
  def get() : T
}

class MPInt(i: Int) extends MP {
  type T = Int

  override def bigger(t2: Int): Boolean = {
    i > t2
  }

  override def get(): Int = {
    i
  }
}
class MPString(s: String) extends MP {
  type T = String

  override def bigger(t2: String): Boolean = {
    s.length > t2.length
  }

  override def get(): String = {
    s
  }
}
