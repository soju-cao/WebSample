import '../scss/index.scss';

import React from 'react';
import ReactDOM from 'react-dom';
import { Provider } from 'react-redux';
import { Router, browserHistory } from 'react-router';
import { createStore, combineReducers, applyMiddleware } from 'redux';
import { syncHistoryWithStore, routerReducer } from 'react-router-redux';
// import DevTools from './middleware/DevTools';
// import thunkMiddleware from 'redux-thunk';
// import createLogger from 'redux-logger';

import routes from './routes';
import reducer_dashboard from './reducers/reducer_dashboard';
import thunkMiddleware from 'redux-thunk';
import { AppContainer } from 'react-hot-loader';

const reducer = combineReducers({  
  reducer_dashboard: reducer_dashboard,
  routing: routerReducer
});

const store = createStore(
  reducer,
  //DevTools.instrument(),
  applyMiddleware(thunkMiddleware)
);
const history = syncHistoryWithStore(browserHistory, store);

let element = document.getElementById('content');
const body = (
  <Provider store={store} >
    <div>
      <Router routes={routes()} history={history} />
    </div>
  </Provider>

);
ReactDOM.render(body, element);

document.body.classList.remove('loading');

//Hot Module Replacement API
if (module.hot) {
  module.hot.accept(body, () => {
    const NextApp = require(body).default;
    ReactDOM.render(
      <AppContainer>
        <NextApp/>
      </AppContainer>,
      element
    );
  });
}
