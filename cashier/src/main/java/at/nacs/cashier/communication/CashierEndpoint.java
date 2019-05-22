package at.nacs.cashier.communication;

import at.nacs.cashier.logic.ProductManager;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

  @PostMapping
  List<String> order(@RequestBody String[] orders){
    List<String> order =  List.of(orders);
    return order;
  }

}
