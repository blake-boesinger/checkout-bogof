package checkout

class Checkout(itemRepository: ItemRepository) {

  //chosen to price non existent items at 0.
  //more sophisticated error handling could involve returning an Either
  def priceItems(items: List[String]): Double = {
    val itemCount: Map[String, Int] = items.groupBy(identity).mapValues(_.size)

    itemCount.flatMap{
      case ("Apple", quantity) => {
        itemRepository.priceForItem("Apple").map(price => (price * (quantity / 2)) + (price * (quantity % 2)))
      }
      case (item, quantity) => itemRepository.priceForItem(item).map(_ * quantity)
    }.sum
  }
}
