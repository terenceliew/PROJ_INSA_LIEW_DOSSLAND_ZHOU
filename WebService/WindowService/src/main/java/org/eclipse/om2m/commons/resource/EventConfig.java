/*******************************************************************************
 * Copyright (c) 2013-2020 LAAS-CNRS (www.laas.fr)
 * 7 Colonel Roche 31077 Toulouse - France
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Initial Contributors:
 *     Thierry Monteil : Project manager, technical co-manager
 *     Mahdi Ben Alaya : Technical co-manager
 *     Samir Medjiah : Technical co-manager
 *     Khalil Drira : Strategy expert
 *     Guillaume Garzone : Developer
 *     François Aïssaoui : Developer
 *
 * New contributors :
 *******************************************************************************/
//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.04.15 at 03:56:27 PM CEST 
//

package org.eclipse.om2m.commons.resource;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlList;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for anonymous complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.onem2m.org/xml/protocols}regularResource">
 *       &lt;sequence>
 *         &lt;element name="creator" type="{http://www.onem2m.org/xml/protocols}ID"/>
 *         &lt;element name="eventID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="eventType" type="{http://www.onem2m.org/xml/protocols}eventType"/>
 *         &lt;element name="eventStart" type="{http://www.onem2m.org/xml/protocols}timestamp" minOccurs="0"/>
 *         &lt;element name="eventEnd" type="{http://www.onem2m.org/xml/protocols}timestamp" minOccurs="0"/>
 *         &lt;element name="operationType" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;list itemType="{http://www.onem2m.org/xml/protocols}operation" />
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="dataSize" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" minOccurs="0"/>
 *         &lt;choice minOccurs="0">
 *           &lt;element name="childResource" type="{http://www.onem2m.org/xml/protocols}childResourceRef" maxOccurs="unbounded"/>
 *           &lt;element ref="{http://www.onem2m.org/xml/protocols}subscription" maxOccurs="unbounded"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "creator", "eventID", "eventType",
		"eventStart", "eventEnd", "operationType", "dataSize", "childResource",
		"subscription" })
@XmlRootElement(name = "eventConfig")
public class EventConfig extends RegularResource {

	@XmlElement(required = true)
	protected String creator;
	@XmlElement(required = true)
	protected String eventID;
	@XmlElement(required = true)
	protected BigInteger eventType;
	protected String eventStart;
	protected String eventEnd;
	@XmlList
	protected List<BigInteger> operationType;
	@XmlSchemaType(name = "nonNegativeInteger")
	protected BigInteger dataSize;
	protected List<ChildResourceRef> childResource;
	@XmlElement(namespace = "http://www.onem2m.org/xml/protocols")
	protected List<Subscription> subscription;

	/**
	 * Gets the value of the creator property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCreator() {
		return creator;
	}

	/**
	 * Sets the value of the creator property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCreator(String value) {
		this.creator = value;
	}

	/**
	 * Gets the value of the eventID property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getEventID() {
		return eventID;
	}

	/**
	 * Sets the value of the eventID property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setEventID(String value) {
		this.eventID = value;
	}

	/**
	 * Gets the value of the eventType property.
	 * 
	 * @return possible object is {@link BigInteger }
	 * 
	 */
	public BigInteger getEventType() {
		return eventType;
	}

	/**
	 * Sets the value of the eventType property.
	 * 
	 * @param value
	 *            allowed object is {@link BigInteger }
	 * 
	 */
	public void setEventType(BigInteger value) {
		this.eventType = value;
	}

	/**
	 * Gets the value of the eventStart property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getEventStart() {
		return eventStart;
	}

	/**
	 * Sets the value of the eventStart property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setEventStart(String value) {
		this.eventStart = value;
	}

	/**
	 * Gets the value of the eventEnd property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getEventEnd() {
		return eventEnd;
	}

	/**
	 * Sets the value of the eventEnd property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setEventEnd(String value) {
		this.eventEnd = value;
	}

	/**
	 * Gets the value of the operationType property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the operationType property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getOperationType().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link BigInteger }
	 * 
	 * 
	 */
	public List<BigInteger> getOperationType() {
		if (operationType == null) {
			operationType = new ArrayList<BigInteger>();
		}
		return this.operationType;
	}

	/**
	 * Gets the value of the dataSize property.
	 * 
	 * @return possible object is {@link BigInteger }
	 * 
	 */
	public BigInteger getDataSize() {
		return dataSize;
	}

	/**
	 * Sets the value of the dataSize property.
	 * 
	 * @param value
	 *            allowed object is {@link BigInteger }
	 * 
	 */
	public void setDataSize(BigInteger value) {
		this.dataSize = value;
	}

	/**
	 * Gets the value of the childResource property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the childResource property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getChildResource().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link ChildResourceRef }
	 * 
	 * 
	 */
	public List<ChildResourceRef> getChildResource() {
		if (childResource == null) {
			childResource = new ArrayList<ChildResourceRef>();
		}
		return this.childResource;
	}

	/**
	 * Gets the value of the subscription property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the subscription property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getSubscription().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link Subscription }
	 * 
	 * 
	 */
	public List<Subscription> getSubscription() {
		if (subscription == null) {
			subscription = new ArrayList<Subscription>();
		}
		return this.subscription;
	}

}
