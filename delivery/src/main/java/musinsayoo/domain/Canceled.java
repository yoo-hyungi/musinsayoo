package musinsayoo.domain;

import java.util.*;
import lombok.*;
import musinsayoo.domain.*;
import musinsayoo.infra.AbstractEvent;

@Data
@ToString
public class Canceled extends AbstractEvent {

    private Long id;
    private String userId;
    private String productName;
    private Long productId;
    private Integer qty;
    private String status;
    private Date orderDt;
    private String address;
}
