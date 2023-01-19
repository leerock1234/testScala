package jetty


import jakarta.servlet.http
import jakarta.servlet.http.{HttpServlet, HttpServletRequest, HttpServletResponse}
import org.eclipse.jetty.server._
import jetty.JettyExample.CounterServlets.{IncrementServlet, ResetServlet}
import org.eclipse.jetty.servlet.ServletHandler

import java.util.concurrent.atomic.AtomicInteger

object JettyExample {
  val incrementRoute = "/increment"
  val resetRoute = "/reset"
  val handler = new ServletHandler()

  def main(args: Array[String]) = {

    server.setHandler(handler)
    handler.addServletWithMapping(classOf[IncrementServlet], incrementRoute)
    handler.addServletWithMapping(classOf[ResetServlet], resetRoute)
    server.start()
    println(s"Server started on ${port()} with routes: '$incrementRoute'")
    server.join()

  }

  val server = createServer()

  def createServer() = new Server(8080)

  def port() = {
    val conn = server.getConnectors()(0).asInstanceOf[NetworkConnector]
    conn.getLocalPort()
  }

  object CounterServlets{

    private var requestCount: AtomicInteger = new AtomicInteger(0) // encapsulate the state in a Thread safe way

    class IncrementServlet extends HttpServlet {
      override protected def doGet(request: HttpServletRequest, response: HttpServletResponse):Unit = {
        requestCount.getAndIncrement()

        response.setContentType("text/html")
        response.setStatus(HttpServletResponse.SC_OK)
        response.getWriter().println(s"<h2>Increment performed. Count is now $requestCount.</h2>")
      }
    }

    class ResetServlet extends http.HttpServlet {
      override protected def doGet(request: HttpServletRequest, response: HttpServletResponse):Unit = {
        requestCount.set(0)

        response.setContentType("text/html")
        response.setStatus(HttpServletResponse.SC_OK)
        response.getWriter().println(s"<h2>Counter reset to 0.</h2>")

      }
    }
  }

}
