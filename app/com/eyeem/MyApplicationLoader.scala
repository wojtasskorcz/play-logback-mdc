package com.eyeem

import com.eyeem.controllers.ThumbnailController
import com.eyeem.services.{S3Service, ThumbnailService}
import play.api.ApplicationLoader.Context
import play.api.{ApplicationLoader, BuiltInComponentsFromContext, LoggerConfigurator}
import play.filters.HttpFiltersComponents
import router.Routes

class MyApplicationLoader extends ApplicationLoader {

  def load(context: Context) = {
    LoggerConfigurator(context.environment.classLoader).foreach {
      _.configure(context.environment, context.initialConfiguration, Map.empty)
    }
    new MyComponents(context).application
  }

}

class MyComponents(context: Context) extends BuiltInComponentsFromContext(context) with HttpFiltersComponents {
  lazy val s3Service = new S3Service
  lazy val thumbnailService = new ThumbnailService
  lazy val thumbnailController = new ThumbnailController(controllerComponents, s3Service, thumbnailService)
  lazy val router = new Routes(httpErrorHandler, thumbnailController)
}