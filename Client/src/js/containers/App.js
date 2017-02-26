// (C) Copyright 2014-2015 Hewlett Packard Enterprise Development LP

import React, { Component } from 'react';
import App from 'grommet/components/App';


export default class AppSample extends Component {

  render() {
    return (
      <App centered={false}>
        <div>
          {this.props.children}
        </div>
      </App>
    );
  }
}
