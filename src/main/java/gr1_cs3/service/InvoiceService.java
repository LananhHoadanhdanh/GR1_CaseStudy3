package gr1_cs3.service;

import gr1_cs3.model.Invoice;
import gr1_cs3.model.Product;

import java.util.List;

public interface InvoiceService<I> extends GeneralService<Invoice>{
    public List<Invoice> findAll(String username);
    public int getIdUser(String username);
    public int getIdOrder(String username);
    public int getStatus(String username);
    public boolean addToCart(int idProduct,String userName);
}
