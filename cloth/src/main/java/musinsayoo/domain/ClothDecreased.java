package musinsayoo.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import musinsayoo.domain.*;
import musinsayoo.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class ClothDecreased extends AbstractEvent {

    private Long id;
    private String productName;
    private String productImg;
    private Integer stock;

    public ClothDecreased(Inventory aggregate) {
        super(aggregate);
    }

    public ClothDecreased() {
        super();
    }
}
//>>> DDD / Domain Event
