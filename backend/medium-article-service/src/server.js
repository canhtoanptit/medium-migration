var grpc = require('grpc');

var articleProto = grpc.load('./src/article.proto');

var events  = require('events');

var articleStream = new events.EventEmitter();

var articles = [
    {
        id: 123,
        title: 'A tale of two cities',
        author: 'Charles Dickens'
    }
];

var server = new grpc.Server();
server.addService(articleProto.articles.ArticleService.service, {
    list: function(call, callback) {
        callback(null, articles);
    }
});

server.bind('0.0.0.0:50051', grpc.ServerCredentials.createInsecure());
server.start();