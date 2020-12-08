/*
********************************************************************************
 * Copyright (c) 2014, 2018 Orange.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 ********************************************************************************

ModuleClass : PowerSave

This ModuleClass provides capabilities to enable the power saving mode of a device and monitor the current status.

Created: 2018-06-29 17:19:53
*/

package org.eclipse.om2m.commons.resource.flexcontainerspec;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.eclipse.om2m.commons.resource.AbstractFlexContainer;
import org.eclipse.om2m.commons.resource.CustomAttribute;

@XmlRootElement(name = PowerSaveFlexContainer.SHORT_NAME, namespace = "http://www.onem2m.org/xml/protocols/homedomain")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = PowerSaveFlexContainer.SHORT_NAME, namespace = "http://www.onem2m.org/xml/protocols/homedomain")
public class PowerSaveFlexContainer extends AbstractFlexContainer {
	
	public static final String LONG_NAME = "powerSave";
	public static final String SHORT_NAME = "powS0";
		
	public PowerSaveFlexContainer () {
		setContainerDefinition("org.onem2m.home.moduleclass." + PowerSaveFlexContainer.LONG_NAME);
		setLongName(LONG_NAME);
		setShortName(SHORT_NAME);
		CustomAttribute powerSaveEnabled = new CustomAttribute();
		powerSaveEnabled.setLongName("powerSaveEnabled");
		powerSaveEnabled.setShortName("poSEd");
		powerSaveEnabled.setType("xs:boolean");
		getCustomAttributes().add(powerSaveEnabled);
	}

		
	public void finalizeSerialization() {
	}
	
	public void finalizeDeserialization() {
	}
	
}
