package pe.edu.idat.demo_web_formularios.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ImcController {
    @GetMapping("/imc")
    public String formularioImc(){
        return "imc";
    }
}
