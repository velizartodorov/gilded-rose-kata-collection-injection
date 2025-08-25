package gilded.rose.kata;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TestControllerTest {

  @Autowired
  TestController testController;

  @Test
  void contextLoads() {
    assertEquals("test", testController.test());
  }

}