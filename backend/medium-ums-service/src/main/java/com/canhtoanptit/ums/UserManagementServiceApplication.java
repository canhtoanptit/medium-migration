package com.canhtoanptit.ums;

import articles.ArticleOuterClass;
import articles.ArticleServiceGrpc;
import com.canhtoanptit.ums.service.UserServiceImpl;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Server;
import io.grpc.ServerBuilder;

public class UserManagementServiceApplication {

    public static void main(String[] args) throws Exception {
        Server server = ServerBuilder.forPort(8081)
                .addService(new UserServiceImpl())
                .build();

        server.start();
        System.out.println("Server start .....");
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext(true).build();
        ArticleServiceGrpc.ArticleServiceBlockingStub stub = ArticleServiceGrpc.newBlockingStub(channel);
        ArticleOuterClass.Article record = stub.insert(ArticleOuterClass.Article.newBuilder().setTitle("Hello world").setAuthor("toannc").build());
        System.out.println("Author is " + record.getAuthor());
        ArticleOuterClass.ArticleList res = stub.list(ArticleOuterClass.Empty.newBuilder().build());
        System.out.println(res);
        server.awaitTermination();
    }
}
