import org.scalatest.{FunSpec, Matchers}
import org.scalamock.scalatest.MockFactory

/**
 * Scalatest has support for several mocking frameworks
 * Imagine a service to lookup external weather details from a web API. */

case class Weather(temp: Double, precip: Double, pressure: Double)

trait WeatherService {
  def getWeather(icaoCode: String): Weather
  def operational(): Boolean
}

object testScalaMock extends App{
  def lookupWeather(WeatherService: WeatherService, icaoCode: String): Option[Weather] = {
    if (!WeatherService.operational()) None else Some(WeatherService.getWeather(icaoCode))
  }
}


class TestingMockDemo extends FunSpec with Matchers with MockFactory{

  describe("Retrieving weather from the weather service"){
    it("should call getWeather if operational() is true"){
      val mockWS = mock[WeatherService]

      /**
       * as long as you know that any call that you make into scala mock object that is
          expecting unit, you just have to do this after : inputType => output type*/
      // expect() means we are expecting no parameters. but when you get this, return true.
      (mockWS.operational _: () => Boolean).expects().returning(true)

      /**
       * Expect a call to getWeather
       * We expect it is gonna have parameter "PDX" and
       * when you get that return below Weather record
       */
      (mockWS.getWeather _).expects("PDX").returning(Weather(55.0, 0.0, 1012.0))
      // We checked whether a service is operational and them calling out with this code and getting back a real value.
      // But we are not calling but doing tests
      val weather = testScalaMock.lookupWeather(mockWS, "PDX") // Instead of this, we can use but
//      val weather = Some(Weather(0.0, 1012.0, 55.0))  test fails
      /** Operational and getWeather was never called
       * This means we not only test the results we get back from our call but we tested that
       * the other side of it is calling what we expected to call and the number of times we expected a call
       * Verifying the calls are made.*/
      val tolerance = 1e-6

      weather should be (defined)
      weather.get.precip should be (0.0 +- tolerance)
      weather.get.pressure should be (1012.0 +- tolerance)
      weather.get.temp should be (55.0 +- tolerance)

    }
  }
}
 // --------------- Advantages of Scala Mock
/**
 * Mocks allow full scripting of responses (including failures).
 * They also verify calls are made, in the correct quantity
 * (e.g. fail if too many or few)

 */
class AdvantagesMockDemo extends FunSpec with Matchers with MockFactory {
  describe("Throwing exception instead of accepting parameters"){
    it("should not call getWeather if operational throws an exception"){
      val mockWs = mock[WeatherService]

      (mockWs.operational _: () => Boolean).expects().
        throws(new IllegalStateException("network failure"))

      val ex = intercept[IllegalStateException]{
        testScalaMock.lookupWeather(mockWs, "PDX")
      }
      ex.getMessage should be ("network failure")
    }
  }
}