
package com.epam.lab.location;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for response complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="response">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;element ref="{http://soap.location.lab.epam.com/}summaryFault"/>
 *           &lt;element ref="{http://soap.location.lab.epam.com/}summarySuccess"/>
 *         &lt;/choice>
 *         &lt;element ref="{http://soap.location.lab.epam.com/}friends"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "response", propOrder = {
    "summaryFault",
    "summarySuccess",
    "friends"
})
public class Response {

    protected SummaryFault summaryFault;
    protected SummarySuccess summarySuccess;
    @XmlElement(required = true)
    protected Friends friends;

    /**
     * Gets the value of the summaryFault property.
     * 
     * @return
     *     possible object is
     *     {@link SummaryFault }
     *     
     */
    public SummaryFault getSummaryFault() {
        return summaryFault;
    }

    /**
     * Sets the value of the summaryFault property.
     * 
     * @param value
     *     allowed object is
     *     {@link SummaryFault }
     *     
     */
    public void setSummaryFault(SummaryFault value) {
        this.summaryFault = value;
    }

    /**
     * Gets the value of the summarySuccess property.
     * 
     * @return
     *     possible object is
     *     {@link SummarySuccess }
     *     
     */
    public SummarySuccess getSummarySuccess() {
        return summarySuccess;
    }

    /**
     * Sets the value of the summarySuccess property.
     * 
     * @param value
     *     allowed object is
     *     {@link SummarySuccess }
     *     
     */
    public void setSummarySuccess(SummarySuccess value) {
        this.summarySuccess = value;
    }

    /**
     * Gets the value of the friends property.
     * 
     * @return
     *     possible object is
     *     {@link Friends }
     *     
     */
    public Friends getFriends() {
        return friends;
    }

    /**
     * Sets the value of the friends property.
     * 
     * @param value
     *     allowed object is
     *     {@link Friends }
     *     
     */
    public void setFriends(Friends value) {
        this.friends = value;
    }

}
