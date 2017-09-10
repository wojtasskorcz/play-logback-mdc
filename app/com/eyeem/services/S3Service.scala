package com.eyeem.services

import javax.inject.Inject

import com.eyeem.model.Photo

import scala.concurrent.{ExecutionContext, Future}

class S3Service @Inject() (implicit ec: ExecutionContext) {

  def retrievePhoto(photoId: Int): Future[Photo] = Future {
    Thread.sleep(1000) // retrieving
    // log that retrieving took 1000ms
    Photo(4640, 3480)
  }

}
