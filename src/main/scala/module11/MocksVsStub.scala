import org.scalamock.scalatest.MockFactory
import org.scalatest.{FunSpec, Matchers}


case class MyWeather(temp: Double, precip: Double, pressure: Double)

trait MyWeatherService {
  def getWeather(icaoCode: String): MyWeather
  def operational(): Boolean
}

object TestMockStub {
  def lookupWeather(service: MyWeatherService, icaoCode: String): Option[MyWeather] = {
    if (!service.operational()) None
    else Some(service.getWeather(icaoCode))
  }
}

class MockVsStub extends FunSpec with Matchers with MockFactory{
    it("should call the lookup weather with different codes when necessary") {
      val stubWS = stub[MyWeatherService]
      (stubWS.operational _: () => Boolean).when().returning(true)
      (stubWS.getWeather _).when("PDX").returning(MyWeather(55.0, 0.0, 1012.0))
      (stubWS.getWeather _).when("SFO").returning(MyWeather(65.0, 0.3, 1008.0))
      val results1 = TestMockStub.lookupWeather(stubWS, "SFO") // check results1 here
      val results2 = TestMockStub.lookupWeather(stubWS, "PDX") // check results2 here
      (stubWS.operational _: () => Boolean).verify().twice()
      (stubWS.getWeather _).verify("PDX")
      (stubWS.getWeather _).verify("SFO")
    }
}