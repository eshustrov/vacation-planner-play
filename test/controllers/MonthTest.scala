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
  }
}
