package cat.itacademy.barcelonactiva.millaolaya.juan.s05.t01.n01.model.service;

import cat.itacademy.barcelonactiva.millaolaya.juan.s05.t01.n01.model.entity.Sucursal;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SucursalServiceImp implements SucursalService{

    @Override
    public List<Sucursal> findAll() {
        return null;
    }

    @Override
    public Optional<Sucursal> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public Sucursal save(Sucursal sucursal) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }
}
