package com.canhtoanptit.ums;

import com.canhtoanptit.ums.service.UserServiceImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;

public class UserManagementServiceApplication {

    public static void main(String[] args) throws Exception {
        Server server = ServerBuilder.forPort(8080)
                .addService(new UserServiceImpl())
                .build();

        server.start();
        System.out.println("Server start .....");

        server.awaitTermination();
    }
}
