import * as ActionTypes from '../constants/ActionTypes';
import * as CommomConstants from '../constants/CommomConstans';

const initialState = {
  dashboardSummary : []
};

export default function update(state = initialState, action) {

  if (action.type === ActionTypes.GETDASHBOARDSUMMARY) {

    return Object.assign({},
      state,
      {
        dashboardSummary: action.dashboardSummary });
        
  }
  return state;
}



