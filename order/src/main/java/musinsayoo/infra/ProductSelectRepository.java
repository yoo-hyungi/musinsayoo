package musinsayoo.infra;

import java.util.List;
import musinsayoo.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(
    collectionResourceRel = "productSelects",
    path = "productSelects"
)
public interface ProductSelectRepository
    extends PagingAndSortingRepository<ProductSelect, Long> {}
