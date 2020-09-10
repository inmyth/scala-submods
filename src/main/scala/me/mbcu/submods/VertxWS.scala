package me.mbcu.submods

import io.vertx.scala.core.{Vertx, VertxOptions}

object VertxWS extends App{
  import scala.concurrent.ExecutionContext.Implicits.global



  var vertx = Vertx.vertx(VertxOptions().setWorkerPoolSize(1))
  val t = vertx
    .createHttpServer
    .websocketHandler((ctx) => {
      ctx.writeTextMessage("ping")
      ctx.writeTextMessage(ctx.binaryHandlerID())
  }).listenFuture(8080)
  t.map(_ => System.out.println("Server running"))

}
