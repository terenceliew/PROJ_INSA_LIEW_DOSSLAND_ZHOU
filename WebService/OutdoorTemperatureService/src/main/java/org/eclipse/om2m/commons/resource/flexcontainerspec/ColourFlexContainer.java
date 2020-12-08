/*
********************************************************************************
 * Copyright (c) 2014, 2018 Orange.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 ********************************************************************************

ModuleClass : Colour

This ModuleClass provides the capabilities to set the value of the Red, Green, and Blue colour channels for a colour device.

Created: 2018-06-29 17:19:52
*/

package org.eclipse.om2m.commons.resource.flexcontainerspec;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.eclipse.om2m.commons.resource.AbstractFlexContainer;
import org.eclipse.om2m.commons.resource.CustomAttribute;

@XmlRootElement(name = ColourFlexContainer.SHORT_NAME, namespace = "http://www.onem2m.org/xml/protocols/homedomain")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = ColourFlexContainer.SHORT_NAME, namespace = "http://www.onem2m.org/xml/protocols/homedomain")
public class ColourFlexContainer extends AbstractFlexContainer {
	
	public static final String LONG_NAME = "colour";
	public static final String SHORT_NAME = "color";
		
	public ColourFlexContainer () {
		setContainerDefinition("org.onem2m.home.moduleclass." + ColourFlexContainer.LONG_NAME);
		setLongName(LONG_NAME);
		setShortName(SHORT_NAME);
		CustomAttribute red = new CustomAttribute();
		red.setLongName("red");
		red.setShortName("red");
		red.setType("xs:integer");
		getCustomAttributes().add(red);
		CustomAttribute green = new CustomAttribute();
		green.setLongName("green");
		green.setShortName("green");
		green.setType("xs:integer");
		getCustomAttributes().add(green);
		CustomAttribute blue = new CustomAttribute();
		blue.setLongName("blue");
		blue.setShortName("blue");
		blue.setType("xs:integer");
		getCustomAttributes().add(blue);
	}

		
	public void finalizeSerialization() {
	}
	
	public void finalizeDeserialization() {
	}
	
}
