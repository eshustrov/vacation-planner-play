package controllers

import play.api.mvc._

object Application extends Controller {
  def index = Action {
    Redirect(routes.Application.calendarCurrent())
  }

  def calendarCurrent = Action {
    val monthBlock = MonthBlock()
    Redirect(routes.Application.calendar(monthBlock.year, monthBlock.month))
  }

  def calendar(year: Int, month: Int) = Action {
    Ok(views.html.calendar(MonthBlock(year, month)))
  }
}