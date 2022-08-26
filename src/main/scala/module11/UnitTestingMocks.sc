import org.scalatest.{FunSpec, Matchers}
import org.scalamock.scalatest.MockFactory


case class Weather(temp: Double, precip: Double, pressure: Double)
trait WeatherService {
  def getWeather(icaoCode: String): Weather
  def operational(): Boolean
}
object TestMock {
  def lookupWeather(service: WeatherService, icaoCode: String): Option[Weather] = {
    if (!service.operational()) None
    else Some(service.getWeather(icaoCode))
  }
}

class TestingSpecDemo extends FunSpec with Matchers with MockFactory{
  describe("Retrieving weather from weather service"){
    it("should call getWeather if operational() is true"){
      val mockWS = mock[WeatherService]
      // When no arguments is expected use () => returnType
      (mockWS.operational _:() => Boolean).expects().returning(true)
      // when argument is expected
      (mockWS.getWeather _).expects("PDX").returning(Weather(1.1, 2.2, 3.3))

      val weather = TestMock.lookupWeather(mockWS, "PDX")
      val tolerance = 1e-6

      weather should be (defined) // check to see if PDX is there
      weather.get.precip should be(0.0 +- tolerance)
      weather.get.pressure should be(1012.0 +- tolerance)
      weather.get.temp should be(55.0 +- tolerance)

    }
    // Advantages of Mocks
    //Mocks allow full scripting of responses (including failures)
    it("should not call getWeather if operational is false"){
      val mockWS = mock[WeatherService]
      (mockWS.operational _:() => Boolean).expects().
        throwing(new IllegalStateException("network failure"))
      val ex = intercept[IllegalStateException]{
        TestMock.lookupWeather(mockWS, "PDX")
      }
      ex.getMessage should be ("network failure")
    }

    //With Mocks, you script up what you expect

    // STUB
    // With Stubs, the emphasis is on verifying what you got:
    it("Should call getWeather with different codes when necessary"){
      val stubWS = stub[WeatherService]

      (stubWS.operational _:() => Boolean).when().returning(true)
      (stubWS.getWeather _).when("PDX").returning(Weather(2.1, 3.2, 4.3))
      (stubWS.getWeather _).when("SFO").returning(Weather(22.1, 33.2, 44.3))

      val res1 = TestMock.lookupWeather(stubWS, "SFO")
      val res2 = TestMock.lookupWeather(stubWS, "PDX")

      (stubWS.operational _:() => Boolean).verify().twice()
      (stubWS.getWeather _).verify("PDX")
      (stubWS.getWeather _).verify("SFO")
    }
  }
}