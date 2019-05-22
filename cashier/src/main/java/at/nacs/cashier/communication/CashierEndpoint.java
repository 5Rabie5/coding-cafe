package at.nacs.cashier.communication;

import at.nacs.cashier.logic.ProductManager;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class CashierEndpoint {

  private final ProductManager productManager;

  @GetMapping
  List<String> display(){
    return productManager.displayAll();
  }

}
