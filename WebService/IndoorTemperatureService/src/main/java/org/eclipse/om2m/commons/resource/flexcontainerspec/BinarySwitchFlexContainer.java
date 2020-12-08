/*
********************************************************************************
 * Copyright (c) 2014, 2018 Orange.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 ********************************************************************************

ModuleClass : BinarySwitch

This ModuleClass provides capabilities to control and monitor the state of power.

Created: 2018-06-29 17:19:51
*/

package org.eclipse.om2m.commons.resource.flexcontainerspec;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.eclipse.om2m.commons.resource.AbstractFlexContainer;
import org.eclipse.om2m.commons.resource.CustomAttribute;

@XmlRootElement(name = BinarySwitchFlexContainer.SHORT_NAME, namespace = "http://www.onem2m.org/xml/protocols/homedomain")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = BinarySwitchFlexContainer.SHORT_NAME, namespace = "http://www.onem2m.org/xml/protocols/homedomain")
public class BinarySwitchFlexContainer extends AbstractFlexContainer {
	
	public static final String LONG_NAME = "binarySwitch";
	public static final String SHORT_NAME = "binSh";
		
	public BinarySwitchFlexContainer () {
		setContainerDefinition("org.onem2m.home.moduleclass." + BinarySwitchFlexContainer.LONG_NAME);
		setLongName(LONG_NAME);
		setShortName(SHORT_NAME);
		CustomAttribute powerState = new CustomAttribute();
		powerState.setLongName("powerState");
		powerState.setShortName("powSe");
		powerState.setType("xs:boolean");
		getCustomAttributes().add(powerState);
	}


	@XmlElement(name=ToggleFlexContainer.SHORT_NAME, required=true, type=ToggleFlexContainer.class, namespace="http://www.onem2m.org/xml/protocols/homedomain")
	private ToggleFlexContainer toggle;
	
	public ToggleFlexContainer getToggle() {
		this.toggle = (ToggleFlexContainer) getResourceByName(ToggleFlexContainer.SHORT_NAME);
		return toggle;
	}
	
	public void setToggle(ToggleFlexContainer newAction) {
		this.toggle = newAction;
		getFlexContainerOrContainerOrSubscription().add(toggle);
	}
		
	public void finalizeSerialization() {
		getToggle();
	}
	
	public void finalizeDeserialization() {
		if (this.toggle != null) {
			setToggle(this.toggle);
		}
	}
	
}
