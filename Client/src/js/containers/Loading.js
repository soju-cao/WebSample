
import React, { Component } from 'react';
import LoadingIcon from './../../image/Loading.png';

export default class Loading extends Component {
  render() {
    return (
      <div className="loadingContainer">
        <img className='loadingLogo' src={LoadingIcon} />
      </div>);
  }
}
