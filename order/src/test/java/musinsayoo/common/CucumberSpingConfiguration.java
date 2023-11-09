package musinsayoo.common;

import io.cucumber.spring.CucumberContextConfiguration;
import musinsayoo.OrderApplication;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { OrderApplication.class })
public class CucumberSpingConfiguration {}
