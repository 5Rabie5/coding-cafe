package at.nacs.cashier.communication;

import at.nacs.cashier.logic.ProductManager;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class CashierEndpointTest {

  @Autowired
  TestRestTemplate testRestTemplate;

  @MockBean
  ProductManager productManager;

  String url = "/";

  @Test
  void display() {
    testRestTemplate.getForObject(url, String[].class);

    verify(productManager).displayAll();
  }
}