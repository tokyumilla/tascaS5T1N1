package cat.itacademy.barcelonactiva.millaolaya.juan.s05.t01.n01.controller;

import cat.itacademy.barcelonactiva.millaolaya.juan.s05.t01.n01.model.entity.Sucursal;
import cat.itacademy.barcelonactiva.millaolaya.juan.s05.t01.n01.model.service.SucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http:localhost:9000")
@RestController
@RequestMapping("/sucursal")
public class SucursalController {

    @Autowired
    private SucursalService sucursalService;

    @GetMapping("/getAll")
    public ResponseEntity<List<Sucursal>> getAllSucursals(){
        try {

        }
    };
}
