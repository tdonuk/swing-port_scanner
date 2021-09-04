/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tdonuk.portscanner.dto;

/**
 *
 * @author Taha Donuk
 */
public class ScanRequest {
     private String domain;
     private int startRange = 1;
     private int endRange = 65535;
     private int maxThreads = 20;
     private String status = "ok";

    public ScanRequest(String domain, int start, int end, int maxThreads) {
        this.domain = domain;
        this.startRange = start;
        this.endRange = end;
        this.maxThreads = maxThreads;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    

    public int getMaxThreads() {
        return maxThreads;
    }

    public ScanRequest(String domain) {
        this.domain = domain;
    }
    

    public String getDomain() {
        return domain;
    }

    public int getStartRange() {
        return startRange;
    }

    public int getEndRange() {
        return endRange;
    }

    @Override
    public String toString() {
        return "ScanRequest{" + "domain=" + domain + ", startRange=" + startRange + ", endRange=" + endRange + ", maxThreads=" + maxThreads + '}';
    }
    
    
    
}
