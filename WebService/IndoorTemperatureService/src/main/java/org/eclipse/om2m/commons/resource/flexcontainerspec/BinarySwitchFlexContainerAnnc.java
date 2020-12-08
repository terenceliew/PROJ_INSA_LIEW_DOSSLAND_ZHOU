/*
********************************************************************************
 * Copyright (c) 2014, 2018 Orange.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 ********************************************************************************

ModuleClass : BinarySwitchAnnc

This ModuleClass provides capabilities to control and monitor the state of power.

Created: 2018-06-29 17:19:51
*/

package org.eclipse.om2m.commons.resource.flexcontainerspec;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.eclipse.om2m.commons.resource.AbstractFlexContainerAnnc;

@XmlRootElement(name = BinarySwitchFlexContainerAnnc.SHORT_NAME, namespace = "http://www.onem2m.org/xml/protocols/homedomain")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = BinarySwitchFlexContainerAnnc.SHORT_NAME, namespace = "http://www.onem2m.org/xml/protocols/homedomain")
public class BinarySwitchFlexContainerAnnc extends AbstractFlexContainerAnnc {
	
	public static final String LONG_NAME = "binarySwitchAnnc";
	public static final String SHORT_NAME = "binShAnnc";
	
	public BinarySwitchFlexContainerAnnc () {
		setContainerDefinition("org.onem2m.home.moduleclass." + BinarySwitchFlexContainer.LONG_NAME);
		setLongName(LONG_NAME);
		setShortName(SHORT_NAME);
	}
		
	public void finalizeSerialization() {
		getToggleAnnc();	  
	}
	
	public void finalizeDeserialization() {
		if (this.toggleAnnc != null){
			setToggleAnnc(toggleAnnc);	  
		}
	}
	
	@XmlElement(name=ToggleFlexContainerAnnc.SHORT_NAME, required=true, type=ToggleFlexContainerAnnc.class, namespace="http://www.onem2m.org/xml/protocols/homedomain")
	private ToggleFlexContainerAnnc toggleAnnc;	
	
	public void setToggleAnnc(ToggleFlexContainerAnnc toggleAnnc) {
		this.toggleAnnc = toggleAnnc;
		getFlexContainerOrContainerOrSubscription().add(toggleAnnc);
	}
	
	public ToggleFlexContainerAnnc getToggleAnnc() {
		this.toggleAnnc = (ToggleFlexContainerAnnc) getResourceByName(ToggleFlexContainerAnnc.SHORT_NAME);
		return toggleAnnc;
	}
	
}
