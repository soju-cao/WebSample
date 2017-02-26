// (C) Copyright 2014-2015 Hewlett Packard Enterprise Development LP

import React from 'react';
import { Route,IndexRoute} from 'react-router';
import AppSample from './containers/App';
import Dashboard from './containers/Dashboard';


export default props => {
  return (
    <Route path="/" component={AppSample}>
      <IndexRoute component={Dashboard} />
      <Route path="dashboard" component={Dashboard} />
    </Route>
  );
};
