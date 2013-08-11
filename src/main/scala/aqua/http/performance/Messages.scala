package aqua.http.performance

case class SmsMtReq(applicationId: String, password : String, message: String, destinationAddresses : List[String], deliveryStatusRequest : Option[Int] = Some(1))
case class SmsMtDestResp(statusCode : String, statusDetail : String, timeStamp : String, requestId : String, address: String)
case class SmsMtResp(statusCode : String, statusDetail : String, version : String, destinationResponses : List[SmsMtDestResp])

