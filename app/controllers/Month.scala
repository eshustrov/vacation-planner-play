package controllers

import org.joda.time.{LocalDate, DateTimeConstants}

class Month(val year: Int, val number: Int) {
  private val start = new LocalDate(year, number, 1)

  val name: String = start.monthOfYear().getAsText

  class Week private(start: LocalDate) {
    val number = start.getWeekOfWeekyear

    def monthDay(weekDay: Int): Int = start.plusDays(weekDay - 1).getDayOfMonth

    def isThisMonthDay(weekDay: Int): Boolean = start.plusDays(weekDay - 1).getMonthOfYear == Month.this.number
  }

  private object Week {
    def apply(start: LocalDate): Week = new Week(start)
  }

  class WeekIterator extends Iterator[Week] {
    private var nextWeek = Month.this.start.withDayOfWeek(DateTimeConstants.MONDAY)

    override def hasNext = nextWeek.getMonthOfYear == number || nextWeek.compareTo(start) < 0

    override def next() = {
      val newWeek = Week(nextWeek)
      nextWeek = nextWeek.plusWeeks(1)
      newWeek
    }
  }

  def weeks = new WeekIterator

  def prevYear: Int = start.minusYears(1).getYear

  def nextYear: Int = start.plusYears(1).getYear

  def prev: Int = start.minusMonths(1).getMonthOfYear

  def prevMonthYear: Int = start.minusMonths(1).getYear

  def next: Int = start.plusMonths(1).getMonthOfYear

  def nextMonthYear: Int = start.plusMonths(1).getYear
}

object Month {
  def apply(year: Int, month: Int): Month = new Month(year, month)

  def apply(): Month = {
    val now = new LocalDate()
    Month(now.getYear, now.getMonthOfYear)
  }
}