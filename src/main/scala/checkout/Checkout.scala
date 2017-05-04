package checkout

class Checkout(itemRepository: ItemRepository) {

  //chosen to price non existent items at 0.
  //more sophisticated error handling could involve returning an Either
  def priceItems(items: List[String]): Double = {
    (for {
      item <- items
      price <- itemRepository.priceForItem(item)
    } yield price).sum
  }
}
