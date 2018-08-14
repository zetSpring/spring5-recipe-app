package zuko.springframework.repositories;

import org.springframework.data.repository.CrudRepository;
import zuko.springframework.domain.UnitOfMeasure;

import java.util.Optional;

public interface UnitOfMeasureRepository extends CrudRepository <UnitOfMeasure, Long> {

    Optional<UnitOfMeasure> findByUom(String uom);
}
