//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.07.28 at 05:34:43 PM CEST 
//


package ch.ehi.oereb.schemas.oereb._1_0.versioning;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

public class GetVersionsResponse
    extends JAXBElement<GetVersionsResponseType>
{

    protected final static QName NAME = new QName("http://schemas.geo.admin.ch/V_D/OeREB/1.0/Versioning", "GetVersionsResponse");

    public GetVersionsResponse(GetVersionsResponseType value) {
        super(NAME, ((Class) GetVersionsResponseType.class), null, value);
    }

    public GetVersionsResponse() {
        super(NAME, ((Class) GetVersionsResponseType.class), null, null);
    }

}