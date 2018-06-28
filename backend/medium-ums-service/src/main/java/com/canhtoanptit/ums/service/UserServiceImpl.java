package com.canhtoanptit.ums.service;

import io.grpc.stub.StreamObserver;

public class UserServiceImpl extends UserServiceGrpc.UserServiceImplBase {
    @Override
    public void register(UserServiceOuterClass.UserRequest request, StreamObserver<UserServiceOuterClass.UserResponse> responseObserver) {
        System.out.println(request);

        UserServiceOuterClass.UserResponse response = UserServiceOuterClass.UserResponse.newBuilder()
                .setCode(0)
                .setData("{}")
                .setMessage("register ok")
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
