<#include '../common/header.ftl'>
<#include '../common/nav.ftl'>

<div class="container">

    <section>
        <div id="article"></div>
    </section>

    <script type="text/babel">
        var Article = React.createClass({
            getInitialState: function () {
                return {
                    article: {
                        author: "",
                        title: "",
                        url: "",
                        content: "加载中",
                        gmtCreate: ""
                    }
                };
            },

            componentDidMount: function () {
                this.serverRequest = $.get(this.props.source, function (result) {
                    console.log(result)

                    this.setState({
                        article: result
                    })
                }.bind(this));
            },

            componentWillUnmount: function () {
                this.serverRequest.abort();
            },

            render: function () {
                if (!this.state.article) {
                    return
                }
                return (
                        <div>
                            <h3> {this.state.article.title} </h3>
                            <div> {this.state.article.author} {this.state.article.gmtCreate} </div>
                            <article> {this.state.article.content} </article>
                            <div><a target="_blank" href={this.state.article.url}> {this.state.article.url} </a></div>
                        </div>
                )
            }
        })

        ReactDOM.render(<Article source="/article/${id}"/>, document.getElementById('article'));

    </script>
</div>

<#include '../common/footer.ftl'>
