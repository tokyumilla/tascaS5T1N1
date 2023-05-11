package cat.itacademy.barcelonactiva.millaolaya.juan.s05.t01.n01.model.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public abstract class AbstractConverter <E,D> {

    public abstract E fromDto (D dto);

    public abstract D fromEntity (E entity);

    public List <E> fromDto (List<D> dtos) {
        if (dtos == null) return null;
        return dtos.stream().map(dto-> fromDto(dto)).collect(Collectors.toList());
    }

    public List<D> fromEntity (List<E> entities){
        if(entities==null) return null;
        return entities.stream().map(entity->fromEntity(entity)).collect(Collectors.toList());
    }
}
