package cat.itacademy.barcelonactiva.millaolaya.juan.s05.t01.n01.controller;

import cat.itacademy.barcelonactiva.millaolaya.juan.s05.t01.n01.model.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.millaolaya.juan.s05.t01.n01.model.service.SucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http:localhost:9000")
@RestController
@RequestMapping("/sucursal")
public class SucursalController {

    @Autowired
    private SucursalService sucursalService;

    @GetMapping("/getAll")
    public ResponseEntity<List<SucursalDTO>> getAllSucursals(){
        try {
            List<SucursalDTO> sucursals = sucursalService.findAll();

            if (sucursals.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(sucursals, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<SucursalDTO> getOne (@PathVariable("id") int id){
        Optional<SucursalDTO> sucursalData = sucursalService.findById(id);

        if (sucursalData.isPresent()) {
            return new ResponseEntity<>(sucursalData.get(),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/add")
    public ResponseEntity<SucursalDTO> addSucursal(@RequestBody SucursalDTO sucursalDTO) {
        try {
            SucursalDTO _sucursal = sucursalService.save(new SucursalDTO(sucursalDTO.getNomSucursal(), sucursalDTO.getPaisSucursal()));
            return new ResponseEntity<>(_sucursal, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<SucursalDTO> updateSucursal(@PathVariable("id") int id, @RequestBody SucursalDTO sucursalDTO) {
        Optional<SucursalDTO> sucursalData = sucursalService.findById(id);

        if (sucursalData.isPresent()) {
            SucursalDTO _sucursal = sucursalData.get();
            _sucursal.setNomSucursal((sucursalDTO.getNomSucursal()));
            _sucursal.setPaisSucursal((sucursalDTO.getPaisSucursal()));
            return new ResponseEntity<>(sucursalService.save(_sucursal), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteSucursal(@PathVariable("id") int id) {
        try {
            sucursalService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
