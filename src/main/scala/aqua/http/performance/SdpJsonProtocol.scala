package aqua.http.performance

import spray.json.DefaultJsonProtocol

trait SdpJsonProtocol  extends DefaultJsonProtocol {
    implicit val smsMtReqFormat = jsonFormat5(SmsMtReq)
    implicit val smsMtDestRespFormat = jsonFormat5(SmsMtDestResp)
    implicit val smsMtRespFormat = jsonFormat4(SmsMtResp)
}

object SdpJsonProtocol extends SdpJsonProtocol



