package cat.itacademy.barcelonactiva.millaolaya.juan.s05.t01.n01.model.service;

import cat.itacademy.barcelonactiva.millaolaya.juan.s05.t01.n01.model.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.millaolaya.juan.s05.t01.n01.model.entity.Sucursal;

import java.util.List;
import java.util.Optional;

public interface SucursalService {
    List<SucursalDTO> findAll();
    Optional<SucursalDTO> findById(Integer id);
    SucursalDTO save (SucursalDTO sucursalDto);
    void deleteById (Integer id);
}
