package musinsayoo.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import musinsayoo.DeliveryApplication;
import musinsayoo.domain.DeliveryCanceled;
import musinsayoo.domain.DeliveryCompleted;
import musinsayoo.domain.DeliveryReturned;
import musinsayoo.domain.DeliveryStarted;

@Entity
@Table(name = "DeliveryManagement_table")
@Data
//<<< DDD / Aggregate Root
public class DeliveryManagement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String userId;

    private Long orderId;

    private String productName;

    private Long productId;

    private Integer qty;

    private String status;

    private Date deliveryDt;

    @PostPersist
    public void onPostPersist() {
        DeliveryStarted deliveryStarted = new DeliveryStarted(this);
        deliveryStarted.publishAfterCommit();
    }

    @PostUpdate
    public void onPostUpdate() {
        DeliveryCompleted deliveryCompleted = new DeliveryCompleted(this);
        deliveryCompleted.publishAfterCommit();

        DeliveryCanceled deliveryCanceled = new DeliveryCanceled(this);
        deliveryCanceled.publishAfterCommit();
    }

    @PreUpdate
    public void onPreUpdate() {
        DeliveryReturned deliveryReturned = new DeliveryReturned(this);
        deliveryReturned.publishAfterCommit();
    }

    public static DeliveryManagementRepository repository() {
        DeliveryManagementRepository deliveryManagementRepository = DeliveryApplication.applicationContext.getBean(
            DeliveryManagementRepository.class
        );
        return deliveryManagementRepository;
    }

    //<<< Clean Arch / Port Method
    public static void startDelivery(Ordered ordered) {
        //implement business logic here:

        /** Example 1:  new item 
        DeliveryManagement deliveryManagement = new DeliveryManagement();
        repository().save(deliveryManagement);

        DeliveryStarted deliveryStarted = new DeliveryStarted(deliveryManagement);
        deliveryStarted.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(ordered.get???()).ifPresent(deliveryManagement->{
            
            deliveryManagement // do something
            repository().save(deliveryManagement);

            DeliveryStarted deliveryStarted = new DeliveryStarted(deliveryManagement);
            deliveryStarted.publishAfterCommit();

         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void cancelDelivery(Canceled canceled) {
        //implement business logic here:

        /** Example 1:  new item 
        DeliveryManagement deliveryManagement = new DeliveryManagement();
        repository().save(deliveryManagement);

        DeliveryCanceled deliveryCanceled = new DeliveryCanceled(deliveryManagement);
        deliveryCanceled.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(canceled.get???()).ifPresent(deliveryManagement->{
            
            deliveryManagement // do something
            repository().save(deliveryManagement);

            DeliveryCanceled deliveryCanceled = new DeliveryCanceled(deliveryManagement);
            deliveryCanceled.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
