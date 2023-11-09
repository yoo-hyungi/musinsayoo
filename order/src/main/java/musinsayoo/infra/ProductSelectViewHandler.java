package musinsayoo.infra;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import musinsayoo.config.kafka.KafkaProcessor;
import musinsayoo.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class ProductSelectViewHandler {

    //<<< DDD / CQRS
    @Autowired
    private ProductSelectRepository productSelectRepository;
    //>>> DDD / CQRS
}
