//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-520 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.11.15 at 06:06:46 PM IST 
//


package com.knack.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import javassist.compiler.ast.NewExpr;


/**
* <p>Java class for anonymous complex type.
* 
* <p>The following schema fragment specifies the expected content contained within this class.
* 
* <pre>
* &lt;complexType>
*   &lt;complexContent>
*     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
*       &lt;sequence>
*         &lt;element name="first" type="{http://www.w3.org/2001/XMLSchema}string"/>
*         &lt;element name="second" type="{http://www.w3.org/2001/XMLSchema}string"/>
*         &lt;element name="third" type="{http://www.w3.org/2001/XMLSchema}string"/>
*         &lt;element name="fourth" type="{http://www.w3.org/2001/XMLSchema}string"/>
*       &lt;/sequence>
*     &lt;/restriction>
*   &lt;/complexContent>
* &lt;/complexType>
* </pre>
* 
* 
*/
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
   "first",
   "second",
   "third",
   "fourth"
})
@XmlRootElement(name = "order")
public class Order {

   @XmlElement(required = true)
   protected String first;
   @XmlElement(required = true)
   protected String second;
   @XmlElement(required = true)
   protected String third;
   @XmlElement(required = true)
   protected String fourth;

   /**
    * Gets the value of the first property.
    * 
    * @return
    *     possible object is
    *     {@link String }
    *     
    */
   public String getFirst() {
       return first;
   }

   /**
    * Sets the value of the first property.
    * 
    * @param value
    *     allowed object is
    *     {@link String }
    *     
    */
   public void setFirst(String value) {
       this.first = value;
   }

public String[] getArray() {
	// TODO Auto-generated method stub
	return new String[] {first,second,third,fourth};
}
   
}

