/*******************************************************************************
 * Copyright (c) 2013-2020 LAAS-CNRS (www.laas.fr)
 * 7 Colonel Roche 31077 Toulouse - France
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Initial Contributors:
 *     Thierry Monteil : Project manager, technical co-manager
 *     Mahdi Ben Alaya : Technical co-manager
 *     Samir Medjiah : Technical co-manager
 *     Khalil Drira : Strategy expert
 *     Guillaume Garzone : Developer
 *     François Aïssaoui : Developer
 *
 * New contributors :
 *******************************************************************************/
package org.eclipse.om2m.commons.exceptions;

import org.eclipse.om2m.commons.constants.ResponseStatusCode;
import org.eclipse.om2m.commons.resource.DynAuthTokenReqInfo;

public class AccessDeniedException extends Om2mException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2488820054507430948L;
	
	private DynAuthTokenReqInfo dynAuthTokenReqInfo = null;

	public AccessDeniedException(){
		super("Unknown or unauthorized originator", ResponseStatusCode.ACCESS_DENIED);
	}
	
	public AccessDeniedException(DynAuthTokenReqInfo pDynAuthTokenReqInfo){
		super("Unknown or unauthorized originator", ResponseStatusCode.ACCESS_DENIED);
		dynAuthTokenReqInfo = pDynAuthTokenReqInfo;
	}

	public AccessDeniedException(String message){
		super(message, ResponseStatusCode.ACCESS_DENIED);
	}
	
	public AccessDeniedException(String message, Throwable cause){
		super(message, cause, ResponseStatusCode.ACCESS_DENIED);
	}

	public DynAuthTokenReqInfo getDynAuthTokenReqInfo() {
		return dynAuthTokenReqInfo;
	}

	public void setDynAuthTokenReqInfo(DynAuthTokenReqInfo dynAuthTokenReqInfo) {
		this.dynAuthTokenReqInfo = dynAuthTokenReqInfo;
	}
	
	
	
}

