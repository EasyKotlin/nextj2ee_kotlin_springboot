<#include '../common/header.ftl'>
<#include '../common/nav.ftl'>

<div class="container">

    <h1> Kotlin + Spring Boot: Next J2EE Development 技术文章 </h1>

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
                return ( <ol>{list}</ol> )
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
                list.push(<li><h5>{e.author} 发表的文章 {e.gmtCreate}</h5></li>)
                list.push(<h4><a href={e.url} target="_blank">{e.title}</a></h4>)
            }
            return list
        }


        ReactDOM.render(<Article source="/article/list"/>,
                document.getElementById('article')
        );
    </script>
</div>

<#include '../common/footer.ftl'>
