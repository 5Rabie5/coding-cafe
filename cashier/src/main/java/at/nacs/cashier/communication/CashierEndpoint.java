package at.nacs.cashier.communication;

import at.nacs.cashier.logic.Accountant;
import at.nacs.cashier.logic.ProductManager;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class CashierEndpoint {

  private final ProductManager productManager;
  private final Accountant accountant;

  @GetMapping
  List<String> display() {
    return productManager.displayAll();
  }

  @PostMapping
  String getTicket(@RequestBody String[] customerOrders) {
    List<String> orders = List.of(customerOrders);
    accountant.creatInvoice(orders);
    productManager.sendOrderToBarita(orders);
    productManager.sendOrderToPickUpSation(orders);
    return "uu";
  }

}
