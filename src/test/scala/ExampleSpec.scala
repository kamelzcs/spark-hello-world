import org.scalatest._

class ExampleSpec extends FlatSpec with Matchers {

  "A Stack" should "pop values in last-in-first-out order" in {
    val array = Array(1, 2)
    val seq = Seq(1, 2)
    assert(array === seq)
  }
}
