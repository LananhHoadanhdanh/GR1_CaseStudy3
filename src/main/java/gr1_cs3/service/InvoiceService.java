package gr1_cs3.service;

import gr1_cs3.model.Invoice;
import gr1_cs3.model.Product;

import java.util.List;

public interface InvoiceService<I> extends GeneralService<Invoice>{
    public List<Invoice> findAll(String username);
    public List<Invoice> addToCart();
}
