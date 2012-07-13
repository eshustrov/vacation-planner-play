package controllers

import play.api.mvc._

object Application extends Controller {
  def index = Action {
    Redirect(routes.Application.calendar())
  }

  def calendar = Action {
    Ok(views.html.calendar(MonthData()))
  }
}