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
public class Port {
    private int number;
    private boolean open = false;

    public Port(int number) {
        this.number = number;
    }
    
    // Empty constructor
    public Port() {}

    public int getNumber() {
        return number;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean isOpen) {
        this.open = isOpen;
    }
    
    
}
