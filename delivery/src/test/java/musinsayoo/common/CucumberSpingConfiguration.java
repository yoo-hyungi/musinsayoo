package musinsayoo.common;

import io.cucumber.spring.CucumberContextConfiguration;
import musinsayoo.DeliveryApplication;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { DeliveryApplication.class })
public class CucumberSpingConfiguration {}
