package cat.itacademy.barcelonactiva.millaolaya.juan.s05.t01.n01.model.service;

import cat.itacademy.barcelonactiva.millaolaya.juan.s05.t01.n01.model.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.millaolaya.juan.s05.t01.n01.model.entity.Sucursal;
import cat.itacademy.barcelonactiva.millaolaya.juan.s05.t01.n01.model.repository.SucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SucursalServiceImp implements SucursalService {

    @Autowired
    private SucursalRepository sucursalRepository;

    @Override
    public List<SucursalDTO> findAll() {
        List<Sucursal> sucursals = sucursalRepository.findAll();
        SucursalConverter converter = new SucursalConverter();
        return converter.fromEntity(sucursals);
    }

    @Override
    public Optional<SucursalDTO> findById(Integer id) {
        Optional<Sucursal> sucursal = sucursalRepository.findById(id);
        SucursalConverter converter = new SucursalConverter();
        if (sucursal.isPresent()) return Optional.of(converter.fromEntity(sucursal.get()));
        else return Optional.empty();
    }

    @Override
    public SucursalDTO save(SucursalDTO sucursalDto) {
        SucursalConverter converter = new SucursalConverter();
        sucursalRepository.save(converter.fromDto(sucursalDto));
        return sucursalDto;
    }


    @Override
    public void deleteById(Integer id) {
        sucursalRepository.deleteById(id);
    }
}
