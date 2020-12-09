/*
********************************************************************************
 * Copyright (c) 2014, 2018 Orange.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 ********************************************************************************

ModuleClass : PersonSensor

This ModuleClass provides the capabilities for detecting/recognizing people.

Created: 2018-06-29 17:19:54
*/

package org.eclipse.om2m.commons.resource.flexcontainerspec;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.eclipse.om2m.commons.resource.AbstractFlexContainer;
import org.eclipse.om2m.commons.resource.CustomAttribute;

@XmlRootElement(name = PersonSensorFlexContainer.SHORT_NAME, namespace = "http://www.onem2m.org/xml/protocols/homedomain")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = PersonSensorFlexContainer.SHORT_NAME, namespace = "http://www.onem2m.org/xml/protocols/homedomain")
public class PersonSensorFlexContainer extends AbstractFlexContainer {
	
	public static final String LONG_NAME = "personSensor";
	public static final String SHORT_NAME = "perSr";
		
	public PersonSensorFlexContainer () {
		setContainerDefinition("org.onem2m.home.moduleclass." + PersonSensorFlexContainer.LONG_NAME);
		setLongName(LONG_NAME);
		setShortName(SHORT_NAME);
		CustomAttribute detectedPersons = new CustomAttribute();
		detectedPersons.setLongName("detectedPersons");
		detectedPersons.setShortName("detPs");
		detectedPersons.setType("[xs:string]");
		getCustomAttributes().add(detectedPersons);
	}

		
	public void finalizeSerialization() {
	}
	
	public void finalizeDeserialization() {
	}
	
}
