import DataProvider from '../utils/DataProvider';
import * as CommomConstans from '../constants/CommomConstans';

const API_PATHS = {
  GET_DASHBOARD_SUMMARY: '/yc/login'
};

const baseUrl = 'http://localhost:8080'
const dataProvider = new DataProvider(baseUrl);

const getDashboardSummary = () =>
  dataProvider.get(API_PATHS.GET_DASHBOARD_SUMMARY);


function formatUrl(baseUrl, params) {
  let url = baseUrl;
  for (let [key,value] of params) {
    url = url.replace(key,value);
  }

  url = url.replace(/ /g,'%20');
  console.log(url);
  return url;
};

export default {
  getDashboardSummary
};


