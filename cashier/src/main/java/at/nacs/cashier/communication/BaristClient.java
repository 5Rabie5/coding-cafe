package at.nacs.cashier.communication;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

//@FeignClient("barista")
//@RefreshScope
public interface BaristClient {

  @PostMapping("/barista")
  boolean isStartWork(String order);

}

