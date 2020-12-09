/*
********************************************************************************
 * Copyright (c) 2014, 2018 Orange.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 ********************************************************************************

ModuleClass : TimerAnnc

This ModuleClass provides capabilities to monitor and control the times when the appliance executes its operations, that means when it starts, when it ends etc.

Created: 2018-06-29 17:19:54
*/

package org.eclipse.om2m.commons.resource.flexcontainerspec;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.eclipse.om2m.commons.resource.AbstractFlexContainerAnnc;

@XmlRootElement(name = TimerFlexContainerAnnc.SHORT_NAME, namespace = "http://www.onem2m.org/xml/protocols/homedomain")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = TimerFlexContainerAnnc.SHORT_NAME, namespace = "http://www.onem2m.org/xml/protocols/homedomain")
public class TimerFlexContainerAnnc extends AbstractFlexContainerAnnc {
	
	public static final String LONG_NAME = "timerAnnc";
	public static final String SHORT_NAME = "timerAnnc";
	
	public TimerFlexContainerAnnc () {
		setContainerDefinition("org.onem2m.home.moduleclass." + TimerFlexContainer.LONG_NAME);
		setLongName(LONG_NAME);
		setShortName(SHORT_NAME);
	}
		
	public void finalizeSerialization() {
		getActivateClockTimerAnnc();	  
		getDeactivateClockTimerAnnc();	  
	}
	
	public void finalizeDeserialization() {
		if (this.activateClockTimerAnnc != null){
			setActivateClockTimerAnnc(activateClockTimerAnnc);	  
		}
		if (this.deactivateClockTimerAnnc != null){
			setDeactivateClockTimerAnnc(deactivateClockTimerAnnc);	  
		}
	}
	
	@XmlElement(name=ActivateClockTimerFlexContainerAnnc.SHORT_NAME, required=true, type=ActivateClockTimerFlexContainerAnnc.class, namespace="http://www.onem2m.org/xml/protocols/homedomain")
	private ActivateClockTimerFlexContainerAnnc activateClockTimerAnnc;	
	
	public void setActivateClockTimerAnnc(ActivateClockTimerFlexContainerAnnc activateClockTimerAnnc) {
		this.activateClockTimerAnnc = activateClockTimerAnnc;
		getFlexContainerOrContainerOrSubscription().add(activateClockTimerAnnc);
	}
	
	public ActivateClockTimerFlexContainerAnnc getActivateClockTimerAnnc() {
		this.activateClockTimerAnnc = (ActivateClockTimerFlexContainerAnnc) getResourceByName(ActivateClockTimerFlexContainerAnnc.SHORT_NAME);
		return activateClockTimerAnnc;
	}
	@XmlElement(name=DeactivateClockTimerFlexContainerAnnc.SHORT_NAME, required=true, type=DeactivateClockTimerFlexContainerAnnc.class, namespace="http://www.onem2m.org/xml/protocols/homedomain")
	private DeactivateClockTimerFlexContainerAnnc deactivateClockTimerAnnc;	
	
	public void setDeactivateClockTimerAnnc(DeactivateClockTimerFlexContainerAnnc deactivateClockTimerAnnc) {
		this.deactivateClockTimerAnnc = deactivateClockTimerAnnc;
		getFlexContainerOrContainerOrSubscription().add(deactivateClockTimerAnnc);
	}
	
	public DeactivateClockTimerFlexContainerAnnc getDeactivateClockTimerAnnc() {
		this.deactivateClockTimerAnnc = (DeactivateClockTimerFlexContainerAnnc) getResourceByName(DeactivateClockTimerFlexContainerAnnc.SHORT_NAME);
		return deactivateClockTimerAnnc;
	}
	
}
