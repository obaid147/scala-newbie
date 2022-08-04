import java.time.{LocalDate, LocalDateTime, LocalTime}
// getting these classes from java and using unapply on them.
LocalDate.now()
LocalTime.now()
LocalDateTime.now()

object DateTime{
  def unapply(localDateTime: LocalDateTime) =
    Some((localDateTime.toLocalDate,
      localDateTime.toLocalTime))
}
object Date{
  def unapply(localDate: LocalDate) =
    Some(localDate.getYear, localDate.getMonthValue,
      localDate.getDayOfMonth)
}
object Time{
  def unapply(localTime: LocalTime) =
    Some(localTime.getHour, localTime.getMinute,
      localTime.getSecond)
}

// lets use them
val Date(year, month, day) = LocalDate.now()
val Time(hour, minute, second) = LocalTime.now()

val Date(_:Int, month, day) = LocalDate.now()

val DateTime(Date(y, m, d), Time(h,mm,s)) = LocalDateTime.now

val dt @ DateTime(date @ Date(y, m, d), time @ Time(h, mm, s)) =
  LocalDateTime.now

  /** Working with Seq */

object DateTimeSeq{
    def unapplySeq(dt: LocalDateTime): Option[Seq[Int]] =
      Some(Seq(
        dt.getYear, dt.getMonthValue, dt.getDayOfMonth,
        dt.getHour, dt.getMinute, dt.getSecond))
  }

val DateTimeSeq(year, month, day, hour, _*) = LocalDateTime.now
//val DateTimeSeq(a, b, c, d, e, f) = LocalDateTime.now()

// Partial Matching returning Some(something) or None
object AM{
  def unapply(t: LocalTime) = t match {
    case Time(h, m , s) if h < 12 => Some(h, m, s)
    case _ => None
  }
}
object PM{
  def unapply(t: LocalTime) = t match {
    case Time(12, m, s) => Some(12, m, s) // Time.unapply
    case Time(h, m, s) if h > 12 => Some(h, m, s)
    case _ => None
  }
}

/**
 * To wrap this up, let’s implement ourselves a clock that
 * formats the current time nicely, by using what we’ve
 * learned about pattern matching, and our AM / PM extractors
 * (plus some old school Java string formatting that almost looks
 * like a stream of emojis)
 */

LocalTime.now match {
  case t @ AM(h, m, _) => f"$h%2d:$m%02d AM ($t precisely)"
  case t @ PM(h, m, _) => f"$h%2d:$m%02d PM ($t precisely)"
}

