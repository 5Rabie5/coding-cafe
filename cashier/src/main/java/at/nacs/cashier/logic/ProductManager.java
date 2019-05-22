package at.nacs.cashier.logic;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

@Service
@RequiredArgsConstructor
public class ProductManager {

  private final Map<String, Double> beverages;

  public List<String> displayAll() {
    return beverages.entrySet().stream()
             .map(e -> e.getKey() + "=" + e.getValue())
             .collect(toList());
  }

}
