package cat.itacademy.barcelonactiva.millaolaya.juan.s05.t01.n01.model.service;

import cat.itacademy.barcelonactiva.millaolaya.juan.s05.t01.n01.model.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.millaolaya.juan.s05.t01.n01.model.entity.Sucursal;

import java.util.Optional;

public class SucursalConverter extends AbstractConverter <Sucursal, SucursalDTO> {


    @Override
    public Sucursal fromDto(SucursalDTO dto) {
        Sucursal sucursal = new Sucursal();
        if(dto.getPk_SucursalID()!=null) {
            sucursal.setPk_SucursalID(dto.getPk_SucursalID());
        }
        sucursal.setNomSucursal(dto.getNomSucursal());
        sucursal.setPaisSucursal(dto.getPaisSucursal());
        return sucursal;
    }

    @Override
    public SucursalDTO fromEntity(Sucursal entity) {
        SucursalDTO sucursalDTO = new SucursalDTO(entity.getPk_SucursalID(), entity.getNomSucursal(), entity.getPaisSucursal());
        return sucursalDTO;
    }


}

