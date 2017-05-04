package checkout

class Checkout(itemRepository: ItemRepository) {

  //assuming error handling of non-existent items is not necessary
  def priceItems(items: List[String]): Double = {
    val itemCount: Map[String, Int] = items.groupBy(identity).mapValues(_.size)

    //assuming shop only sells apples and oranges and there is always an x for the price of y offer
    itemCount.map{
      case (item, quantity) => xForThePriceOfY(item, quantity)
    }.sum
  }

  private def xForThePriceOfY(item: String, quantity: Int): Double = {
    val price = itemRepository.priceForItem(item)

      price.normalPrice * price.offer.y * (quantity / price.offer.x) +
        (price.normalPrice * (quantity % price.offer.x))
  }
}
