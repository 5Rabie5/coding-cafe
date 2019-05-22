package at.nacs.cashier.communication;

import at.nacs.cashier.dto.Product;
import at.nacs.cashier.dto.Purchase;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

//@FeignClient("pickup")
//@RefreshScope
public interface PickUpClient {

  @PostMapping("/pickup")
  void sendNewOrder(Purchase purchase);

}

