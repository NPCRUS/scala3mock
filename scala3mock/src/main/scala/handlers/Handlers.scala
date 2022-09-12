package handlers

import scala.collection.mutable.ListBuffer

abstract class Handlers extends Handler {

  def add(handler: Handler): Unit = handlers += handler

  def isSatisfied: Boolean = handlers forall (_.isSatisfied)

  override def toString: String = handlers.flatMap { h =>
    scala.Predef.augmentString(h.toString).linesIterator.toArray.map { l => "  " + l }
  }.mkString(s"$prefix {\n", "\n", "\n}")

  protected var handlers = new ListBuffer[Handler]

  protected val prefix: String
}
