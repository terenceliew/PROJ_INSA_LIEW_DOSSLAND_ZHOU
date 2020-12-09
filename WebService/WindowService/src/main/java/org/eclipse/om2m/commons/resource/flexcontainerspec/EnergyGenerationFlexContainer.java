/*
********************************************************************************
 * Copyright (c) 2014, 2018 Orange.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 ********************************************************************************

ModuleClass : EnergyGeneration

This ModuleClass provides information about generation data on electric generator devices such as a photo voltaic power system, fuel cells, or microgeneration

Created: 2018-06-29 17:19:52
*/

package org.eclipse.om2m.commons.resource.flexcontainerspec;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.eclipse.om2m.commons.resource.AbstractFlexContainer;
import org.eclipse.om2m.commons.resource.CustomAttribute;

@XmlRootElement(name = EnergyGenerationFlexContainer.SHORT_NAME, namespace = "http://www.onem2m.org/xml/protocols/homedomain")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = EnergyGenerationFlexContainer.SHORT_NAME, namespace = "http://www.onem2m.org/xml/protocols/homedomain")
public class EnergyGenerationFlexContainer extends AbstractFlexContainer {
	
	public static final String LONG_NAME = "energyGeneration";
	public static final String SHORT_NAME = "eneGn";
		
	public EnergyGenerationFlexContainer () {
		setContainerDefinition("org.onem2m.home.moduleclass." + EnergyGenerationFlexContainer.LONG_NAME);
		setLongName(LONG_NAME);
		setShortName(SHORT_NAME);
		CustomAttribute generationSource = new CustomAttribute();
		generationSource.setLongName("generationSource");
		generationSource.setShortName("genSe");
		generationSource.setType("xs:string");
		getCustomAttributes().add(generationSource);
		CustomAttribute multiplyingFactors = new CustomAttribute();
		multiplyingFactors.setLongName("multiplyingFactors");
		multiplyingFactors.setShortName("mulFs");
		multiplyingFactors.setType("xs:integer");
		getCustomAttributes().add(multiplyingFactors);
		CustomAttribute significantDigits = new CustomAttribute();
		significantDigits.setLongName("significantDigits");
		significantDigits.setShortName("sigDs");
		significantDigits.setType("xs:integer");
		getCustomAttributes().add(significantDigits);
		CustomAttribute powerGenerationData = new CustomAttribute();
		powerGenerationData.setLongName("powerGenerationData");
		powerGenerationData.setShortName("poGDa");
		powerGenerationData.setType("xs:float");
		getCustomAttributes().add(powerGenerationData);
		CustomAttribute roundingEnergyGeneration = new CustomAttribute();
		roundingEnergyGeneration.setLongName("roundingEnergyGeneration");
		roundingEnergyGeneration.setShortName("roEGn");
		roundingEnergyGeneration.setType("xs:integer");
		getCustomAttributes().add(roundingEnergyGeneration);
	}

		
	public void finalizeSerialization() {
	}
	
	public void finalizeDeserialization() {
	}
	
}
