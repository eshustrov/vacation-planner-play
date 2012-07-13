package controllers

import org.joda.time.{LocalDateTime, DateTimeConstants}

class MonthData(val year: Int, val month: Int) {
  private val monthStart = new LocalDateTime(year, month, 1, 0, 0)
  private val firstDay = monthStart.withDayOfWeek(DateTimeConstants.MONDAY)

  val name = monthStart.monthOfYear().getAsText

  def week(index: Int): Int = firstDay.plusWeeks(index - 1).getWeekOfWeekyear

  def day(weekIndex: Int, dayIndex: Int): Int = firstDay.plusWeeks(weekIndex - 1).plusDays(dayIndex - 1).getDayOfMonth

  def thisMonth(weekIndex: Int, dayIndex: Int): Boolean =
    firstDay.plusWeeks(weekIndex - 1).plusDays(dayIndex - 1).getMonthOfYear == month

  def prevYear: Int = monthStart.minusYears(1).getYear

  def nextYear: Int = monthStart.plusYears(1).getYear

  def prev: Int = monthStart.minusMonths(1).getMonthOfYear

  def next: Int = monthStart.plusMonths(1).getMonthOfYear
}

object MonthData {
  def apply(year: Int, month: Int): MonthData = new MonthData(year, month)

  def apply(): MonthData = {
    val now = new LocalDateTime()
    MonthData(now.getYear, now.getMonthOfYear)
  }
}