package pe.edu.idat.demo_web_formularios.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pe.edu.idat.demo_web_formularios.model.ImcModel;

@Controller
public class ImcController {
    @GetMapping("/imc")
    public String formularioImc(Model model){
        model.addAttribute("imcmodel", new ImcModel());
        model.addAttribute("visualizaralerta", false);
        return "imc";
    }
    @PostMapping("/calcularimc")
    public String calcularImc(@ModelAttribute("imcmodel") ImcModel imc, Model model){
        double tallam = imc.getTalla()/100;
        double valorImc = imc.getPeso()/(tallam * tallam);
        String diagnostico = "";
        String estiloDiagnostico ="alert-danger";
        if (valorImc < 18.5){
            diagnostico = "Por debajo del peso";
            estiloDiagnostico = "alert-dark";
        } else if (valorImc <= 25) {
            diagnostico= "Con peso normal";
            estiloDiagnostico = "alert-primary";
        } else if (valorImc <= 30) {
            diagnostico = "Con sobrepeso";
            estiloDiagnostico = "alert-warning";
        } else if (valorImc <= 36) {
            diagnostico = "Obesidad leve";
            estiloDiagnostico = "alert-light";
        } else if (valorImc <= 39) {
            diagnostico = "Obesidad morbida";
            estiloDiagnostico = "alert-info";
        }
        model.addAttribute("resultado", "Su valor IMC = "+ String.format("%.2f", valorImc) + ", Usted se Encuentra: " + diagnostico);
        model.addAttribute("visualizaralerta", true);
        model.addAttribute("estiloDiagnostico", estiloDiagnostico);
        return "imc";
    }

}
