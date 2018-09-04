const redis = require('redis');
const Promise = require('bluebird');
Promise.promisifyAll(redis);
const client = redis.createClient(6379, '192.168.56.103');

client.on("error", function (err) {
    console.log("Error " + err);
});

module.exports = client;