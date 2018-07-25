var mongoose = require('mongoose');

mongoose.connect('mongodb://192.168.56.103:27017/test', { useNewUrlParser: true });
mongoose.Promise = global.Promise;
var db = mongoose.connection;
db.on('error', console.error.bind(console, 'connection error:'));
db.once('open', function() {
    console.log('we are here');
  });
module.exports = mongoose;