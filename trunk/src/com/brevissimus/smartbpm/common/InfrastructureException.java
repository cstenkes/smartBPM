/**
 * 
 */
package com.brevissimus.smartbpm.common;

/**
 *<p>InfrastructureException</p>
 *<p>Created by <a href="mailto:csaba.tenkes@brevissimus.eu">Csaba Tenkes</a>
 *<br/>Date: 2009.05.21.</p>
 */

public class InfrastructureException extends Exception {
    private Throwable exception;
    private String message;
    
    public InfrastructureException(Throwable exception, String message) {
        this.exception = exception;
        this.message = message;
    }
}

