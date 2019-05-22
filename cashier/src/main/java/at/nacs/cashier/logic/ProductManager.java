package at.nacs.cashier.logic;

import at.nacs.cashier.communication.BaristClient;
import at.nacs.cashier.communication.PickUpClient;
import at.nacs.cashier.dto.Product;
import at.nacs.cashier.dto.Purchase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class ProductManager {
  private final BaristClient baristClient;
  private final PickUpClient pickUpClient;
  private final Map<String, Double> beverages;

  public List<String> displayAll() {
    return beverages.entrySet().stream()
                    .map(e -> e.getKey() + "=" + e.getValue())
                    .collect(toList());
  }


  public List<Boolean> sendOrderToBarita(List<String> orders) {

    return orders.stream()
                 .map(this::getDtoProduct)
                 .map(baristClient::sendNewOrder)
                 .collect(toList());
  }

  private Product getDtoProduct(String order) {
    return Product.builder()
                  .name(order)
                  .ticketUUID(UUID.randomUUID())
                  .build();
  }

  public void sendOrderToPickUpSation(List<String> orders) {
    Purchase purchase = getDtoPurchase(orders);
    pickUpClient.sendNewOrder(purchase);

  }

  private Purchase getDtoPurchase(List<String> orders) {
    return Purchase.builder()
                   .productNames(orders)
                   .ticketUUID(UUID.randomUUID())
                   .build();
  }
}
