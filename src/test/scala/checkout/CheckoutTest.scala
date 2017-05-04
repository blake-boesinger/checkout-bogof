package checkout

import org.scalatest._

class CheckoutTest extends FunSuite {

  test("empty basket priced at 0") {
    assert (new Checkout(new ItemRepository).priceItems(List()) == 0)
  }

  test("price one item") {
    assert (new Checkout(new ItemRepository).priceItems(List("Apple")) == 0.60)
  }

  test("price multiple items of the same type") {
    assert (new Checkout(new ItemRepository).priceItems(List("Apple", "Apple")) == 1.2)
  }

  test("price multiple items of different types") {
    assert (new Checkout(new ItemRepository).priceItems(List("Apple", "Orange")) == 0.85)
  }

  test("non existent items priced at zero") {
    assert (new Checkout(new ItemRepository).priceItems(List("does not exist")) == 0.0)
  }

}
