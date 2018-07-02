package com.canhtoanptit.ums.service;

import grpc.*;
import io.grpc.stub.StreamObserver;

public class UserServiceImpl extends UserServiceGrpc.UserServiceImplBase {
    @Override
    public void register(Userservice.UserRequest request, StreamObserver<Userservice.UserResponse> responseObserver) {
        System.out.println(request);
        Userservice.UserResponse response = Userservice.UserResponse.newBuilder()
                .setCode(0)
                .setData("{}")
                .setMessage("register ok")
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
