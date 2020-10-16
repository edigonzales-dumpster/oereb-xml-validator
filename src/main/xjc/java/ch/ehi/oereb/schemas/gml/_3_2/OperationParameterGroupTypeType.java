//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.07.28 at 05:34:43 PM CEST 
//


package ch.ehi.oereb.schemas.gml._3_2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OperationParameterGroupType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OperationParameterGroupType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.opengis.net/gml/3.2}AbstractGeneralOperationParameterType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.opengis.net/gml/3.2}maximumOccurs" minOccurs="0"/>
 *         &lt;element ref="{http://www.opengis.net/gml/3.2}parameter" maxOccurs="unbounded" minOccurs="2"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OperationParameterGroupType", propOrder = {
    "maximumOccurs",
    "parameter"
})
public class OperationParameterGroupTypeType
    extends AbstractGeneralOperationParameterTypeType
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElementRef(name = "maximumOccurs", namespace = "http://www.opengis.net/gml/3.2", type = MaximumOccurs.class, required = false)
    protected MaximumOccurs maximumOccurs;
    @XmlElementRef(name = "parameter", namespace = "http://www.opengis.net/gml/3.2", type = Parameter.class)
    protected List<JAXBElement<AbstractGeneralOperationParameterPropertyTypeType>> parameter;

    /**
     * Gets the value of the maximumOccurs property.
     * 
     * @return
     *     possible object is
     *     {@link MaximumOccurs }
     *     
     */
    public MaximumOccurs getMaximumOccurs() {
        return maximumOccurs;
    }

    /**
     * Sets the value of the maximumOccurs property.
     * 
     * @param value
     *     allowed object is
     *     {@link MaximumOccurs }
     *     
     */
    public void setMaximumOccurs(MaximumOccurs value) {
        this.maximumOccurs = value;
    }

    /**
     * Gets the value of the parameter property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the parameter property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getParameter().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UsesParameter }
     * {@link Parameter }
     * {@link GeneralOperationParameter }
     * {@link IncludesParameter }
     * 
     * 
     */
    public List<JAXBElement<AbstractGeneralOperationParameterPropertyTypeType>> getParameter() {
        if (parameter == null) {
            parameter = new ArrayList<JAXBElement<AbstractGeneralOperationParameterPropertyTypeType>>();
        }
        return this.parameter;
    }

}