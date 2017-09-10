package com.eyeem.services

import com.eyeem.model.Photo

import scala.concurrent.Future

import scala.concurrent.ExecutionContext.Implicits.global

class ThumbnailService {

  def createThumbnail(photo: Photo, width: Int): Future[Photo] = Future {
    Thread.sleep(100) // converting
    // log that converting took 100ms
    Photo(width, photo.height * width / photo.width)
  }

}
