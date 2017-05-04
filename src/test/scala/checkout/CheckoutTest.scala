package checkout

import org.scalatest._

class CheckoutTest extends FunSuite {

  test("empty basket priced at 0") {
    assert (new Checkout(new ItemRepository).priceItems(List()) == 0)
  }

  test("price multiple items of different types") {
    assert (new Checkout(new ItemRepository).priceItems(List("Apple", "Orange")) == 0.85)
  }

  test("non existent items priced at zero") {
    assert (new Checkout(new ItemRepository).priceItems(List("does not exist")) == 0.0)
  }

  test("price one Apple") {
    assert (new Checkout(new ItemRepository).priceItems(List("Apple")) == 0.60)
  }

  test("price apples at 2 for the price of 1") {
    assert (new Checkout(new ItemRepository).priceItems(List("Apple", "Apple")) == 0.6)
  }

  test("price apples at 2 for the price of 1 plus an extra Apple at normal price") {
    assert (new Checkout(new ItemRepository).priceItems(List("Apple", "Apple", "Apple")) == 1.2)
  }

  test("price apples at 4 for the price of 2") {
    assert (new Checkout(new ItemRepository).priceItems(List("Apple", "Apple", "Apple", "Apple")) == 1.2)
  }
}
