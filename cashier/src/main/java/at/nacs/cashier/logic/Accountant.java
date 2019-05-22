package at.nacs.cashier.logic;

import at.nacs.cashier.persistence.domain.Invoice;
import at.nacs.cashier.persistence.repository.InvoiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class Accountant {

  private final InvoiceRepository invoiceRepository;
  private final Map<String, Double> beverages;

  public Invoice creatInvoice(List<String> orders) {
    return Invoice.builder()
                  .orders(orders)
                  .total(caculeteter(orders))
                  .uuid(UUID.randomUUID())
                  .build();
  }

  private Double caculeteter(List<String> orders) {
    return orders.stream()
                 .map(beverages::get)
                 .mapToDouble(e -> e)
                 .sum();
  }
}
