package com.epam.lab.location.models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "summaryFault")
public class SummaryFault extends Summary{
    public SummaryFault() {
    }
    public SummaryFault(String message) {
        super(message);
    }
}
