package me.mbcu.submods

import java.time.Clock

import pdi.jwt.{Jwt, JwtAlgorithm}

object JWTManual extends App{

  implicit val clock: Clock = Clock.systemUTC
  val token = Jwt.encode("""{"user":1}""", "secretKey", JwtAlgorithm.HS256)

  val decoded = Jwt.decodeRawAll(token, "secretKey", Seq(JwtAlgorithm.HS256))
  val failDecoded = Jwt.decodeRawAll(token, "sfsdfs", Seq(JwtAlgorithm.HS256));

  println(decoded)
  println(failDecoded)


}
