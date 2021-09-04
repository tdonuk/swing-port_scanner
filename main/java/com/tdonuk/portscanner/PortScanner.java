/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tdonuk.portscanner;

import com.tdonuk.portscanner.dto.Port;
import com.tdonuk.portscanner.gui.MainScreen;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Taha Donuk
 */
public class PortScanner {

    public static void main(String[] args) {
        try {
            MainScreen gui = new MainScreen();
            gui.setVisible(true);
        } catch (Exception e) {
            System.exit(1);
        }
    }
}
