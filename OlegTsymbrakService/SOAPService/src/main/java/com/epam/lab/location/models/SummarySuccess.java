package com.epam.lab.location.models;

        import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "summarySuccess")
public class SummarySuccess extends Summary{
    public SummarySuccess() {
    }

    public SummarySuccess(String message) {
        super(message);
    }
}
