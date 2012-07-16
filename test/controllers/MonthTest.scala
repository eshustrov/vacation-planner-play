package controllers

import org.specs2.mutable.Specification
import java.util.Calendar

class MonthTest extends Specification {
  "Month created with no parameters" should {
    "contain the current year" in {
      Month().year must be equalTo Calendar.getInstance().get(Calendar.YEAR)
    }
    "contain the current month number" in {
      Month().number must be equalTo Calendar.getInstance().get(Calendar.MONTH) + 1
    }
  }

  "Month created with parameters" should {
    "contain the specified year" in {
      foreach(Seq(2000, 2012, 2100)) {
        case (year) => Month(year, 1).year must be equalTo year
      }
    }
    "contain the specified month number" in {
      foreach(Seq(1, 7, 12)) {
        case (month) => Month(1, month).number must be equalTo month
      }
    }
  }

  "Month" should {
    "contain month name" in {
      foreach(Seq(1 -> "January", 7 -> "July", 12 -> "December")) {
        case (number, name) => Month(2012, number).name must be equalTo name
      }
    }
    "contain right number of weeks" in {
      foreach(Seq((1999, 1) -> 5, (2012, 7) -> 6, (2021, 2) -> 4)) {
        case ((year, month), weeks) => Month(year, month).weeks.size must be equalTo weeks
      }
    }
    "calculate previous year" in {
      foreach(Seq(2000 -> 1999, 2012 -> 2011, 2100 -> 2099)) {
        case (year, prevYear) => Month(year, 1).prevYear must be equalTo prevYear
      }
    }
    "calculate next year" in {
      foreach(Seq(2000 -> 2001, 2012 -> 2013, 2100 -> 2101)) {
        case (year, nextYear) => Month(year, 1).nextYear must be equalTo nextYear
      }
    }
    "calculate previous month number" in {
      foreach(Seq(1 -> 12, 7 -> 6, 12 -> 11)) {
        case (month, prevMonth) => Month(1, month).prev must be equalTo prevMonth
      }
    }
    "calculate previous month year" in {
      foreach(Seq((2000, 1) -> 1999, (2012, 7) -> 2012, (2100, 12) -> 2100)) {
        case ((year, month), prevYear) => Month(year, month).prevMonthYear must be equalTo prevYear
      }
    }
    "calculate next month number" in {
      foreach(Seq(1 -> 2, 7 -> 8, 12 -> 1)) {
        case (month, nextMonth) => Month(1, month).next must be equalTo nextMonth
      }
    }
    "calculate next month year" in {
      foreach(Seq((2000, 1) -> 2000, (2012, 7) -> 2012, (2100, 12) -> 2101)) {
        case ((year, month), nextYear) => Month(year, month).nextMonthYear must be equalTo nextYear
      }
    }
  }
}
