package com.liveedu.currencyconverteredu.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CurrencyConverterWebController {


    @GetMapping("/index")
    public String serveWebPageIndex() {
        return "index.html";
    }

    @GetMapping("/")
    public String serveWebPage() {
        return "start.html";
    }
}
