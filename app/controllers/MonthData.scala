package controllers

import org.joda.time.{LocalDateTime, DateTimeConstants}

class MonthData(year: Int, month: Int) {
  val name = monthName
  private val firstDay = firstWeekOfMonth

  def week(index: Int): Int = firstDay.plusWeeks(index - 1).getWeekOfWeekyear

  def day(weekIndex: Int, dayIndex: Int): Int = firstDay.plusWeeks(weekIndex - 1).plusDays(dayIndex - 1).getDayOfMonth

  private def monthName: String = new LocalDateTime(year, month, 1, 0, 0).monthOfYear().getAsText

  private def firstWeekOfMonth: LocalDateTime = {
    new LocalDateTime(year, month, 1, 0, 0).withDayOfWeek(DateTimeConstants.MONDAY)
  }
}

object MonthData {
  def apply() = {
    val now = new LocalDateTime()
    new MonthData(now.getYear, now.getMonthOfYear)
  }
}