/*
********************************************************************************
 * Copyright (c) 2014, 2018 Orange.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 ********************************************************************************

ModuleClass : SteamClosetJobMode

This ModuleClasses provides capabilities to control and monitor the job modes of steamCloset.

Created: 2018-06-29 17:19:54
*/

package org.eclipse.om2m.commons.resource.flexcontainerspec;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.eclipse.om2m.commons.resource.AbstractFlexContainer;
import org.eclipse.om2m.commons.resource.CustomAttribute;

@XmlRootElement(name = SteamClosetJobModeFlexContainer.SHORT_NAME, namespace = "http://www.onem2m.org/xml/protocols/homedomain")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = SteamClosetJobModeFlexContainer.SHORT_NAME, namespace = "http://www.onem2m.org/xml/protocols/homedomain")
public class SteamClosetJobModeFlexContainer extends AbstractFlexContainer {
	
	public static final String LONG_NAME = "steamClosetJobMode";
	public static final String SHORT_NAME = "sCJMe";
		
	public SteamClosetJobModeFlexContainer () {
		setContainerDefinition("org.onem2m.home.moduleclass." + SteamClosetJobModeFlexContainer.LONG_NAME);
		setLongName(LONG_NAME);
		setShortName(SHORT_NAME);
		CustomAttribute currentJobModeName = new CustomAttribute();
		currentJobModeName.setLongName("currentJobModeName");
		currentJobModeName.setShortName("cJMNe");
		currentJobModeName.setType("xs:string");
		getCustomAttributes().add(currentJobModeName);
		CustomAttribute currentJobMode = new CustomAttribute();
		currentJobMode.setLongName("currentJobMode");
		currentJobMode.setShortName("cuJMe");
		currentJobMode.setType("hd:enumSteamClosetJobMode");
		getCustomAttributes().add(currentJobMode);
		CustomAttribute jobModes = new CustomAttribute();
		jobModes.setLongName("jobModes");
		jobModes.setShortName("jobMs");
		jobModes.setType("[hd:enumSteamClosetJobMode]");
		getCustomAttributes().add(jobModes);
	}

		
	public void finalizeSerialization() {
	}
	
	public void finalizeDeserialization() {
	}
	
}
