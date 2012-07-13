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
}
