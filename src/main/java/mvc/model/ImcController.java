package mvc.model;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ImcController {

    @PostMapping("/calcular-imc")
    public ModelAndView calcularImc(@RequestParam("peso") double peso, @RequestParam("altura") double altura) {
        double imc = peso / (altura * altura);
        String resultado;
        if (imc < 18.5) {
            resultado = "Abaixo do peso";
        } else if (imc < 24.9) {
            resultado = "Peso normal";
        } else if (imc < 29.9) {
            resultado = "Sobrepeso";
        } else {
            resultado = "Obesidade";
        }
        ModelAndView modelAndView = new ModelAndView("resultado-imc");
        modelAndView.addObject("imc", imc);
        modelAndView.addObject("resultado", resultado);
        return modelAndView;
    }
}
