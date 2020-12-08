/*
********************************************************************************
 * Copyright (c) 2014, 2018 Orange.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 ********************************************************************************

ModuleClass : Oximeter

This ModuleClass provides the capability to report the measurement of blood oxygen characteristics.

Created: 2018-06-29 17:19:53
*/

package org.eclipse.om2m.commons.resource.flexcontainerspec;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.eclipse.om2m.commons.resource.AbstractFlexContainer;
import org.eclipse.om2m.commons.resource.CustomAttribute;

@XmlRootElement(name = OximeterFlexContainer.SHORT_NAME, namespace = "http://www.onem2m.org/xml/protocols/homedomain")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = OximeterFlexContainer.SHORT_NAME, namespace = "http://www.onem2m.org/xml/protocols/homedomain")
public class OximeterFlexContainer extends AbstractFlexContainer {
	
	public static final String LONG_NAME = "oximeter";
	public static final String SHORT_NAME = "oximr";
		
	public OximeterFlexContainer () {
		setContainerDefinition("org.onem2m.home.moduleclass." + OximeterFlexContainer.LONG_NAME);
		setLongName(LONG_NAME);
		setShortName(SHORT_NAME);
		CustomAttribute oxygenSaturation = new CustomAttribute();
		oxygenSaturation.setLongName("oxygenSaturation");
		oxygenSaturation.setShortName("oxySn");
		oxygenSaturation.setType("xs:integer");
		getCustomAttributes().add(oxygenSaturation);
	}

		
	public void finalizeSerialization() {
	}
	
	public void finalizeDeserialization() {
	}
	
}
