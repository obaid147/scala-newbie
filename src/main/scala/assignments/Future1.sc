import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.concurrent.duration._

/*val success: Future[Int] = Future {
  Thread.sleep(10000)
  2 + 1
}


val res: Int = Await.result(success, 11.second) // Await.ready


val x: Future[Int] = Future {
  10
}

val y: Future[Int] = Future.successful(10)

def method(x: Int):Future[Int] = {

  def boolTest = true
  def api = Future(10)

  if(boolTest) {
    api
  } else {
    // Future.successful(10) // here no thread will be allocated by OS
    Future.failed(throw new Exception(""))
  }
}*/


//diff b/w recover, recoverWith, transform


case class DiagnosisCode(rootCode: String, uniqueCode: String, description: Option[String] = None)

object Database {
  val data: List[DiagnosisCode] = List(
    DiagnosisCode("A00", "A001", Some("Cholera due to Vibrio cholerae")),
    DiagnosisCode("A00", "A009", Some("Cholera, unspecified")),
    DiagnosisCode("A08", "A080", Some("Rotaviral enteritis")),
    DiagnosisCode("A08", "A083", Some("Other viral enteritis")),
    DiagnosisCode("B15", "B150", Some("Hepatitis A with hepatic coma")),
    DiagnosisCode("B15", "B159", Some("Hepatitis A without hepatic coma")),
    DiagnosisCode("H26", "H26001", Some("Other cataract right eye")),
    DiagnosisCode("H26", "H26002", Some("Other cataract left eye"))
  )

  def getAllUniqueCodes: Future[List[String]] = Future {
    Database.data.map(_.uniqueCode)
  }

  def fetchDiagnosisForUniqueCode(uniqueCode: String): Future[Option[DiagnosisCode]] = Future {
    Database.data.find(code => code.uniqueCode == uniqueCode)
  }

}

//getAllUniqueCodes codes, --> a
//map over a and then call fetchDiagnosisForUniqueCode
def fetchDiagnosisForUniqueCodes: Future[List[DiagnosisCode]] =  {
//  Database.getAllUniqueCodes.map
???
}

/**
 * A00 -> List(A001, A009)
 * H26 -> List(H26001, H26002)
 */

def fetchUniqueCodesForARootCode: Future[Map[String, List[String]]] = {
  /*val y: Map[(String, List[String]), List[DiagnosisCode]] =
    Database.data.groupBy(x => x.rootCode -> List(x.uniqueCode))
  val z: Map[String, List[DiagnosisCode]] = Database.data.groupBy(_.rootCode)
  z*/

???
}