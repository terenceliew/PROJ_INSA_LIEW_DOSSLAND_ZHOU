/*
********************************************************************************
 * Copyright (c) 2014, 2018 Orange.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 ********************************************************************************

ModuleClass : TelevisionChannelAnnc

This ModuleClass provides capabilities to set and get channels of a device that has a channel list.

Created: 2018-06-29 17:19:54
*/

package org.eclipse.om2m.commons.resource.flexcontainerspec;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.eclipse.om2m.commons.resource.AbstractFlexContainerAnnc;

@XmlRootElement(name = TelevisionChannelFlexContainerAnnc.SHORT_NAME, namespace = "http://www.onem2m.org/xml/protocols/homedomain")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = TelevisionChannelFlexContainerAnnc.SHORT_NAME, namespace = "http://www.onem2m.org/xml/protocols/homedomain")
public class TelevisionChannelFlexContainerAnnc extends AbstractFlexContainerAnnc {
	
	public static final String LONG_NAME = "televisionChannelAnnc";
	public static final String SHORT_NAME = "telClAnnc";
	
	public TelevisionChannelFlexContainerAnnc () {
		setContainerDefinition("org.onem2m.home.moduleclass." + TelevisionChannelFlexContainer.LONG_NAME);
		setLongName(LONG_NAME);
		setShortName(SHORT_NAME);
	}
		
	public void finalizeSerialization() {
		getUpChannelAnnc();	  
		getDownChannelAnnc();	  
	}
	
	public void finalizeDeserialization() {
		if (this.upChannelAnnc != null){
			setUpChannelAnnc(upChannelAnnc);	  
		}
		if (this.downChannelAnnc != null){
			setDownChannelAnnc(downChannelAnnc);	  
		}
	}
	
	@XmlElement(name=UpChannelFlexContainerAnnc.SHORT_NAME, required=true, type=UpChannelFlexContainerAnnc.class, namespace="http://www.onem2m.org/xml/protocols/homedomain")
	private UpChannelFlexContainerAnnc upChannelAnnc;	
	
	public void setUpChannelAnnc(UpChannelFlexContainerAnnc upChannelAnnc) {
		this.upChannelAnnc = upChannelAnnc;
		getFlexContainerOrContainerOrSubscription().add(upChannelAnnc);
	}
	
	public UpChannelFlexContainerAnnc getUpChannelAnnc() {
		this.upChannelAnnc = (UpChannelFlexContainerAnnc) getResourceByName(UpChannelFlexContainerAnnc.SHORT_NAME);
		return upChannelAnnc;
	}
	@XmlElement(name=DownChannelFlexContainerAnnc.SHORT_NAME, required=true, type=DownChannelFlexContainerAnnc.class, namespace="http://www.onem2m.org/xml/protocols/homedomain")
	private DownChannelFlexContainerAnnc downChannelAnnc;	
	
	public void setDownChannelAnnc(DownChannelFlexContainerAnnc downChannelAnnc) {
		this.downChannelAnnc = downChannelAnnc;
		getFlexContainerOrContainerOrSubscription().add(downChannelAnnc);
	}
	
	public DownChannelFlexContainerAnnc getDownChannelAnnc() {
		this.downChannelAnnc = (DownChannelFlexContainerAnnc) getResourceByName(DownChannelFlexContainerAnnc.SHORT_NAME);
		return downChannelAnnc;
	}
	
}
