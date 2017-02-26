import * as ActionTypes from '../constants/ActionTypes';
import API from '../services/api';

export function getDashboardSummary() {
  return (dispatch, getstate) => {
    API.getDashboardSummary().then(response => {


      let dataMap = eval('(' + response + ')');
      let resultData = [];

      // for (let key in dataMap) {
      //   resultData.push(dataMap[key]);
      //   if (dataMap[key].connectionStatus) {
      //     dataMap[key].connectionStatus = 'ok';
      //     countOfActive++;
      //   } else {
      //     dataMap[key].connectionStatus = 'critical';
      //     countOfInactive++;
      //   }
      // }

      console.log("in action_probeDashboard");
      console.log(dataMap);
      dispatch({
        type: ActionTypes.GETDASHBOARDSUMMARY,
        dashboardSummary: dataMap,

      });
    }, function (error) {
      console.log(error);
    });
  };
}


