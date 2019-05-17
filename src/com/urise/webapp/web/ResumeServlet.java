package com.urise.webapp.web;

import com.urise.webapp.Config;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ResumeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        /*String name = request.getParameter("name");
        response.getWriter().write(name == null ? "Hello Resumes!" : "Hello, " + name + "!");*/
        // Storage sqlStorage = Config.get().getStorage();
        String uuid = request.getParameter("uuid");
        if (uuid != null) {
            response.getWriter().write(Config.get().getStorage().get(uuid).getUuid() + "|");
            response.getWriter().write(Config.get().getStorage().get(uuid).getFullName());
        } else {
            /*response.getWriter().write("<!DOCTYPE html>\n" +
                    "<html lang=\"en\">\n" +
                    "<head>\n" +
                    "\t<meta charset=\"UTF-8\">\n" +
                    "\t<title>Resumes</title>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "\t<!-- create table -->\n" +
                    "\t\t\t<table>\n" +
                    "\t\t\t\t<tr>\n" +
                    "\t\t\t\t\t<th>UUID</th>\n" +
                    "\t\t\t\t\t<th>Full_name</th>\n" +
                    "\t\t\t\t</tr>");
        }

        for (Resume r : sqlStorage.getAllSorted()) {
            response.getWriter().write("<tr>\n" +
                    "\t\t\t\t\t<td>" + r.getUuid() + "</td>\n" +
                    "\t\t\t\t\t<td>" + r.getFullName() + "</td>\n" +
                    "\t\t\t\t</tr>");
        }*/
            response.getWriter().write("Hello!");
        }
    }
}
