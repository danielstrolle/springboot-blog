(function ($) {
    var request = $.ajax({'url': '/posts.json'});
    request.done(function (posts) {
        console.log(posts);
        var html = '';
        posts.forEach(function (Post) {
            html += '<div>';
            html += '<h1>' + Post.title + '</h1>';
            html += '<p>' + Post.body + '</p>';
            html += '<p>Published by ' + Post.user.username + '</p>';
            html += '</div>';
        });
        $('#posts').html(html);
    });
})(jQuery);