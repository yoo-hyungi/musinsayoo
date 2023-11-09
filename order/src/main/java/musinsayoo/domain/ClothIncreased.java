package musinsayoo.domain;

import java.util.*;
import lombok.*;
import musinsayoo.domain.*;
import musinsayoo.infra.AbstractEvent;

@Data
@ToString
public class ClothIncreased extends AbstractEvent {

    private Long id;
    private String productName;
    private String productImg;
    private Integer stock;
}
