import { omit, keys } from 'lodash';
import Route from 'route-parser';
import Url from 'url';
import superagent from 'superagent';
import SuperagentPromisePlugin from 'superagent-promise-plugin';
import I18n from 'i18n-react';
import { Promise } from 'es6-promise';

const request = SuperagentPromisePlugin.patch(superagent);

const verbsToMethods = {
  HEAD: 'head',
  GET: 'get',
  POST: 'post',
  PUT: 'put',
  PATCH: 'patch',
  DELETE: 'del'
};

export default class DataProvider {
  /**
 * @param baseUrl {String}
 */
  constructor(baseUrl) {
    this.baseUrl = baseUrl;
    this.request = request;
  }

  /**
   * @param path {String}
   * @param params {Object}
   * @returns {Promise}
   */
  get(path) {
    return this.callNativeApi({
      path,
      method: 'GET'
    });
  }

  callNativeApi({method, path, params = {}, layerContent = 'application/json'}) {
    if(this.baseUrl == null) {
      console.log('base url is null');
      return new Promise(function (resolve, reject) {});
    }

    let url = this.baseUrl.concat(path);
    let URL = this.baseUrl;
    let result = new Promise(function (resolve, reject) {

      let request = new XMLHttpRequest();
      request.open(method, url, true);
      request.setRequestHeader('Content-Type', layerContent);
      request.send();
      request.onreadystatechange = handler;

      function handler() {
        if ( this.readyState !== 4) return;

        if (this.status == 200) {
          resolve(this.responseText);
        } else {
          reject(new Error(this.statusText));
        }
      }
    });

    return result;
  }
}
