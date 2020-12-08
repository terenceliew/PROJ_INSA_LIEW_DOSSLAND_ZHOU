/*
********************************************************************************
 * Copyright (c) 2014, 2018 Orange.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 ********************************************************************************

ModuleClass : FaultDetection

This ModuleClass provides information about whether a fault has occurred in a device.

Created: 2018-06-29 17:19:52
*/

package org.eclipse.om2m.commons.resource.flexcontainerspec;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.eclipse.om2m.commons.resource.AbstractFlexContainer;
import org.eclipse.om2m.commons.resource.CustomAttribute;

@XmlRootElement(name = FaultDetectionFlexContainer.SHORT_NAME, namespace = "http://www.onem2m.org/xml/protocols/homedomain")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = FaultDetectionFlexContainer.SHORT_NAME, namespace = "http://www.onem2m.org/xml/protocols/homedomain")
public class FaultDetectionFlexContainer extends AbstractFlexContainer {
	
	public static final String LONG_NAME = "faultDetection";
	public static final String SHORT_NAME = "fauDn";
		
	public FaultDetectionFlexContainer () {
		setContainerDefinition("org.onem2m.home.moduleclass." + FaultDetectionFlexContainer.LONG_NAME);
		setLongName(LONG_NAME);
		setShortName(SHORT_NAME);
		CustomAttribute code = new CustomAttribute();
		code.setLongName("code");
		code.setShortName("code");
		code.setType("xs:integer");
		getCustomAttributes().add(code);
		CustomAttribute description = new CustomAttribute();
		description.setLongName("description");
		description.setShortName("dc");
		description.setType("xs:string");
		getCustomAttributes().add(description);
		CustomAttribute status = new CustomAttribute();
		status.setLongName("status");
		status.setShortName("sus");
		status.setType("xs:boolean");
		getCustomAttributes().add(status);
	}

		
	public void finalizeSerialization() {
	}
	
	public void finalizeDeserialization() {
	}
	
}
