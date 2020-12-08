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
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

import org.eclipse.om2m.commons.constants.ShortName;

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
 *     &lt;extension base="{http://www.onem2m.org/xml/protocols}announcedResource">
 *       &lt;sequence>
 *         &lt;element name="stateTag" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
 *         &lt;element name="maxNrOfInstances" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" minOccurs="0"/>
 *         &lt;element name="maxByteSize" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" minOccurs="0"/>
 *         &lt;element name="maxInstanceAge" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" minOccurs="0"/>
 *         &lt;element name="currentNrOfInstances" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
 *         &lt;element name="currentByteSize" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
 *         &lt;element name="locationID" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/>
 *         &lt;element name="ontologyRef" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/>
 *         &lt;choice minOccurs="0">
 *           &lt;element name="childResource" type="{http://www.onem2m.org/xml/protocols}childResourceRef" maxOccurs="unbounded"/>
 *           &lt;choice maxOccurs="unbounded">
 *             &lt;element ref="{http://www.onem2m.org/xml/protocols}contentInstance"/>
 *             &lt;element ref="{http://www.onem2m.org/xml/protocols}contentInstanceAnnc"/>
 *             &lt;element ref="{http://www.onem2m.org/xml/protocols}container"/>
 *             &lt;element ref="{http://www.onem2m.org/xml/protocols}containerAnnc"/>
 *             &lt;element ref="{http://www.onem2m.org/xml/protocols}subscription"/>
 *           &lt;/choice>
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
@XmlType(name = "")
@XmlRootElement(name = ShortName.CNT_ANNC)
public class ContainerAnnc extends AnnouncedResource {

	@XmlElement(required = true, name = ShortName.STATETAG, namespace="")
	@XmlSchemaType(name = "nonNegativeInteger")
	protected BigInteger stateTag;
	@XmlSchemaType(name = "nonNegativeInteger")
	@XmlElement(name = ShortName.MAX_NR_OF_INSTANCES, namespace="")
	protected BigInteger maxNrOfInstances;
	@XmlElement(name = ShortName.MAX_BYTE_SIZE, namespace="")
	@XmlSchemaType(name = "nonNegativeInteger")
	protected BigInteger maxByteSize;
	@XmlElement(name = ShortName.MAX_INSTANCE_AGE, namespace="")
	@XmlSchemaType(name = "nonNegativeInteger")
	protected BigInteger maxInstanceAge;
	@XmlElement(required = true, name = ShortName.CURRENT_NUMBER_OF_INSTANCES, namespace="")
	@XmlSchemaType(name = "nonNegativeInteger")
	protected BigInteger currentNrOfInstances;
	@XmlElement(required = true, name = ShortName.CURRENT_BYTE_SIZE, namespace="")
	@XmlSchemaType(name = "nonNegativeInteger")
	protected BigInteger currentByteSize;
	@XmlSchemaType(name = "anyURI")
	@XmlElement(name = ShortName.LOCATION_ID, namespace="")
	protected String locationID;
	@XmlSchemaType(name = "anyURI")
	@XmlElement(name = ShortName.ONTOLOGY_REF, namespace="")
	protected String ontologyRef;
	@XmlElement(name = ShortName.CHILD_RESOURCE, namespace="")
	protected List<ChildResourceRef> childResource;
	@XmlElements({
			@XmlElement(name = "contentInstance", namespace = "http://www.onem2m.org/xml/protocols", type = ContentInstance.class),
			@XmlElement(name = "contentInstanceAnnc", namespace = "http://www.onem2m.org/xml/protocols", type = ContentInstanceAnnc.class),
			@XmlElement(name = "container", namespace = "http://www.onem2m.org/xml/protocols", type = Container.class),
			@XmlElement(name = "containerAnnc", namespace = "http://www.onem2m.org/xml/protocols", type = ContainerAnnc.class),
			@XmlElement(name = "subscription", namespace = "http://www.onem2m.org/xml/protocols", type = Subscription.class) })
	protected List<Resource> contentInstanceOrContentInstanceAnncOrContainer;

