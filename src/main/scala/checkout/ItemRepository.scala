package checkout

case class Price(normalPrice: Double, offer: XForThePriceOfYOffer)  //assuming an offer is now mandatory
case class XForThePriceOfYOffer(x: Int, y: Int)

class ItemRepository {

  //hardcoding these here for the purposes of this exercise.
  //this would normally be an abstraction around a database/web service.
  //modelling prices as Double for this exercise. Could refactor to use BigDecimal

  val prices: Map[String, Price] = Map(
    "Orange" -> Price(0.25, XForThePriceOfYOffer(3, 2)),
    "Apple" -> Price(0.60, XForThePriceOfYOffer(2, 1))
  )

  //this can throw an exception. generally prefer to avoid throwing exceptions in functional programming, but have kept things
  //simple for the purposes of this exercise
  def priceForItem(item: String): Price = {
    prices(item)
  }
}
