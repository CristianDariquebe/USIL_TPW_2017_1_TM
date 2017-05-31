package pe.egcc.eureka.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pe.egcc.eureka.model.Cliente;
import pe.egcc.eureka.service.ClienteService;

@Controller
public class ClienteController {
  
  @Autowired
  private ClienteService clienteService;
  
  @RequestMapping(value = "conClientesV1.htm", method = RequestMethod.GET)
  public String conClienteV1(Model model){
    model.addAttribute("menuClientes1", "cssLinkMenuActivo");
    return "conClientes1";
  }
  
  @RequestMapping(value = "conClientesV1.htm", method = RequestMethod.POST)
  public String conClienteV1(
          @RequestParam("criterio") String criterio,
          Model model){
    // Proceso
    List<Map<String,Object>> lista;
    lista = clienteService.conClientes1(criterio);
    // Reporte
    model.addAttribute("menuClientes1", "cssLinkMenuActivo");
    model.addAttribute("criterio", criterio);
    model.addAttribute("lista", lista);
    return "conClientes1";
  }
  
  @RequestMapping(value = "cliente.htm", method = RequestMethod.GET)
  public String conCliente(Model model){
    model.addAttribute("menuCliente", "cssLinkMenuActivo");
    return "cliente";
  }
  
  @RequestMapping(value = "cliente.htm", method = RequestMethod.POST)
  public String conCliente(@RequestParam("codigo") String codigo, Model model){
    // Proceso
    Cliente bean = clienteService.getCliente(codigo);
    model.addAttribute("codigo", codigo);
    if(bean == null){
      model.addAttribute("error", "Código no existe.");
    } else {
      model.addAttribute("bean", bean);
    }
    return "cliente";
  }
}
