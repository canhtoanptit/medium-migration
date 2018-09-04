const redisClient = require('../repository/redis.client');

module.exports = {
    addCategory: async function(category) {
        return redisClient.hmsetAsync('test', {
            user: 1,
            pass: 2
        });
    },
    getAllCategory:  async function() {
        return redisClient.hgetallAsync('test');
    }
}