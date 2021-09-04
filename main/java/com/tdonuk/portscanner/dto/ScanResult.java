/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tdonuk.portscanner.dto;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Taha Donuk
 */
public class ScanResult {

    private ArrayList<Port> openPorts;
    private Date scanStartDate;
    private Date scanEndDate;
    private double scanTime;
    private String scanTimeText;
    private String scannedAddress;
    private int scannedPortCount;
    private int scanRangeStart = 1; //deault
    private int scanRangeEnd = 65535; //default
    private int threadsCount;

    public ScanResult(ArrayList<Port> openPorts, Date scanStartDate, Date scanEndDate, int scannedPortCount, int threadsCount, String scannedAddress) {
        this.openPorts = openPorts;
        this.scanStartDate = scanStartDate;
        this.scanEndDate = scanEndDate;
        this.scannedPortCount = scannedPortCount;
        this.threadsCount = threadsCount;
        this.scannedAddress = scannedAddress;

        double seconds = (double) Math.abs(scanStartDate.getTime() - scanEndDate.getTime()) / 1000;

        if (seconds > 60) {
            scanTimeText = String.format("%.3f", seconds / 60) + " minutes";
        } else {
            scanTimeText = String.format("%.3f", seconds) + " seconds";
        }

    }

    public String getScannedAddress() {
        return scannedAddress;
    }

    public int getThreadsCount() {
        return threadsCount;
    }

    public void setScanRangeStart(int scanRangeStart) {
        this.scanRangeStart = scanRangeStart;
    }

    public void setScanRangeEnd(int scanRangeEnd) {
        this.scanRangeEnd = scanRangeEnd;
    }

    public ArrayList<Port> getOpenPorts() {
        return openPorts;
    }

    public Date getScanStartDate() {
        return scanStartDate;
    }

    public Date getScanEndDate() {
        return scanEndDate;
    }

    public double getScanTime() {
        return scanTime;
    }

    public String getScanTimeText() {
        return scanTimeText;
    }

    public int getScannedPortCount() {
        return scannedPortCount;
    }

    public int getScanRangeStart() {
        return scanRangeStart;
    }

    public int getScanRangeEnd() {
        return scanRangeEnd;
    }

    SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");

    @Override
    public String toString() {
        String toString = "";

        StringBuilder sb = new StringBuilder(toString);

        String ports = "empty";

        if (getOpenPorts().size() != 0) {
            ports = "[";

            for (Port port : getOpenPorts()) {
                ports = ports + port.getNumber() + ", ";
            }
            
            ports = ports.substring(0, ports.length()-2) + "]";
        }

        sb.append("Your scan request on " + getScannedAddress() + " is completed. The scanner has scanned " + getScannedPortCount() + " ports in " + getScanTimeText()
                + " and found " + getOpenPorts().size()+ " open ports. The following informations are about details of your scan result. You can save your results to a file by clicking 'Save results'")
                .append("\n\n\n")
                .append("Scanned address: " + getScannedAddress())
                .append("\n")
                .append("Scan started at: " + format.format(getScanStartDate()))
                .append("\n")
                .append("Scan finished at: " + format.format(getScanEndDate()))
                .append("\n")
                .append("Scan finished in: " + getScanTimeText())
                .append("\n")
                .append("Ports scanned: " + getScannedPortCount())
                .append("\n")
                .append("Found open port count: " + getOpenPorts().size())
                .append("\n")
                .append("Thread count: " + getThreadsCount())
                .append("\n")
                .append("Open Ports: " + ports)
                .append("\n");

        return sb.toString();
    }

}
