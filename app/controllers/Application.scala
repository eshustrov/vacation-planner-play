package controllers

import play.api.mvc._

object Application extends Controller {
  def index = Action {
    Redirect(routes.Application.calendarCurrent())
  }

  def calendarCurrent = Action {
    val monthData = MonthData()
    Redirect(routes.Application.calendar(monthData.year, monthData.month))
  }

  def calendar(year: Int, month: Int) = Action {
    Ok(views.html.calendar(MonthData(year, month)))
  }
}