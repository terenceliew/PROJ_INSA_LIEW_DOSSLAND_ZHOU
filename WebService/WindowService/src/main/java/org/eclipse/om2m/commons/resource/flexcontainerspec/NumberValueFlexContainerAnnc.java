/*
********************************************************************************
 * Copyright (c) 2014, 2018 Orange.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 ********************************************************************************

ModuleClass : NumberValueAnnc

This ModuleClass provides the capabilities to represent a number. It also has capabilities for controlled increment and decrement a counter. It can be used to present a number-related functionality in a technology where there is only a weak semantic specification of that functionality.

Created: 2018-06-29 17:19:52
*/

package org.eclipse.om2m.commons.resource.flexcontainerspec;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.eclipse.om2m.commons.resource.AbstractFlexContainerAnnc;

@XmlRootElement(name = NumberValueFlexContainerAnnc.SHORT_NAME, namespace = "http://www.onem2m.org/xml/protocols/homedomain")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = NumberValueFlexContainerAnnc.SHORT_NAME, namespace = "http://www.onem2m.org/xml/protocols/homedomain")
public class NumberValueFlexContainerAnnc extends AbstractFlexContainerAnnc {
	
	public static final String LONG_NAME = "numberValueAnnc";
	public static final String SHORT_NAME = "numVeAnnc";
	
	public NumberValueFlexContainerAnnc () {
		setContainerDefinition("org.onem2m.home.moduleclass." + NumberValueFlexContainer.LONG_NAME);
		setLongName(LONG_NAME);
		setShortName(SHORT_NAME);
	}
		
	public void finalizeSerialization() {
		getDecrementNumberValueAnnc();	  
		getIncrementNumberValueAnnc();	  
		getResetNumberValueAnnc();	  
	}
	
	public void finalizeDeserialization() {
		if (this.decrementNumberValueAnnc != null){
			setDecrementNumberValueAnnc(decrementNumberValueAnnc);	  
		}
		if (this.incrementNumberValueAnnc != null){
			setIncrementNumberValueAnnc(incrementNumberValueAnnc);	  
		}
		if (this.resetNumberValueAnnc != null){
			setResetNumberValueAnnc(resetNumberValueAnnc);	  
		}
	}
	
	@XmlElement(name=DecrementNumberValueFlexContainerAnnc.SHORT_NAME, required=true, type=DecrementNumberValueFlexContainerAnnc.class, namespace="http://www.onem2m.org/xml/protocols/homedomain")
	private DecrementNumberValueFlexContainerAnnc decrementNumberValueAnnc;	
	
	public void setDecrementNumberValueAnnc(DecrementNumberValueFlexContainerAnnc decrementNumberValueAnnc) {
		this.decrementNumberValueAnnc = decrementNumberValueAnnc;
		getFlexContainerOrContainerOrSubscription().add(decrementNumberValueAnnc);
	}
	
	public DecrementNumberValueFlexContainerAnnc getDecrementNumberValueAnnc() {
		this.decrementNumberValueAnnc = (DecrementNumberValueFlexContainerAnnc) getResourceByName(DecrementNumberValueFlexContainerAnnc.SHORT_NAME);
		return decrementNumberValueAnnc;
	}
	@XmlElement(name=IncrementNumberValueFlexContainerAnnc.SHORT_NAME, required=true, type=IncrementNumberValueFlexContainerAnnc.class, namespace="http://www.onem2m.org/xml/protocols/homedomain")
	private IncrementNumberValueFlexContainerAnnc incrementNumberValueAnnc;	
	
	public void setIncrementNumberValueAnnc(IncrementNumberValueFlexContainerAnnc incrementNumberValueAnnc) {
		this.incrementNumberValueAnnc = incrementNumberValueAnnc;
		getFlexContainerOrContainerOrSubscription().add(incrementNumberValueAnnc);
	}
	
	public IncrementNumberValueFlexContainerAnnc getIncrementNumberValueAnnc() {
		this.incrementNumberValueAnnc = (IncrementNumberValueFlexContainerAnnc) getResourceByName(IncrementNumberValueFlexContainerAnnc.SHORT_NAME);
		return incrementNumberValueAnnc;
	}
	@XmlElement(name=ResetNumberValueFlexContainerAnnc.SHORT_NAME, required=true, type=ResetNumberValueFlexContainerAnnc.class, namespace="http://www.onem2m.org/xml/protocols/homedomain")
	private ResetNumberValueFlexContainerAnnc resetNumberValueAnnc;	
	
	public void setResetNumberValueAnnc(ResetNumberValueFlexContainerAnnc resetNumberValueAnnc) {
		this.resetNumberValueAnnc = resetNumberValueAnnc;
		getFlexContainerOrContainerOrSubscription().add(resetNumberValueAnnc);
	}
	
	public ResetNumberValueFlexContainerAnnc getResetNumberValueAnnc() {
		this.resetNumberValueAnnc = (ResetNumberValueFlexContainerAnnc) getResourceByName(ResetNumberValueFlexContainerAnnc.SHORT_NAME);
		return resetNumberValueAnnc;
	}
	
}
