package com.canhtoanptit.ums;

import com.canhtoanptit.ums.service.UserServiceGrpc;
import com.canhtoanptit.ums.service.UserServiceOuterClass;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class Client {
    public static void main(String[] args) throws Exception {
        final ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
                .usePlaintext(true)
                .build();

        UserServiceGrpc.UserServiceBlockingStub stub = UserServiceGrpc.newBlockingStub(channel);
        UserServiceOuterClass.UserRequest request = UserServiceOuterClass.UserRequest.newBuilder()
                .setApiName("register")
                .setPayload("{}")
                .build();

        UserServiceOuterClass.UserResponse response = stub.register(request);

        System.out.println("Response : " + response.getCode());
        channel.shutdownNow();
    }
}
