package checkout

class ItemRepository {

  //hardcoding these here for the purposes of this exercise.
  //this would normally be an abstraction around a database/web service.
  //modelling prices as Double for this exercise. Could refactor to use BigDecimal

  val prices: Map[String, Double] = Map("Orange" -> 0.25, "Apple" -> 0.60)

  def priceForItem(item: String): Option[Double] = {
    prices.get(item)
  }
}
