package com.eyeem.controllers

import com.eyeem.services.{S3Service, ThumbnailService}
import com.typesafe.scalalogging.LazyLogging
import org.slf4j.MDC
import play.api.mvc.{BaseController, ControllerComponents}

import scala.concurrent.ExecutionContext

class ThumbnailController(val controllerComponents: ControllerComponents,
                          val s3Service: S3Service,
                          val thumbnailService: ThumbnailService)
                         (implicit ec: ExecutionContext) extends BaseController with LazyLogging {

  def getThumbnailDummy(photoId: Int, width: Int) = Action {
    MDC.put("width", width.toString)
    logger.info("getThumbnail")
    Ok("not really implemented")
  }

  def getThumbnail(photoId: Int, width: Int) = Action.async {
    MDC.put("width", width.toString)
    for {
      photo <- s3Service.retrievePhoto(photoId)
      thumbnail <- thumbnailService.createThumbnail(photo, width)
    } yield {
      logger.info(s"getThumbnail")
      Ok(s"Thumbnail of size ${thumbnail.width}x${thumbnail.height} for photo $photoId")
    }
  }
}