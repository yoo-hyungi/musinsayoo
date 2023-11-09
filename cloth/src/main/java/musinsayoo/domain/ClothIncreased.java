package musinsayoo.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import musinsayoo.domain.*;
import musinsayoo.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class ClothIncreased extends AbstractEvent {

    private Long id;
    private String productName;
    private String productImg;
    private Integer stock;

    public ClothIncreased(Inventory aggregate) {
        super(aggregate);
    }

    public ClothIncreased() {
        super();
    }
}
//>>> DDD / Domain Event
