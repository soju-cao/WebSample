import React, {Component} from 'react';
import * as switchItemsActions from '../actions/action_dashboard';
import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';

class Dashboard extends Component {

  constructor(props) {
    super(props);
  }

  componentDidMount() {
    this.props.actions.getDashboardSummary();
  }

  render () {
    console.log('render');
    console.log(this.props.dashboardSummary);
    return (
      <html>
      <head>
        <meta http-equiv="Access-Control-Allow-Origin" content="localhost:8080"></meta>
      </head>
      <body>
      <div>
           hello wordfdfdfdf
      </div>
      </body>      
      </html>
    )
  }
}

export default connect(
	state => ({
    dashboardSummary : state.reducer_dashboard.dashboardSummary
})
	, dispatch => ({
  actions: bindActionCreators(switchItemsActions, dispatch)
})
)(Dashboard);
