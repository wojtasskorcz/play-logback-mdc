package com.eyeem.filters

import akka.stream.Materializer
import com.typesafe.scalalogging.LazyLogging
import play.api.mvc._

import scala.concurrent.{ExecutionContext, Future}

class LoggingFilter(implicit val mat: Materializer, ec: ExecutionContext) extends Filter with LazyLogging {

  def apply(nextFilter: RequestHeader => Future[Result])(requestHeader: RequestHeader): Future[Result] = {

    val startTime = System.currentTimeMillis

    nextFilter(requestHeader).map { result =>

      val endTime = System.currentTimeMillis
      val requestTime = endTime - startTime

      logger.info(s"${requestHeader.method} ${requestHeader.uri} took ${requestTime}ms and returned ${result.header.status}.")

      result.withHeaders("Request-Time" -> requestTime.toString)
    }
  }
}
