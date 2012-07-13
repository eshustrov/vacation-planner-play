package controllers

import play.api.mvc._

object Application extends Controller {
  def index = Action {
    Redirect(routes.Application.calendarCurrent())
  }

  def calendarCurrent = Action {
    show(MonthData())
  }

  def calendar(year: Int, month: Int) = Action {
    show(MonthData(year, month))
  }

  private def show(month: MonthData) = Action {
    Ok(views.html.calendar(month))
  }
}