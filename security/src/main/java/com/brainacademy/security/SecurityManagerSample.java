package com.brainacademy.security;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.SocketPermission;
import java.security.CodeSource;
import java.security.PermissionCollection;
import java.security.Permissions;
import java.security.Policy;

public class SecurityManagerSample {

    public void setupPolicy() {
        Policy policy = new Policy() {
            @Override
            public PermissionCollection getPermissions(CodeSource codesource) {
                Permissions p = new Permissions();
                p.add(new SocketPermission("*:1024-", "connect, resolve"));
                return p;
            }
        };
        Policy.setPolicy(policy);
    }

    public void setupSecurityManager() {
        SecurityManager securityManager = new SecurityManager();
        System.setSecurityManager(securityManager);
    }

    public void connect() {
        try {
            new ServerSocket(1024);
        } catch (IOException e) {
            System.out.println("Could not listen on port: 1024\r\n" + e.getLocalizedMessage());
            return;
        } catch (RuntimeException e) {
            System.out.println("AccessControlException: " + e.getLocalizedMessage());
            return;
        }
        System.out.println("Listening OK.");
    }

    public void connectWithoutSecurityManager() {
        connect();
    }

    public void connectWithSecurityManager() {
        setupSecurityManager();
        connect();
    }

    public void connectWithCustomPolicy() {
        setupPolicy();
        setupSecurityManager();
        connect();
    }

    public static void main(String[] args) {
        SecurityManagerSample securityManagerSample = new SecurityManagerSample();

//        System.out.print("connectWithoutSecurityManager: ");
//        securityManagerSample.connectWithoutSecurityManager();

//        System.out.print("connectWithSecurityManager: ");
//        securityManagerSample.connectWithSecurityManager();

//        System.out.print("connectWithCustomPolicy: ");
//        securityManagerSample.connectWithCustomPolicy();
    }
}
