package cat.itacademy.barcelonactiva.millaolaya.juan.s05.t01.n01.controller.view;

import cat.itacademy.barcelonactiva.millaolaya.juan.s05.t01.n01.model.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.millaolaya.juan.s05.t01.n01.model.service.SucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/edit/{id}")
    public String edit (@PathVariable("id") Integer id, Model model){
        SucursalDTO sucursal = null;
        Optional<SucursalDTO> optSucursal = sucursalService.findById(id);
        if (optSucursal.isPresent()) {
            sucursal = optSucursal.get();
            model.addAttribute("sucursal", sucursal);
            return "/views/sucursals/frmCrear";
        } else {
            System.out.println("El Id no existe");
            return "redirect:/view/listar";
        }

    }

    @GetMapping("/delete/{id}")
    public String eliminar (@PathVariable("id") Integer id) {
        try {
            sucursalService.deleteById(id);
            System.out.println("Registro Eliminado");;
        } catch (Exception e) {
            System.out.println("Registro no encontrado");;
        }
        return "redirect:/view/listar";
    }



}
