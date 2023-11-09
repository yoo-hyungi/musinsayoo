package musinsayoo.common;

import io.cucumber.spring.CucumberContextConfiguration;
import musinsayoo.ClothApplication;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { ClothApplication.class })
public class CucumberSpingConfiguration {}
