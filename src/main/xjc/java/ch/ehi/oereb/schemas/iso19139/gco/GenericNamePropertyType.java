//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.07.28 at 05:34:43 PM CEST 
//


package ch.ehi.oereb.schemas.iso19139.gco;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import ch.ehi.oereb.schemas.gml._3_2.CodeTypeType;


/**
 * <p>Java class for GenericName_PropertyType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GenericName_PropertyType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence minOccurs="0">
 *         &lt;element ref="{http://www.isotc211.org/2005/gco}AbstractGenericName"/>
 *       &lt;/sequence>
 *       &lt;attribute ref="{http://www.isotc211.org/2005/gco}nilReason"/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GenericName_PropertyType", propOrder = {
    "abstractGenericName"
})
public class GenericNamePropertyType
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElementRef(name = "AbstractGenericName", namespace = "http://www.isotc211.org/2005/gco", type = AbstractGenericName.class, required = false)
    protected JAXBElement<CodeTypeType> abstractGenericName;
    @XmlAttribute(name = "nilReason", namespace = "http://www.isotc211.org/2005/gco")
    protected List<String> nilReason;

    /**
     * Gets the value of the abstractGenericName property.
     * 
     * @return
     *     possible object is
     *     {@link AbstractGenericName }
     *     {@link LocalName }
     *     {@link ScopedName }
     *     
     */
    public JAXBElement<CodeTypeType> getAbstractGenericName() {
        return abstractGenericName;
    }

    /**
     * Sets the value of the abstractGenericName property.
     * 
     * @param value
     *     allowed object is
     *     {@link AbstractGenericName }
     *     {@link LocalName }
     *     {@link ScopedName }
     *     
     */
    public void setAbstractGenericName(JAXBElement<CodeTypeType> value) {
        this.abstractGenericName = value;
    }

    /**
     * Gets the value of the nilReason property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the nilReason property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNilReason().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getNilReason() {
        if (nilReason == null) {
            nilReason = new ArrayList<String>();
        }
        return this.nilReason;
    }

}
