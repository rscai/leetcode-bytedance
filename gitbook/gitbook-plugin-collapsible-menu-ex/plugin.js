require(["gitbook"], function(gitbook) {
    gitbook.events.bind("page.change", function() {
        $.each($('ul.summary li'), function(i, el){
            var $el = $(el);
            var hasChildren = !!$el.find('ul').length;
            if (hasChildren) {
                $el.addClass('tree');
            }
        });
        $.each($('ul.summary li.active'), function(i, el) {
            while(!(el.parentNode && el.parentNode.tagName.toLowerCase() === 'ul' && el.parentNode.className === 'summary')) {
                el = el.parentNode;
                if (el.tagName.toLowerCase() === 'li') {
                    $(el).addClass('active');
                }
            }
        });

        $('ul.summary li li').hide();
        // $('ul.summary li').find('li.active').parent().children().show();
        $('ul.summary li li.active').parents().children().show();
        $('ul.summary li.active > ul > li').show();
    });
});
