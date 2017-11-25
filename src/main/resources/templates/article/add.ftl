<#include '../common/header.ftl'>
<#include '../common/nav.ftl'>

<div class="container">

    <section>
        <div id="article"></div>
    </section>

    <script type="text/babel">
        var Article = React.createClass({
            getInitialState: function () {
                return {}
            },

            componentDidMount: function () {

            },

            handleSumbit(event) {
                event.preventDefault();
                console.log("提交表单...");
            },

            render: function () {
                return (
                        <form className="form" onSubmit={this.handleSumbit.bind(this)}>

                            <div className="form-group col-sm-8">
                                <input type="text" placeholder="标题" ref="author" className="form-control"/>
                            </div>

                            <div className="form-group col-sm-8">
                                <input type="text" placeholder="作者" ref="author" className="form-control"/>
                            </div>

                            <div className="form-group col-sm-8">
                                <textarea id="content" placeholder="正文" className="text-area"></textarea>
                            </div>

                            <div className="form-group col-sm-8">
                                <button type="submit" className="btn btn-primary form-group">
                                    保存
                                </button>
                            </div>
                        </form>
                )
            }
        })

        ReactDOM.render(<Article/>, document.getElementById('article'));
    </script>
</div>

<#include '../common/footer.ftl'>
