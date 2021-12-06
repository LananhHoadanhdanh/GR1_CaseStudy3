package gr1_cs3.service;

import gr1_cs3.model.Invoice;

public interface OrderService<O> extends GeneralService<OrderService<O>>{
    public Invoice viewPay();
}
