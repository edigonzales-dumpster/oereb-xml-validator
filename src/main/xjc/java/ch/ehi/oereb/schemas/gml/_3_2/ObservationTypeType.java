//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.07.28 at 05:34:43 PM CEST 
//


package ch.ehi.oereb.schemas.gml._3_2;

import java.io.Serializable;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ObservationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ObservationType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.opengis.net/gml/3.2}AbstractFeatureType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.opengis.net/gml/3.2}validTime"/>
 *         &lt;element ref="{http://www.opengis.net/gml/3.2}using" minOccurs="0"/>
 *         &lt;element ref="{http://www.opengis.net/gml/3.2}target" minOccurs="0"/>
 *         &lt;element ref="{http://www.opengis.net/gml/3.2}resultOf"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ObservationType", propOrder = {
    "validTime",
    "using",
    "target",
    "resultOf"
})
@XmlSeeAlso({
    DirectedObservationTypeType.class
})
public class ObservationTypeType
    extends AbstractFeatureTypeType
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElementRef(name = "validTime", namespace = "http://www.opengis.net/gml/3.2", type = ValidTime.class)
    protected ValidTime validTime;
    @XmlElementRef(name = "using", namespace = "http://www.opengis.net/gml/3.2", type = Using.class, required = false)
    protected Using using;
    @XmlElementRef(name = "target", namespace = "http://www.opengis.net/gml/3.2", type = Target.class, required = false)
    protected JAXBElement<TargetPropertyTypeType> target;
    @XmlElementRef(name = "resultOf", namespace = "http://www.opengis.net/gml/3.2", type = ResultOf.class)
    protected ResultOf resultOf;

    /**
     * Gets the value of the validTime property.
     * 
     * @return
     *     possible object is
     *     {@link ValidTime }
     *     
     */
    public ValidTime getValidTime() {
        return validTime;
    }

    /**
     * Sets the value of the validTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link ValidTime }
     *     
     */
    public void setValidTime(ValidTime value) {
        this.validTime = value;
    }

    /**
     * Gets the value of the using property.
     * 
     * @return
     *     possible object is
     *     {@link Using }
     *     
     */
    public Using getUsing() {
        return using;
    }

    /**
     * Sets the value of the using property.
     * 
     * @param value
     *     allowed object is
     *     {@link Using }
     *     
     */
    public void setUsing(Using value) {
        this.using = value;
    }

    /**
     * Gets the value of the target property.
     * 
     * @return
     *     possible object is
     *     {@link Subject }
     *     {@link Target }
     *     
     */
    public JAXBElement<TargetPropertyTypeType> getTarget() {
        return target;
    }

    /**
     * Sets the value of the target property.
     * 
     * @param value
     *     allowed object is
     *     {@link Subject }
     *     {@link Target }
     *     
     */
    public void setTarget(JAXBElement<TargetPropertyTypeType> value) {
        this.target = value;
    }

    /**
     * Gets the value of the resultOf property.
     * 
     * @return
     *     possible object is
     *     {@link ResultOf }
     *     
     */
    public ResultOf getResultOf() {
        return resultOf;
    }

    /**
     * Sets the value of the resultOf property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResultOf }
     *     
     */
    public void setResultOf(ResultOf value) {
        this.resultOf = value;
    }

}
