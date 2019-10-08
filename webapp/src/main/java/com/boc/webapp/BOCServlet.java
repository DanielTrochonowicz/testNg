package com.boc.webapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.phloc.json.IJSONObject;

/**
 * Simple servlet to return users JSON
 *
 * @author Krzysztof Zaremba
 *
 */
@WebServlet(urlPatterns = "/users")
public class BOCServlet extends HttpServlet
{

  private static final long serialVersionUID = 375158087729295208L;

  @Override
  protected void doGet(final HttpServletRequest aRequest,
      final HttpServletResponse aResponse) throws ServletException, IOException
  {
    final PrintWriter aWriter = aResponse.getWriter();
    aResponse.setContentType("application/json");
    aResponse.setCharacterEncoding("UTF-8");

    final List<User> aUsers = Repository.getUsers();
    final IJSONObject aResponseJSON = ResponseFactory.createResponse(aUsers);

    aWriter.print(aResponseJSON.getJSONString());
    aWriter.flush();
  }

}
