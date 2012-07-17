package views

import controllers.Month
import org.specs2.mock.Mockito
import org.specs2.mutable.Specification

class calendarTest extends Specification with Mockito {
  val month = mock[Month]
  val weekIterator = mock[month.WeekIterator]
  val week = mock[month.Week]

  month.weeks returns weekIterator
  weekIterator.hasNext returns true thenReturns false
  weekIterator.next returns week
  week.monthDay(anyInt) answers {
    case weekDay: Int if (1 <= weekDay && weekDay <= 7) => 0
    case weekDay => throw new RuntimeException("wrong week day: " + weekDay)
  }

  "calendar template" should {
    "iterate over all week days" in {
      views.html.calendar(month)
      foreach((1 to 7)) {
        weekDay =>
          there was atLeastOne(week).monthDay(weekDay)
      }
    }
  }
}