	/**
	 * Gets the value of the stateTag property.
	 * 
	 * @return possible object is {@link BigInteger }
	 * 
	 */
	public BigInteger getStateTag() {
		return stateTag;
	}

	/**
	 * Sets the value of the stateTag property.
	 * 
	 * @param value
	 *            allowed object is {@link BigInteger }
	 * 
	 */
	public void setStateTag(BigInteger value) {
		this.stateTag = value;
	}

	/**
	 * Gets the value of the maxNrOfInstances property.
	 * 
	 * @return possible object is {@link BigInteger }
	 * 
	 */
	public BigInteger getMaxNrOfInstances() {
		return maxNrOfInstances;
	}

	/**
	 * Sets the value of the maxNrOfInstances property.
	 * 
	 * @param value
	 *            allowed object is {@link BigInteger }
	 * 
	 */
	public void setMaxNrOfInstances(BigInteger value) {
		this.maxNrOfInstances = value;
	}

	/**
	 * Gets the value of the maxByteSize property.
	 * 
	 * @return possible object is {@link BigInteger }
	 * 
	 */
	public BigInteger getMaxByteSize() {
		return maxByteSize;
	}

	/**
	 * Sets the value of the maxByteSize property.
	 * 
	 * @param value
	 *            allowed object is {@link BigInteger }
	 * 
	 */
	public void setMaxByteSize(BigInteger value) {
		this.maxByteSize = value;
	}

	/**
	 * Gets the value of the maxInstanceAge property.
	 * 
	 * @return possible object is {@link BigInteger }
	 * 
	 */
	public BigInteger getMaxInstanceAge() {
		return maxInstanceAge;
	}

	/**
	 * Sets the value of the maxInstanceAge property.
	 * 
	 * @param value
	 *            allowed object is {@link BigInteger }
	 * 
	 */
	public void setMaxInstanceAge(BigInteger value) {
		this.maxInstanceAge = value;
	}

	/**
	 * Gets the value of the currentNrOfInstances property.
	 * 
	 * @return possible object is {@link BigInteger }
	 * 
	 */
	public BigInteger getCurrentNrOfInstances() {
		return currentNrOfInstances;
	}

	/**
	 * Sets the value of the currentNrOfInstances property.
	 * 
	 * @param value
	 *            allowed object is {@link BigInteger }
	 * 
	 */
	public void setCurrentNrOfInstances(BigInteger value) {
		this.currentNrOfInstances = value;
	}

	/**
	 * Gets the value of the currentByteSize property.
	 * 
	 * @return possible object is {@link BigInteger }
	 * 
	 */
	public BigInteger getCurrentByteSize() {
		return currentByteSize;
	}

	/**
	 * Sets the value of the currentByteSize property.
	 * 
	 * @param value
	 *            allowed object is {@link BigInteger }
	 * 
	 */
	public void setCurrentByteSize(BigInteger value) {
		this.currentByteSize = value;
	}

	/**
	 * Gets the value of the locationID property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getLocationID() {
		return locationID;
	}

	/**
	 * Sets the value of the locationID property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setLocationID(String value) {
		this.locationID = value;
	}

	/**
	 * Gets the value of the ontologyRef property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getOntologyRef() {
		return ontologyRef;
	}

	/**
	 * Sets the value of the ontologyRef property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setOntologyRef(String value) {
		this.ontologyRef = value;
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
	 * Gets the value of the contentInstanceOrContentInstanceAnncOrContainer
	 * property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the
	 * contentInstanceOrContentInstanceAnncOrContainer property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getContentInstanceOrContentInstanceAnncOrContainer().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link ContentInstance } {@link ContentInstanceAnnc } {@link Container }
	 * {@link ContainerAnnc } {@link Subscription }
	 * 
	 * 
	 */
	public List<Resource> getContentInstanceOrContentInstanceAnncOrContainer() {
		if (contentInstanceOrContentInstanceAnncOrContainer == null) {
			contentInstanceOrContentInstanceAnncOrContainer = new ArrayList<Resource>();
		}
		return this.contentInstanceOrContentInstanceAnncOrContainer;
	}

}
