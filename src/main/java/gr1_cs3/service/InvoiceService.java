package gr1_cs3.service;

import gr1_cs3.model.Invoice;
import gr1_cs3.model.Order;
import gr1_cs3.model.Product;

import java.util.List;

public interface InvoiceService<I> extends GeneralService<Invoice>{
    public List<Invoice> findAll(String username);
    public int getIdUser(String username);
    public int getIdOrder(String username);
    public int getStatus(String username);
    public void augmentToCart(int idProduct,String userName);
    public void reduceToCart(int idProduct, String userName);
    public void editCart(int idProduct, String userName,int quantity);
    public void addToCart(int idProduct, int idOrder);
    public void addToCa( String userName);
    public void deleteProInCart( String userName,int id);
    public void deleteCart(String userName);
    public String getPassByUser(String username);
    public Order getOrder( String userName);
}
