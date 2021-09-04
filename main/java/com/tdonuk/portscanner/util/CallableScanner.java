/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tdonuk.portscanner.util;

import com.tdonuk.portscanner.dto.Port;
import com.tdonuk.portscanner.dto.ScanRequest;
import com.tdonuk.portscanner.resources.ConstantResources;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.Callable;
import javax.swing.JOptionPane;

/**
 *
 * @author Taha Donuk
 */
public class CallableScanner implements Callable<Port> {

    
    private ScanRequest request;
    private Port port;

    public CallableScanner(ScanRequest request, Port port) {
        this.request = request;
        this.port = port;
    }

    @Override
    public Port call() throws Exception {
        try {
            Socket socket = new Socket();
            socket.connect(new InetSocketAddress(request.getDomain(), port.getNumber()), ConstantResources.timeout);
            socket.close();
            // if the port is closed an exception will be thrown here, otherwise the code will continue working
            port.setOpen(true);
            return port;
        } catch (Exception ex) {
            if(ex instanceof UnknownHostException) {
                JOptionPane.showMessageDialog(null,"Network error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                System.exit(1);
            }
            port.setOpen(false);
            return port;
        }

    }

}
