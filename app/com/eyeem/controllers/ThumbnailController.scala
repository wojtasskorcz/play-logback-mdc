package com.eyeem.controllers

import javax.inject.Inject

import com.eyeem.services.{S3Service, ThumbnailService}
import play.api.mvc.{BaseController, ControllerComponents}

import scala.concurrent.ExecutionContext.Implicits.global

class ThumbnailController @Inject() (
                                      val controllerComponents: ControllerComponents,
                                      val s3Service: S3Service,
                                      val thumbnailService: ThumbnailService) extends BaseController {

  def getThumbnail(photoId: Int, width: Int) = Action.async {
    for {
      photo <- s3Service.retrievePhoto(photoId)
      thumbnail <- thumbnailService.createThumbnail(photo, width)
    } yield Ok(s"Thumbnail of size ${thumbnail.width}x${thumbnail.height} for photo $photoId")
  }
}