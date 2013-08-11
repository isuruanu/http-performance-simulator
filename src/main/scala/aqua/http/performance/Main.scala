package aqua.http.performance

import scala.concurrent.{ExecutionContext, Future}
import scala.util.{Success, Failure}


object Main extends App{

  implicit def ec = ExecutionContext.Implicits.global

  val message: Future[SmsMtResp] = SprayClientSample.
    sendMessage(SmsMtReq("APP_000952", "b96e26ca39fa38e9f9bd867ab3701e43", "hello world", List("tel:94776177400"), Some(1)))

  message onComplete {
    case Success(resp) => {
      println(resp)
      sys.exit()
    }
    case Failure(e) => {
      val err: String = e.getMessage
      println(s"Error occurred $err")
      e.printStackTrace()
      sys.exit()
    }
  }
}
