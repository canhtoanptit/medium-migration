package models

import java.time.Instant

case class User(id: Option[Long], username: String, email: String, bio: Option[String],
                image: Option[String], createdAt: Instant, updatedAt: Instant
               ) {

}
