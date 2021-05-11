package com.toyfactory.mvcTest.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class FileController {

    @GetMapping(value = "/file")
    //@ResponseBody
    public void getfile(HttpServletResponse response) {
        response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE + ";charset=euc-kr");
        response.addHeader("Content-Disposition", "attachment; filename=file.txt");
        try {

            for (int i = 0; i < 10000 ; i++) {
                response.getWriter().println("response 한글:" + i);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        //return "testFile";
    }
}
