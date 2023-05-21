package cat.itacademy.barcelonactiva.millaolaya.juan.s05.t01.n01.controller.view;

import cat.itacademy.barcelonactiva.millaolaya.juan.s05.t01.n01.model.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.millaolaya.juan.s05.t01.n01.model.service.SucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http:localhost:9000")
@Controller
@RequestMapping("/view")
public class SucursalViewController {

    @Autowired
    private SucursalService sucursalService;

    @GetMapping("/listar")
    public String listAll(Model model){
        List <SucursalDTO> sucursales = sucursalService.findAll();
        model.addAttribute("titulo", "Lista de Sucursales");
        model.addAttribute("sucursales", sucursales);
        return "/views/sucursals/listAll";
    }

    @GetMapping("/create")
    public String create(Model model){
        SucursalDTO sucursal = new SucursalDTO();
        model.addAttribute("sucursal", sucursal);
        return "/views/sucursals/frmCrear";
    }

    @PostMapping("/save")
    public String guardar(@ModelAttribute SucursalDTO sucursal){
        sucursalService.save(sucursal);
        System.out.println("Sucursal creada");
        return "redirect:/view/listar";
    }
}
