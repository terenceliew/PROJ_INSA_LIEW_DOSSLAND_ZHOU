/*
********************************************************************************
 * Copyright (c) 2014, 2018 Orange.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 ********************************************************************************

ModuleClass : RelativeHumidity

This ModuleClass provides the capability for the device to report the humidity based on a specified rule that is vendor dependent.

Created: 2018-06-29 17:19:53
*/

package org.eclipse.om2m.commons.resource.flexcontainerspec;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.eclipse.om2m.commons.resource.AbstractFlexContainer;
import org.eclipse.om2m.commons.resource.CustomAttribute;

@XmlRootElement(name = RelativeHumidityFlexContainer.SHORT_NAME, namespace = "http://www.onem2m.org/xml/protocols/homedomain")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = RelativeHumidityFlexContainer.SHORT_NAME, namespace = "http://www.onem2m.org/xml/protocols/homedomain")
public class RelativeHumidityFlexContainer extends AbstractFlexContainer {
	
	public static final String LONG_NAME = "relativeHumidity";
	public static final String SHORT_NAME = "relHy";
		
	public RelativeHumidityFlexContainer () {
		setContainerDefinition("org.onem2m.home.moduleclass." + RelativeHumidityFlexContainer.LONG_NAME);
		setLongName(LONG_NAME);
		setShortName(SHORT_NAME);
		CustomAttribute relativeHumidity = new CustomAttribute();
		relativeHumidity.setLongName("relativeHumidity");
		relativeHumidity.setShortName("relHy");
		relativeHumidity.setType("xs:float");
		getCustomAttributes().add(relativeHumidity);
		CustomAttribute desiredHumidity = new CustomAttribute();
		desiredHumidity.setLongName("desiredHumidity");
		desiredHumidity.setShortName("desHy");
		desiredHumidity.setType("xs:float");
		getCustomAttributes().add(desiredHumidity);
	}

		
	public void finalizeSerialization() {
	}
	
	public void finalizeDeserialization() {
	}
	
}
