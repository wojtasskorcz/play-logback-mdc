package com.eyeem.services

import javax.inject.Inject

import com.eyeem.model.Photo

import scala.concurrent.{ExecutionContext, Future}

class ThumbnailService @Inject() (implicit ec: ExecutionContext) {

  def createThumbnail(photo: Photo, width: Int): Future[Photo] = Future {
    Thread.sleep(100) // converting
    // log that converting took 100ms
    Photo(width, photo.height * width / photo.width)
  }

}
