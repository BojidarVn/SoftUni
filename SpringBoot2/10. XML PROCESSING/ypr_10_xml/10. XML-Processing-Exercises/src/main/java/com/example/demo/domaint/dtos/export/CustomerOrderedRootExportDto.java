package com.example.demo.domaint.dtos.export;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "customers")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomerOrderedRootExportDto {

    @XmlElement(name = "customer")
    private List<CustomerOrderedExportDto> customers;

    public CustomerOrderedRootExportDto() {
    }

    public List<CustomerOrderedExportDto> getCustomers() {
        return customers;
    }

    public void setCustomers(List<CustomerOrderedExportDto> customers) {
        this.customers = customers;
    }
}
