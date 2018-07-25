var mongoose = require('./dbfactory');
var Schema = mongoose.Schema;

var articleSchema = new Schema({
    title: String,
    author: String
});

var Article = mongoose.model('Article', articleSchema);
module.exports = Article;
