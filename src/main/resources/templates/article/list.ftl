<#include '../common/header.ftl'>
<#include '../common/nav.ftl'>

<div class="banner">
    <h1> Kotlin + Spring Boot: Next J2EE Development 技术文章 </h1>
</div>

<div class="container">
    <a class="btn-lg btn-primary pull-right" target="_blank" href="/view/article/add">写文章</a>
    <section>
        <article id="article"></article>
    </section>

    <script type="text/babel">
        var Article = React.createClass({
            getInitialState: function () {
                return {
                    author: "I am",
                    title: "This Title",
                    url: "?",
                    content: "Empty"
                };
            },

            componentDidMount: function () {
                this.serverRequest = $.get(this.props.source, function (result) {
                    this.setState({
                        articles: result
                    })
                }.bind(this));
            },

            componentWillUnmount: function () {
                this.serverRequest.abort();
            },

            render: function () {
                var list = getArticleList(this.state.articles)
                return ( <ul>{list}</ul> )
            }

        })

        function getArticleList(articles) {
            if (!articles) {
                return
            }

            var list = []
            var size = articles.length

            for (var i = 0; i < size; i++) {
                var e = articles[i]

                var detailUrl = "/view/article/" + e.id
                list.push(
                        <li>
                            <h3><a href={detailUrl} target="_blank"> {e.title} </a></h3>
                            <div className="text-info">
                                <p>作者:{e.author} {e.gmtCreate}</p>
                                源链接：<a href={e.url} target="_blank">{e.url}</a>
                            </div>
                        </li>
                )
            }
            return list
        }


        ReactDOM.render(<Article source="/article/list"/>,
                document.getElementById('article')
        );
    </script>
</div>

<#include '../common/footer.ftl'>
