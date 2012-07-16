package controllers

import play.api.mvc._

object Application extends Controller {
  def index = Action {
    Redirect(routes.Application.calendarCurrent())
  }

  def calendarCurrent = Action {
    val month = Month()
    Redirect(routes.Application.calendar(month.year, month.number))
  }

  def calendar(year: Int, month: Int) = Action {
    Ok(views.html.calendar(Month(year, month)))
  }
}