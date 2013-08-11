package aqua.http.performance

import scala.concurrent.{ExecutionContext, Future}
import akka.actor._
import spray.can.client.HttpClient
import spray.client.{DispatchStrategies, HttpConduit}
import spray.io._

trait SprayClientSample {

  implicit val system = ActorSystem()
  val ioBridge = IOExtension(system).ioBridge()
  val httpClient = system.actorOf(Props(new HttpClient(ioBridge)))

  def host : String
  def port : Int

  val conduit = system.actorOf(
    props = Props(new HttpConduit(httpClient, host, port, dispatchStrategy = DispatchStrategies.Pipelined)),
    name = "http-conduit"
  )
}

object SprayClientSample extends SprayClientSample {

  override def host = "core.sdp"
  override def port = 7000

  import SdpJsonProtocol._
  import spray.httpx.SprayJsonSupport._
  import spray.client.HttpConduit._

  def sendMessage(smsReq : SmsMtReq)(implicit ec : ExecutionContext) : Future[SmsMtResp] = {
    val pipeline = (sendReceive(conduit) ~> unmarshal[SmsMtResp])
    pipeline(Post("/sms/send", smsReq))
  }
}