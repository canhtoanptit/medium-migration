var grpc = require('grpc');

var articleProto = grpc.load('./src/protos/article.proto');

var events  = require('events');
var Article = require('./repository/article.model');

var articleStream = new events.EventEmitter();

var topicService = require('../src/service/topic.service');

test();

async function test() {
    await topicService.addCategory('topics', JSON.stringify({
        abc: {
            hehe: 1,
            hihi: 2
        },
        xyz: 'tinh tinh'
    }));
    console.log(await topicService.getCategoryByKey('topic:a&t:1'));
    console.log(await topicService.getAllCategory());
}

var server = new grpc.Server();
server.addService(articleProto.articles.ArticleService.service, {
    list: function(call, callback) {
        Article.find({}, function(err, articles) {
            if (err) { console.log(err); }
            console.log('article: ', articles);
            const dataRes = articles.map(e => {return {id: e._id.toString(), title: e.title, author: e.author}});
            console.log(dataRes);
            callback(null, dataRes);
        })
    },
    insert: function(call, callback) {
        console.log('call is', call);
        var article = call.request;
        var inst = new Article(article);
        inst.save().then(() => console.log('insert success'));
        articleStream.emit('new_article', article);
        callback(null, {});
    },
    get: function(call, callback) {
        var articleIdRequest = call.request;
        Article.findById(articleIdRequest.id, (err, article) => {
            if (err) { console.log('abc'); }
            callback(null, {id: article._id.toString(), title: article.title, author: article.author})
        });
    }
});

server.bind('0.0.0.0:50051', grpc.ServerCredentials.createInsecure());
server.start();