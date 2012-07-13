package controllers

import org.joda.time.{LocalDateTime, DateTimeConstants}

class MonthData(val year: Int, month: Int) {
  val name = new LocalDateTime(year, month, 1, 0, 0).monthOfYear().getAsText
  private val firstDay = new LocalDateTime(year, month, 1, 0, 0).withDayOfWeek(DateTimeConstants.MONDAY)

  def week(index: Int): Int = firstDay.plusWeeks(index - 1).getWeekOfWeekyear

  def day(weekIndex: Int, dayIndex: Int): Int = firstDay.plusWeeks(weekIndex - 1).plusDays(dayIndex - 1).getDayOfMonth

  def thisMonth(weekIndex: Int, dayIndex: Int): Boolean =
    firstDay.plusWeeks(weekIndex - 1).plusDays(dayIndex - 1).getMonthOfYear == month
}

object MonthData {
  def apply(year: Int, month: Int): MonthData = new MonthData(year, month)

  def apply(): MonthData = {
    val now = new LocalDateTime()
    MonthData(now.getYear, now.getMonthOfYear)
  }
}