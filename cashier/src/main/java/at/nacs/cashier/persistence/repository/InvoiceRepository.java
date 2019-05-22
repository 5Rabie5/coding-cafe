package at.nacs.cashier.persistence.repository;

import at.nacs.cashier.persistence.domain.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice,Long> {
}
