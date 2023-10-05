package com.dev.springboot.service;

import java.util.List;


import com.dev.springboot.model.Invoice;

public interface InvoiceService {
	public Invoice saveInvice(Invoice invoice);
    public List<Invoice> getAllInvoices();
    public Invoice getInvoiceById(Long id);
    public void deleteInvoiceById(Long id);
    public void updateInvoice(Invoice invoice);
}
