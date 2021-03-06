/*
********************************************************************************
 * Copyright (c) 2014, 2018 Orange.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 ********************************************************************************

ModuleClass : AudioVolumeAnnc

This ModuleClass provides capabilities to control and monitor volume.

Created: 2018-06-29 17:19:51
*/

package org.eclipse.om2m.commons.resource.flexcontainerspec;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.eclipse.om2m.commons.resource.AbstractFlexContainerAnnc;

@XmlRootElement(name = AudioVolumeFlexContainerAnnc.SHORT_NAME, namespace = "http://www.onem2m.org/xml/protocols/homedomain")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = AudioVolumeFlexContainerAnnc.SHORT_NAME, namespace = "http://www.onem2m.org/xml/protocols/homedomain")
public class AudioVolumeFlexContainerAnnc extends AbstractFlexContainerAnnc {
	
	public static final String LONG_NAME = "audioVolumeAnnc";
	public static final String SHORT_NAME = "audVeAnnc";
	
	public AudioVolumeFlexContainerAnnc () {
		setContainerDefinition("org.onem2m.home.moduleclass." + AudioVolumeFlexContainer.LONG_NAME);
		setLongName(LONG_NAME);
		setShortName(SHORT_NAME);
	}
		
	public void finalizeSerialization() {
		getUpVolumeAnnc();	  
		getDownVolumeAnnc();	  
	}
	
	public void finalizeDeserialization() {
		if (this.upVolumeAnnc != null){
			setUpVolumeAnnc(upVolumeAnnc);	  
		}
		if (this.downVolumeAnnc != null){
			setDownVolumeAnnc(downVolumeAnnc);	  
		}
	}
	
	@XmlElement(name=UpVolumeFlexContainerAnnc.SHORT_NAME, required=true, type=UpVolumeFlexContainerAnnc.class, namespace="http://www.onem2m.org/xml/protocols/homedomain")
	private UpVolumeFlexContainerAnnc upVolumeAnnc;	
	
	public void setUpVolumeAnnc(UpVolumeFlexContainerAnnc upVolumeAnnc) {
		this.upVolumeAnnc = upVolumeAnnc;
		getFlexContainerOrContainerOrSubscription().add(upVolumeAnnc);
	}
	
	public UpVolumeFlexContainerAnnc getUpVolumeAnnc() {
		this.upVolumeAnnc = (UpVolumeFlexContainerAnnc) getResourceByName(UpVolumeFlexContainerAnnc.SHORT_NAME);
		return upVolumeAnnc;
	}
	@XmlElement(name=DownVolumeFlexContainerAnnc.SHORT_NAME, required=true, type=DownVolumeFlexContainerAnnc.class, namespace="http://www.onem2m.org/xml/protocols/homedomain")
	private DownVolumeFlexContainerAnnc downVolumeAnnc;	
	
	public void setDownVolumeAnnc(DownVolumeFlexContainerAnnc downVolumeAnnc) {
		this.downVolumeAnnc = downVolumeAnnc;
		getFlexContainerOrContainerOrSubscription().add(downVolumeAnnc);
	}
	
	public DownVolumeFlexContainerAnnc getDownVolumeAnnc() {
		this.downVolumeAnnc = (DownVolumeFlexContainerAnnc) getResourceByName(DownVolumeFlexContainerAnnc.SHORT_NAME);
		return downVolumeAnnc;
	}
	
}
