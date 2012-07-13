package controllers

import org.joda.time.{LocalDateTime, DateTimeConstants}

class MonthBlock(val year: Int, val month: Int) {
  private val monthStart = new LocalDateTime(year, month, 1, 0, 0)
  private val blockStart = monthStart.withDayOfWeek(DateTimeConstants.MONDAY)

  val name = monthStart.monthOfYear().getAsText

  def week(index: Int): Int = blockStart.plusWeeks(index - 1).getWeekOfWeekyear

  def day(weekIndex: Int, dayIndex: Int): Int = blockStart.plusWeeks(weekIndex - 1).plusDays(dayIndex - 1).getDayOfMonth

  def thisMonth(weekIndex: Int, dayIndex: Int): Boolean =
    blockStart.plusWeeks(weekIndex - 1).plusDays(dayIndex - 1).getMonthOfYear == month

  def prevYear: Int = monthStart.minusYears(1).getYear

  def nextYear: Int = monthStart.plusYears(1).getYear

  def prev: Int = monthStart.minusMonths(1).getMonthOfYear

  def prevMonthYear: Int = monthStart.minusMonths(1).getYear

  def next: Int = monthStart.plusMonths(1).getMonthOfYear

  def nextMonthYear: Int = monthStart.plusMonths(1).getYear
}

object MonthBlock {
  def apply(year: Int, month: Int): MonthBlock = new MonthBlock(year, month)

  def apply(): MonthBlock = {
    val now = new LocalDateTime()
    MonthBlock(now.getYear, now.getMonthOfYear)
  }
}