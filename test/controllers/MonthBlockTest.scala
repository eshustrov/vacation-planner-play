package controllers

import org.specs2.mutable.Specification
import java.util.Calendar

class MonthBlockTest extends Specification {
  "Month Block with no parameters" should {
    "contain the current year" in {
      MonthBlock().year must be equalTo Calendar.getInstance().get(Calendar.YEAR)
    }
    "contain the current month" in {
      MonthBlock().month must be equalTo Calendar.getInstance().get(Calendar.MONTH) + 1
    }
  }

  "Month Block with parameters" should {
    "contain the same year" in {
      foreach(Seq(2000, 2012, 2100)) {
        case (year) => MonthBlock(year, 1).year must be equalTo year
      }
    }
    "contain the same month" in {
      foreach(Seq(1, 7, 12)) {
        case (month) => MonthBlock(1, month).month must be equalTo month
      }
    }
  }

  "Month Block" should {
    "contain month name" in {
      foreach(Seq(1 -> "January", 7 -> "July", 12 -> "December")) {
        case (number, name) => MonthBlock(2012, number).name must be equalTo name
      }
    }
  }
}
