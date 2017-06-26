package br.com.example.sistemalogin.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by alex on 23/06/17.
 */
@Controller
public class HomeController {

    @RequestMapping("/home")
    public String home() {
         return "tela-inicial";
    }

}
