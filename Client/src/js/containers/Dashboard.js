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
    //console.log(this.props.dashboardSummary);
    return (
      <div>
      hello world
      </div>
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
