package com.eyeem.services

import com.eyeem.model.Photo

import scala.concurrent.{ExecutionContext, Future}

class S3Service(implicit ec: ExecutionContext) {

  def retrievePhoto(photoId: Int): Future[Photo] = Future {
    Thread.sleep(1000) // retrieving
    // log that retrieving took 1000ms
    Photo(4640, 3480)
  }

}
