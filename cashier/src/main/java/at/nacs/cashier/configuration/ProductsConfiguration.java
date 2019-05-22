package at.nacs.cashier.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.util.Map;

@EnableConfigurationProperties(ProductsConfiguration.class)
@ConfigurationProperties("dataset")
public class ProductsConfiguration {

  @Getter
  @Setter
  private Map<String, Double> beverages;

  @Bean
  Map<String, Double> beverages() {
    return beverages;
  }
}
