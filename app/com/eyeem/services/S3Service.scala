package com.eyeem.services

import com.eyeem.model.Photo

import scala.concurrent.Future

import scala.concurrent.ExecutionContext.Implicits.global

class S3Service {

  def retrievePhoto(photoId: Int): Future[Photo] = Future {
    Thread.sleep(1000) // retrieving
    // log that retrieving took 1000ms
    Photo(4640, 3480)
  }

}
