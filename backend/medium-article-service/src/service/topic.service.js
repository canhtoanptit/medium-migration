const redisClient = require('../repository/redis.client');

module.exports = {
    addCategory: async function(key, category) {
        return redisClient.hmsetAsync(key, category);
    },
    getCategoryByKey:  async function(key) {
        return redisClient.hgetallAsync(key);
    },
    getAllCategory: async function() {
        return redisClient.scanAsync('0', 'MATCH', 'topic*');
    }
}