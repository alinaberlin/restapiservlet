package org.example;


import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.json.JSONObject;

import java.io.IOException;

@WebServlet(urlPatterns = "/people/*")
public class PersonServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String requestUrl = request.getRequestURI();
        String name = requestUrl.substring("/people/".length());

        Person person = DataStore.getInstance().getPerson(name);
        if (person != null) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("name", person.getName());
            jsonObject.put("about", person.getAbout());
            jsonObject.put("birthYear", person.getBirthYear());
            response.getOutputStream().println(jsonObject.toString());
        } else {
            response.getOutputStream().println("{}");
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String about = request.getParameter("about");
        int birthYear = Integer.parseInt(request.getParameter("birthYear"));
        DataStore.getInstance().putPerson(new Person(name, about, birthYear));
    }

}
