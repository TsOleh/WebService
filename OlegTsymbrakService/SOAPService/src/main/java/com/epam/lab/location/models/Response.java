package com.epam.lab.location.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;

@XmlAccessorType(XmlAccessType.FIELD)
public class Response {
    @XmlElementRefs({ @XmlElementRef(type = SummaryFault.class), @XmlElementRef(type = SummarySuccess.class) })
    private Summary summary;

    @XmlElementRefs({ @XmlElementRef(type = Friends.class)})
    private Object result;

    public Response() {
    }

    public Response(Summary summary) {
        this.summary = summary;
    }

    public Response(Object result) {
        this.result = result;
    }
    public Response(Summary summary, Object result) {
        this.summary = summary;
        this.result = result;
    }
    public Summary getSummary() {
        return summary;
    }

    public void setSummary(Summary summary) {
        this.summary = summary;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public static Response success(Object result) {
        return new Response(result);
    }
    public static Response fault(String msg) {
        return new Response(new SummaryFault(msg));
    }
    public static Response success(String msg) {
        return new Response(new SummarySuccess(msg));
    }
}
