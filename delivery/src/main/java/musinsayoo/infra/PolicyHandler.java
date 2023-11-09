package musinsayoo.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import musinsayoo.config.kafka.KafkaProcessor;
import musinsayoo.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    DeliveryManagementRepository deliveryManagementRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Ordered'"
    )
    public void wheneverOrdered_StartDelivery(@Payload Ordered ordered) {
        Ordered event = ordered;
        System.out.println(
            "\n\n##### listener StartDelivery : " + ordered + "\n\n"
        );

        // Sample Logic //
        DeliveryManagement.startDelivery(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Canceled'"
    )
    public void wheneverCanceled_CancelDelivery(@Payload Canceled canceled) {
        Canceled event = canceled;
        System.out.println(
            "\n\n##### listener CancelDelivery : " + canceled + "\n\n"
        );

        // Sample Logic //
        DeliveryManagement.cancelDelivery(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
