package com.dn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Client {
    private final ServiceA serviceA; // Constructor injection
    private ServiceB serviceB; // Setter injection

    @Autowired
    public Client(ServiceA serviceA) { this.serviceA = serviceA; }

    @Autowired
    public void setServiceB(ServiceB serviceB) { this.serviceB = serviceB; }

    public void doWork() {
        serviceA.executeA();
        serviceB.executeB();
    }
}
